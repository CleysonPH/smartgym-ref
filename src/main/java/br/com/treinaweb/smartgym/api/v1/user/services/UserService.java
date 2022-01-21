package br.com.treinaweb.smartgym.api.v1.user.services;

import br.com.treinaweb.smartgym.core.models.User;

public interface UserService {

    User createAdmin(User user);

    User createInstructor(User user);

    User createClient(User user);

}
