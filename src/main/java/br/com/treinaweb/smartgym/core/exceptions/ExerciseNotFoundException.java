package br.com.treinaweb.smartgym.core.exceptions;

import javax.persistence.EntityNotFoundException;

public class ExerciseNotFoundException extends EntityNotFoundException {

    public ExerciseNotFoundException() {
        super("Exercicio não econtrado");
    }

    public ExerciseNotFoundException(String message) {
        super(message);
    }

}
