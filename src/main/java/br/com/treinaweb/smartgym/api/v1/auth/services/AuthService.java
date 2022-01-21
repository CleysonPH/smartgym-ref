package br.com.treinaweb.smartgym.api.v1.auth.services;

import br.com.treinaweb.smartgym.api.v1.auth.dtos.CredentialsRequest;
import br.com.treinaweb.smartgym.api.v1.auth.dtos.RefreshRequest;
import br.com.treinaweb.smartgym.api.v1.auth.dtos.TokenResponse;

public interface AuthService {

    TokenResponse token(CredentialsRequest credentialsRequest);

    TokenResponse refresh(RefreshRequest refreshRequest);

}
