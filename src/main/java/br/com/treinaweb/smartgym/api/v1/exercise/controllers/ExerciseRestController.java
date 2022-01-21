package br.com.treinaweb.smartgym.api.v1.exercise.controllers;

import java.util.List;

import br.com.treinaweb.smartgym.api.v1.common.dtos.ErrorResponse;
import br.com.treinaweb.smartgym.api.v1.exercise.dtos.ExerciseRequest;
import br.com.treinaweb.smartgym.api.v1.exercise.dtos.ExerciseResponse;
import br.com.treinaweb.smartgym.api.v1.exercise.dtos.ExerciseSummaryResponse;
import br.com.treinaweb.smartgym.core.config.SwaggerConfig;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@Api(tags = SwaggerConfig.TAG_EXERCISE)
public interface ExerciseRestController {

    @ApiOperation("Cadastrar novo exercício")
    @ApiResponse(responseCode = "201", description = "Exercício cadastrado com sucesso")
    @ApiResponse(responseCode = "400", description = "Houveram erros de validação", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    @ApiResponse(responseCode = "401", description = "Usuário não está autenticado", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    @ApiResponse(responseCode = "403", description = "Usuário autenticado não tem acesso à esse recurso", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    ExerciseResponse create(ExerciseRequest exerciseRequest);

    @ApiOperation("Listar todos os exercícios cadastrados")
    @ApiResponse(responseCode = "200", description = "Listagem realizada com sucesso")
    @ApiResponse(responseCode = "401", description = "Usuário não está autenticado", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    @ApiResponse(responseCode = "403", description = "Usuário autenticado não tem acesso à esse recurso", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    List<ExerciseSummaryResponse> findAll();

    @ApiOperation("Buscar exercício por id")
    @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso")
    @ApiResponse(responseCode = "401", description = "Usuário não está autenticado", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    @ApiResponse(responseCode = "403", description = "Usuário autenticado não tem acesso à esse recurso", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    @ApiResponse(responseCode = "404", description = "Exercício não encontrado", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    ExerciseResponse findById(Long exerciseId);

    @ApiOperation("Atualizar exercício por id")
    @ApiResponse(responseCode = "200", description = "Atualizalção realizada com sucesso")
    @ApiResponse(responseCode = "400", description = "Houveram erros de validação", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    @ApiResponse(responseCode = "401", description = "Usuário não está autenticado", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    @ApiResponse(responseCode = "403", description = "Usuário autenticado não tem acesso à esse recurso", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    @ApiResponse(responseCode = "404", description = "Exercício não encontrado", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    ExerciseResponse updateById(Long exerciseId, ExerciseRequest exerciseRequest);

    @ApiOperation("Excluir exercício por id")
    @ApiResponse(responseCode = "204", description = "Exclusão realizada com sucesso")
    @ApiResponse(responseCode = "401", description = "Usuário não está autenticado", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    @ApiResponse(responseCode = "403", description = "Usuário autenticado não tem acesso à esse recurso", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    @ApiResponse(responseCode = "404", description = "Exercício não encontrado", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    void deleteById(Long exerciseId);

}
