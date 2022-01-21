package br.com.treinaweb.smartgym.core.exceptions;

import javax.persistence.EntityNotFoundException;

public class WorkoutNotFoundException extends EntityNotFoundException {

    public WorkoutNotFoundException() {
        super("Treino não econtrado");
    }

    public WorkoutNotFoundException(String message) {
        super(message);
    }

}
