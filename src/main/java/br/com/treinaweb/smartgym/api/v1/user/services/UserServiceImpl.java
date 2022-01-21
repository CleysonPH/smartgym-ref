package br.com.treinaweb.smartgym.api.v1.user.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.treinaweb.smartgym.core.enums.Role;
import br.com.treinaweb.smartgym.core.models.User;
import br.com.treinaweb.smartgym.core.repositories.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User createAdmin(User user) {
        user.setRole(Role.ADMIN);
        return create(user);
    }

    @Override
    public User createInstructor(User user) {
        user.setRole(Role.INSTRUCTOR);
        return create(user);
    }

    @Override
    public User createClient(User user) {
        user.setRole(Role.CLIENT);
        return create(user);
    }

    private User create(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

}
