package br.com.treinaweb.smartgym.api.v1.client.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.treinaweb.smartgym.api.v1.client.dtos.ClientRequest;
import br.com.treinaweb.smartgym.api.v1.client.dtos.ClienteResponse;
import br.com.treinaweb.smartgym.api.v1.client.routes.ClientRoutes;
import br.com.treinaweb.smartgym.api.v1.client.services.ClientService;
import br.com.treinaweb.smartgym.api.v1.workoutsheet.dtos.WorkoutSheetResponse;
import br.com.treinaweb.smartgym.core.permissions.SmartGymPermissions;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ClientRestControllerImpl implements ClientRestController {

    private final ClientService clientService;

    @Override
    @SmartGymPermissions.isAdmin
    @PostMapping(ClientRoutes.CREATE_ROUTE)
    @ResponseStatus(code = HttpStatus.CREATED)
    public ClienteResponse create(@RequestBody @Valid ClientRequest clientRequest) {
        return clientService.create(clientRequest);
    }

    @Override
    @SmartGymPermissions.isAdminOrInstructorOrClientItself
    @GetMapping(ClientRoutes.FIND_WORKOUTSHEETS_BY_CLIENT_ID)
    public List<WorkoutSheetResponse> findClientWorkoutSheets(
        @PathVariable Long clientId
    ) {
        return clientService.findClientWorkoutSheets(clientId);
    }

}
