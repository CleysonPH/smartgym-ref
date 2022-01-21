package br.com.treinaweb.smartgym.core.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.treinaweb.smartgym.core.exceptions.UserNotFoundException;
import br.com.treinaweb.smartgym.core.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByEmail(String email);

    Optional<User> findByEmail(String email);

    boolean existsByIdAndEmail(Long id, String email);

    default User findByEmailOrElseThrow(String email) {
        return this.findByEmail(email)
            .orElseThrow(UserNotFoundException::new);
    }

}
