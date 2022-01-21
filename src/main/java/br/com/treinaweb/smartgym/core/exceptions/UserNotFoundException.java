package br.com.treinaweb.smartgym.core.exceptions;

import javax.persistence.EntityNotFoundException;

public class UserNotFoundException extends EntityNotFoundException {

    public UserNotFoundException() {
        super("Usuário não encontrado");
    }

    public UserNotFoundException(String message) {
        super(message);
    }

}
