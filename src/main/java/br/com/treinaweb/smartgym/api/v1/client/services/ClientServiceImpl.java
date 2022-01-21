package br.com.treinaweb.smartgym.api.v1.client.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.treinaweb.smartgym.api.v1.client.dtos.ClientRequest;
import br.com.treinaweb.smartgym.api.v1.client.dtos.ClienteResponse;
import br.com.treinaweb.smartgym.api.v1.client.mappers.ClientMapper;
import br.com.treinaweb.smartgym.api.v1.user.services.UserService;
import br.com.treinaweb.smartgym.api.v1.workoutsheet.dtos.WorkoutSheetResponse;
import br.com.treinaweb.smartgym.api.v1.workoutsheet.mappers.WorkoutSheetMapper;
import br.com.treinaweb.smartgym.core.repositories.ClientRepository;
import br.com.treinaweb.smartgym.core.repositories.WorkoutSheetRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final UserService userService;
    private final ClientMapper clientMapper;
    private final ClientRepository clientRepository;
    private final WorkoutSheetMapper workoutSheetMapper;
    private final WorkoutSheetRepository workoutSheetRepository;

    @Override
    public ClienteResponse create(ClientRequest clientRequest) {
        var clientToCreate = clientMapper.toModel(clientRequest);
        var createdUser = userService.createClient(clientToCreate.getUser());
        clientToCreate.setUser(createdUser);
        var createdClient = clientRepository.save(clientToCreate);
        return clientMapper.toResponse(createdClient);
    }

    @Override
    public List<WorkoutSheetResponse> findClientWorkoutSheets(Long clientId) {
        var foundClient = clientRepository.findByIdOrElseThrow(clientId);
        return workoutSheetRepository.findByClient(foundClient)
            .stream()
            .map(workoutSheetMapper::toResponse)
            .toList();
    }

}
