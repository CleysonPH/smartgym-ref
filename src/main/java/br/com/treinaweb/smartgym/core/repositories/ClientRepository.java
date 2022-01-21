package br.com.treinaweb.smartgym.core.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.treinaweb.smartgym.core.exceptions.ClientNotFoundException;
import br.com.treinaweb.smartgym.core.models.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

    boolean existsByCpf(String cpf);

    boolean existsByIdAndCpf(Long id, String cpf);

    Optional<Client> findByUserEmail(String userEmail);

    boolean existsByIdAndUserEmail(Long id, String userEmail);

    default Client findByIdOrElseThrow(Long id) {
        return this.findById(id)
            .orElseThrow(ClientNotFoundException::new);
    }

    default Client findByUserEmailOrElseThrow(String userEmail) {
        return this.findByUserEmail(userEmail)
            .orElseThrow(ClientNotFoundException::new);
    }

}
