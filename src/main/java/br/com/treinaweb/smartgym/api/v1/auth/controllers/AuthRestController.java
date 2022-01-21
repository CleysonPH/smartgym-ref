package br.com.treinaweb.smartgym.api.v1.auth.controllers;

import br.com.treinaweb.smartgym.api.v1.auth.dtos.CredentialsRequest;
import br.com.treinaweb.smartgym.api.v1.auth.dtos.RefreshRequest;
import br.com.treinaweb.smartgym.api.v1.auth.dtos.TokenResponse;
import br.com.treinaweb.smartgym.api.v1.common.dtos.ErrorResponse;
import br.com.treinaweb.smartgym.core.config.SwaggerConfig;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@Api(tags = SwaggerConfig.TAG_AUTH)
public interface AuthRestController {

    @ApiOperation("Realiza a autenticação de um usuário a partir das credenciais")
    @ApiResponse(responseCode = "200", description = "Autenticação realizada com sucesso")
    @ApiResponse(responseCode = "401", description = "Erro ao realizar autenticação", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    TokenResponse token(CredentialsRequest credentialsRequest);

    @ApiOperation("Realiza a autenticação de um usuário a partir do refresh token")
    @ApiResponse(responseCode = "200", description = "Autenticação realizada com sucesso")
    @ApiResponse(responseCode = "401", description = "Erro ao realizar autenticação", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    TokenResponse refresh(RefreshRequest refreshRequest);

}
