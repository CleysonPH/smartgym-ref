package br.com.treinaweb.smartgym.core.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.treinaweb.smartgym.core.exceptions.InstructorNotFoundException;
import br.com.treinaweb.smartgym.core.models.Instructor;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {

    boolean existsByCpf(String cpf);

    Optional<Instructor> findByUserEmail(String userEmail);

    boolean existsByIdAndUserEmail(Long id, String userEmail);

    default Instructor findByIdOrElseThrow(Long id) {
        return this.findById(id)
            .orElseThrow(InstructorNotFoundException::new);
    }

    default Instructor findByUserEmailOrElseThrow(String userEmail) {
        return this.findByUserEmail(userEmail)
            .orElseThrow(InstructorNotFoundException::new);
    }

}
