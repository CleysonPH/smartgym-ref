package br.com.treinaweb.smartgym.core.exceptions;

import javax.persistence.EntityNotFoundException;

public class InstructorNotFoundException extends EntityNotFoundException {

    public InstructorNotFoundException() {
        super("Instrutor não encontrado");
    }

    public InstructorNotFoundException(String message) {
        super(message);
    }

}
