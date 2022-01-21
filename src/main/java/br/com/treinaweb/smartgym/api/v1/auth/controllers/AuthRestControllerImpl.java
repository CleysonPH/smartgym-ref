package br.com.treinaweb.smartgym.api.v1.auth.controllers;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.treinaweb.smartgym.api.v1.auth.dtos.CredentialsRequest;
import br.com.treinaweb.smartgym.api.v1.auth.dtos.RefreshRequest;
import br.com.treinaweb.smartgym.api.v1.auth.dtos.TokenResponse;
import br.com.treinaweb.smartgym.api.v1.auth.routes.AuthRoutes;
import br.com.treinaweb.smartgym.api.v1.auth.services.AuthService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AuthRestControllerImpl implements AuthRestController {

    private final AuthService authService;

    @Override
    @PostMapping(AuthRoutes.TOKEN_ROUTE)
    public TokenResponse token(@RequestBody @Valid CredentialsRequest credentialsRequest) {
        return authService.token(credentialsRequest);
    }

    @Override
    @PostMapping(AuthRoutes.REFRESH_ROUTE)
    public TokenResponse refresh(@RequestBody @Valid RefreshRequest refreshRequest) {
        return authService.refresh(refreshRequest);
    }

}
