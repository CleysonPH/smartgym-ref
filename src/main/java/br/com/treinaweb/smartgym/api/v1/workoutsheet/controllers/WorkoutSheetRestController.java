package br.com.treinaweb.smartgym.api.v1.workoutsheet.controllers;

import java.util.List;

import br.com.treinaweb.smartgym.api.v1.common.dtos.ErrorResponse;
import br.com.treinaweb.smartgym.api.v1.workoutsheet.dtos.WorkoutSheetRequest;
import br.com.treinaweb.smartgym.api.v1.workoutsheet.dtos.WorkoutSheetResponse;
import br.com.treinaweb.smartgym.api.v1.workoutsheet.queryfilters.WorkoutSheetQueryFilterImpl;
import br.com.treinaweb.smartgym.core.config.SwaggerConfig;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@Api(tags = SwaggerConfig.TAG_WORKOUTSHEET)
public interface WorkoutSheetRestController {

    @ApiOperation("Cadastrar nova ficha de treino")
    @ApiResponse(responseCode = "201", description = "Ficha de treino cadastrada com sucesso")
    @ApiResponse(responseCode = "400", description = "Houveram erros de validação", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    @ApiResponse(responseCode = "401", description = "Usuário não está autenticado", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    @ApiResponse(responseCode = "403", description = "Usuário autenticado não tem acesso à esse recurso", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    WorkoutSheetResponse create(WorkoutSheetRequest workoutSheetRequest);

    @ApiOperation("Listar todos as fichas de treino cadastradas")
    @ApiResponse(responseCode = "200", description = "Listagem realizada com sucesso")
    @ApiResponse(responseCode = "401", description = "Usuário não está autenticado", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    @ApiResponse(responseCode = "403", description = "Usuário autenticado não tem acesso à esse recurso", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    List<WorkoutSheetResponse> findAll(WorkoutSheetQueryFilterImpl workoutSheetQueryFilter);

    @ApiOperation("Buscar uma ficha de treino por id")
    @ApiResponse(responseCode = "200", description = "Ficha de treino encontrada com sucesso")
    @ApiResponse(responseCode = "401", description = "Usuário não está autenticado", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    @ApiResponse(responseCode = "403", description = "Usuário autenticado não tem acesso à esse recurso", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    @ApiResponse(responseCode = "404", description = "Ficha de treino não encontrada", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    WorkoutSheetResponse findById(Long workoutSheetId);

    @ApiOperation("Buscar uma ficha de treino por id")
    @ApiResponse(responseCode = "204", description = "Ficha de treino excluida com sucesso")
    @ApiResponse(responseCode = "401", description = "Usuário não está autenticado", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    @ApiResponse(responseCode = "403", description = "Usuário autenticado não tem acesso à esse recurso", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    @ApiResponse(responseCode = "404", description = "Ficha de treino não encontrada", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    void deleteById(Long workoutSheetId);

    WorkoutSheetResponse updateById(Long workoutSheetId, WorkoutSheetRequest workoutSheetRequest);

}
