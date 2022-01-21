package br.com.treinaweb.smartgym.api.v1.client.controllers;

import java.util.List;

import br.com.treinaweb.smartgym.api.v1.client.dtos.ClientRequest;
import br.com.treinaweb.smartgym.api.v1.client.dtos.ClienteResponse;
import br.com.treinaweb.smartgym.api.v1.common.dtos.ErrorResponse;
import br.com.treinaweb.smartgym.api.v1.workoutsheet.dtos.WorkoutSheetResponse;
import br.com.treinaweb.smartgym.core.config.SwaggerConfig;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@Api(tags = SwaggerConfig.TAG_CLIENT)
public interface ClientRestController {

    @ApiOperation("Cadastrar novo cliente")
    @ApiResponse(responseCode = "201", description = "Cliente foi cadastrado com sucesso")
    @ApiResponse(responseCode = "400", description = "Houveram erros de validação", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    @ApiResponse(responseCode = "401", description = "Usuário não está autenticado", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    @ApiResponse(responseCode = "403", description = "Usuário autenticado não tem acesso à esse recurso", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    ClienteResponse create(ClientRequest clientRequest);

    @ApiOperation("Listar a fichas de treino de um cliente")
    @ApiResponse(responseCode = "200", description = "Listagem realizada com sucesso")
    @ApiResponse(responseCode = "401", description = "Usuário não está autenticado", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    @ApiResponse(responseCode = "403", description = "Usuário autenticado não tem acesso à esse recurso", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    @ApiResponse(responseCode = "404", description = "Cliente não encontrado", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    List<WorkoutSheetResponse> findClientWorkoutSheets(Long clientId);

}
