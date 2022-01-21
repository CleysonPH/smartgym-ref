package br.com.treinaweb.smartgym.core.services.token.adapters;

import java.time.LocalDateTime;

public interface TokenService {

    String generateAccessToken(String subject);

    String generateRefreshToken(String subject);

    String getSubjectFromAccessToken(String accessToken);

    String getSubjectFromRefreshToken(String refreshToken);

    LocalDateTime getExpirationFromAccessToken(String accessToken);

    LocalDateTime getExpirationFromRefreshToken(String refreshToken);

}
