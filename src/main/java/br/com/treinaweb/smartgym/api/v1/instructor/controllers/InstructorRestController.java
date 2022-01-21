package br.com.treinaweb.smartgym.api.v1.instructor.controllers;

import java.util.List;

import br.com.treinaweb.smartgym.api.v1.common.dtos.ErrorResponse;
import br.com.treinaweb.smartgym.api.v1.instructor.dtos.InstructorRequest;
import br.com.treinaweb.smartgym.api.v1.instructor.dtos.InstructorResponse;
import br.com.treinaweb.smartgym.api.v1.workoutsheet.dtos.WorkoutSheetResponse;
import br.com.treinaweb.smartgym.core.config.SwaggerConfig;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@Api(tags = SwaggerConfig.TAG_INSTRUCTOR)
public interface InstructorRestController {

    @ApiOperation("Cadastrar novo instrutor")
    @ApiResponse(responseCode = "201", description = "Instrutor criado com sucesso")
    @ApiResponse(responseCode = "400", description = "Houveram erros de validação", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    @ApiResponse(responseCode = "401", description = "Usuário não está autenticado", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    @ApiResponse(responseCode = "403", description = "Usuário autenticado não tem acesso à esse recurso", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    InstructorResponse create(InstructorRequest instructorRequest);

    List<WorkoutSheetResponse> findInstructorWorkoutSheets(Long instructorId);

}
