package br.com.treinaweb.smartgym.api.v1.auth.dtos;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TokenResponse {

    private String access;
    private String refresh;
    private LocalDateTime accessExpiresAt;
    private LocalDateTime refreshExpiresAt;
    private String tokenType;

}
