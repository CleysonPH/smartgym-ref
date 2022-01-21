package br.com.treinaweb.smartgym.api.v1.client.services;

import java.util.List;

import br.com.treinaweb.smartgym.api.v1.client.dtos.ClientRequest;
import br.com.treinaweb.smartgym.api.v1.client.dtos.ClienteResponse;
import br.com.treinaweb.smartgym.api.v1.workoutsheet.dtos.WorkoutSheetResponse;

public interface ClientService {

    ClienteResponse create(ClientRequest clientRequest);

    List<WorkoutSheetResponse> findClientWorkoutSheets(Long clientId);

}
