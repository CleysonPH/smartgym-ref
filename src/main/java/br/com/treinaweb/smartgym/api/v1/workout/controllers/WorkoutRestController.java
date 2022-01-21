package br.com.treinaweb.smartgym.api.v1.workout.controllers;

import br.com.treinaweb.smartgym.api.v1.common.dtos.ErrorResponse;
import br.com.treinaweb.smartgym.api.v1.workout.dtos.WorkoutRequest;
import br.com.treinaweb.smartgym.api.v1.workout.dtos.WorkoutResponse;
import br.com.treinaweb.smartgym.core.config.SwaggerConfig;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@Api(tags = SwaggerConfig.TAG_WORKOUT)
public interface WorkoutRestController {

    @ApiOperation("Cadastrar novo treino")
    @ApiResponse(responseCode = "201", description = "Treino cadastrado com sucesso")
    @ApiResponse(responseCode = "400", description = "Houveram erros de validação", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    @ApiResponse(responseCode = "401", description = "Usuário não está autenticado", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    @ApiResponse(responseCode = "403", description = "Usuário autenticado não tem acesso à esse recurso", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    WorkoutResponse create(WorkoutRequest workoutRequest);

    @ApiOperation("Buscar treino por id")
    @ApiResponse(responseCode = "200", description = "Treino encontrado com sucesso")
    @ApiResponse(responseCode = "401", description = "Usuário não está autenticado", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    @ApiResponse(responseCode = "403", description = "Usuário autenticado não tem acesso à esse recurso", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    @ApiResponse(responseCode = "404", description = "Treino não encontrado", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    WorkoutResponse findById(Long workoutId);

    @ApiOperation("Atualizar treino por id")
    @ApiResponse(responseCode = "200", description = "Treino atualizado com sucesso")
    @ApiResponse(responseCode = "400", description = "Houveram erros de validação", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    @ApiResponse(responseCode = "401", description = "Usuário não está autenticado", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    @ApiResponse(responseCode = "403", description = "Usuário autenticado não tem acesso à esse recurso", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    @ApiResponse(responseCode = "404", description = "Treino não encontrado", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    WorkoutResponse updateById(Long workoutId, WorkoutRequest workoutRequest);

    void deleteById(Long workoutId);

}
