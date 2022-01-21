package br.com.treinaweb.smartgym.core.repositories;

import static br.com.treinaweb.smartgym.core.specifications.WorkoutSheetSpecifications.*;
import static org.springframework.data.jpa.domain.Specification.*;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import br.com.treinaweb.smartgym.core.enums.WorkoutSheetStatus;
import br.com.treinaweb.smartgym.core.exceptions.WorkoutSheetNotFoundException;
import br.com.treinaweb.smartgym.core.models.Client;
import br.com.treinaweb.smartgym.core.models.Instructor;
import br.com.treinaweb.smartgym.core.models.WorkoutSheet;
import br.com.treinaweb.smartgym.core.queryfilters.WorkoutSheetQueryFilter;

public interface WorkoutSheetRepository extends
    JpaRepository<WorkoutSheet, Long>,
    JpaSpecificationExecutor<WorkoutSheet>
{
    List<WorkoutSheet> findByClient(Client client);

    List<WorkoutSheet> findByInstructor(Instructor instructor);

    boolean existsByIdAndStatus(Long id, WorkoutSheetStatus status);

    boolean existsByIdAndClientUserEmail(Long id, String clientUserEmail);

    boolean existsByIdAndInstructorUserEmail(Long id, String instructorUserEmail);

    default WorkoutSheet findByIdOrElseThrow(Long id) {
        return this.findById(id)
            .orElseThrow(WorkoutSheetNotFoundException::new);
    }

    default List<WorkoutSheet> findWithQueryFilter(WorkoutSheetQueryFilter workoutSheetQueryFilter) {
        return findAll(
            where(
                withNameContains(workoutSheetQueryFilter.getName())
                .and(withStatusEqualTo(workoutSheetQueryFilter.getStatus()))
                .and(withClientNameContains(workoutSheetQueryFilter.getClient()))
                .and(withEndLessThanOrEqualTo(workoutSheetQueryFilter.getEndLte()))
                .and(withEndGreaterThanOrEqualTo(workoutSheetQueryFilter.getEndGte()))
                .and(withStartLessThanOrEqualTo(workoutSheetQueryFilter.getStartLte()))
                .and(withInstructorNameContains(workoutSheetQueryFilter.getInstructor()))
                .and(withStartGreaterThanOrEqualTo(workoutSheetQueryFilter.getStartGte()))
            )
        );
    }
}
