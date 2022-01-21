package br.com.treinaweb.smartgym.core.exceptions;

import javax.persistence.EntityNotFoundException;

public class WorkoutSheetNotFoundException extends EntityNotFoundException {

    public WorkoutSheetNotFoundException() {
        super("Ficha de treino não encontrada");
    }

    public WorkoutSheetNotFoundException(String message) {
        super(message);
    }

}
