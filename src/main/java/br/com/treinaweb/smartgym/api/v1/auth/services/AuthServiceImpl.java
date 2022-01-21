package br.com.treinaweb.smartgym.api.v1.auth.services;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import br.com.treinaweb.smartgym.api.v1.auth.dtos.CredentialsRequest;
import br.com.treinaweb.smartgym.api.v1.auth.dtos.RefreshRequest;
import br.com.treinaweb.smartgym.api.v1.auth.dtos.TokenResponse;
import br.com.treinaweb.smartgym.core.services.authentication.adapters.AuthenticationService;
import br.com.treinaweb.smartgym.core.services.token.adapters.TokenService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final TokenService tokenService;
    private final AuthenticationService authenticationService;
    private final AuthenticationManager authenticationManager;

    @Override
    public TokenResponse token(CredentialsRequest credentialsRequest) {
        var email = credentialsRequest.getEmail();
        var password = credentialsRequest.getPassword();
        var authentication = new UsernamePasswordAuthenticationToken(email, password);
        authenticationManager.authenticate(authentication);
        return createTokenResponseFromEmail(email);
    }

    @Override
    public TokenResponse refresh(RefreshRequest refreshRequest) {
        var refreshToken = refreshRequest.getRefresh();
        var email = tokenService.getSubjectFromRefreshToken(refreshToken);
        authenticationService.loadUserByUsername(email);
        return createTokenResponseFromEmail(email);
    }

    private TokenResponse createTokenResponseFromEmail(String email) {
        var access = tokenService.generateAccessToken(email);
        var refresh = tokenService.generateRefreshToken(email);
        return TokenResponse.builder()
            .access(access)
            .refresh(refresh)
            .accessExpiresAt(tokenService.getExpirationFromAccessToken(access))
            .refreshExpiresAt(tokenService.getExpirationFromRefreshToken(refresh))
            .tokenType("Bearer")
            .build();
    }

}
