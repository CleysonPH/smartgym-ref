package br.com.treinaweb.smartgym.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.treinaweb.smartgym.core.exceptions.WorkoutNotFoundException;
import br.com.treinaweb.smartgym.core.models.Workout;

public interface WorkoutRepository extends JpaRepository<Workout, Long> {

    boolean existsByIdAndWorkoutSheetClientUserEmail(Long id, String workoutSheetClientUserEmail);

    default Workout findByIdOrElseThrow(Long id) {
        return this.findById(id)
            .orElseThrow(WorkoutNotFoundException::new);
    }

}
