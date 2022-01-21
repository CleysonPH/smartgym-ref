package br.com.treinaweb.smartgym.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.treinaweb.smartgym.core.exceptions.ExerciseNotFoundException;
import br.com.treinaweb.smartgym.core.models.Exercise;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {

    default Exercise findByIdOrElseThrow(Long id) {
        return this.findById(id)
            .orElseThrow(ExerciseNotFoundException::new);
    }

}
