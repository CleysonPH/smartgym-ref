package br.com.treinaweb.smartgym.core.filters;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.treinaweb.smartgym.api.v1.common.dtos.ErrorResponse;
import br.com.treinaweb.smartgym.core.services.authentication.adapters.AuthenticationService;
import br.com.treinaweb.smartgym.core.services.token.adapters.TokenService;
import br.com.treinaweb.smartgym.core.services.token.exceptions.TokenServiceException;
import br.com.treinaweb.smartgym.core.utils.SecurityUtils;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AccessTokenRequestFilter extends OncePerRequestFilter {

    private static final String TOKEN_TYPE = "Bearer ";

    private final ObjectMapper objectMapper;
    private final TokenService tokenService;
    private final SecurityUtils securityUtils;
    private final AuthenticationService authenticationService;

    @Override
    protected void doFilterInternal(
        HttpServletRequest request,
        HttpServletResponse response,
        FilterChain filterChain
    ) throws ServletException, IOException {
        try {
            tryDoFilterInternal(request, response, filterChain);
        } catch (TokenServiceException exception) {
            var status = HttpStatus.UNAUTHORIZED;
            var body = ErrorResponse.builder()
                .status(status.value())
                .message(exception.getLocalizedMessage())
                .cause(exception.getClass().getSimpleName())
                .timestamp(LocalDateTime.now())
                .path(request.getRequestURI())
                .build();
            response.setStatus(status.value());
            response.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
            response.setCharacterEncoding(StandardCharsets.UTF_8.name());
            response.getWriter().write(objectMapper.writeValueAsString(body));
        }
    }

    private void tryDoFilterInternal(
        HttpServletRequest request,
        HttpServletResponse response,
        FilterChain filterChain
    ) throws ServletException, IOException {
        var email = "";
        var authorizarionHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (isTokenPresent(authorizarionHeader)) {
            var accessToken = authorizarionHeader.substring(TOKEN_TYPE.length());
            email = tokenService.getSubjectFromAccessToken(accessToken);
        }
        if (isEmailNotInContext(email)) {
            addEmailInContext(email, request);
        }
        filterChain.doFilter(request, response);
    }

    private void addEmailInContext(String email, HttpServletRequest request) {
        var user = authenticationService.loadUserByUsername(email);
        var authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        securityUtils.setAuthentication(authentication);
    }

    private boolean isEmailNotInContext(String email) {
        return !email.isEmpty() && securityUtils.getAuthentication() == null;
    }

    private boolean isTokenPresent(String authorizarionHeader) {
        return authorizarionHeader != null && authorizarionHeader.startsWith(TOKEN_TYPE);
    }

}
