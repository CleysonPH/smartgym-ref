package br.com.treinaweb.smartgym.core.specifications;

import java.time.LocalDate;

import javax.persistence.criteria.JoinType;

import org.springframework.data.jpa.domain.Specification;

import br.com.treinaweb.smartgym.core.enums.WorkoutSheetStatus;
import br.com.treinaweb.smartgym.core.models.Client_;
import br.com.treinaweb.smartgym.core.models.WorkoutSheet;
import br.com.treinaweb.smartgym.core.models.WorkoutSheet_;

public class WorkoutSheetSpecifications {

    public static Specification<WorkoutSheet> withNameContains(String value) {
        return (root, query, criteriaBuilder) -> {
            if (value == null || value.isEmpty()) {
                return criteriaBuilder.and();
            }
            var nameLowerCase = criteriaBuilder.lower(root.get(WorkoutSheet_.name));
            return criteriaBuilder.like(nameLowerCase, "%" + value.toLowerCase() + "%");
        };
    }

    public static Specification<WorkoutSheet> withStatusEqualTo(WorkoutSheetStatus value) {
        return (root, query, criteriaBuilder) -> {
            if (value == null) {
                return criteriaBuilder.and();
            }
            return criteriaBuilder.equal(root.get(WorkoutSheet_.status), value);
        };
    }

    public static Specification<WorkoutSheet> withStartGreaterThanOrEqualTo(LocalDate value) {
        return (root, query, criteriaBuilder) -> {
            if (value == null) {
                return criteriaBuilder.and();
            }
            return criteriaBuilder.greaterThanOrEqualTo(root.get(WorkoutSheet_.start), value);
        };
    }

    public static Specification<WorkoutSheet> withStartLessThanOrEqualTo(LocalDate value) {
        return (root, query, criteriaBuilder) -> {
            if (value == null) {
                return criteriaBuilder.and();
            }
            return criteriaBuilder.lessThanOrEqualTo(root.get(WorkoutSheet_.start), value);
        };
    }

    public static Specification<WorkoutSheet> withEndGreaterThanOrEqualTo(LocalDate value) {
        return (root, query, criteriaBuilder) -> {
            if (value == null) {
                return criteriaBuilder.and();
            }
            return criteriaBuilder.greaterThanOrEqualTo(root.get(WorkoutSheet_.end), value);
        };
    }

    public static Specification<WorkoutSheet> withEndLessThanOrEqualTo(LocalDate value) {
        return (root, query, criteriaBuilder) -> {
            if (value == null) {
                return criteriaBuilder.and();
            }
            return criteriaBuilder.lessThanOrEqualTo(root.get(WorkoutSheet_.end), value);
        };
    }

    public static Specification<WorkoutSheet> withClientNameContains(String value) {
        return (root, query, criteriaBuilder) -> {
            if (value == null || value.isEmpty()) {
                return criteriaBuilder.and();
            }
            var clientJoin = root.join(WorkoutSheet_.client, JoinType.LEFT);
            var clientNameLowerCase = criteriaBuilder.lower(clientJoin.get(Client_.name));
            return criteriaBuilder.like(clientNameLowerCase, "%" + value.toLowerCase() + "%");
        };
    }

    public static Specification<WorkoutSheet> withInstructorNameContains(String value) {
        return (root, query, criteriaBuilder) -> {
            if (value == null || value.isEmpty()) {
                return criteriaBuilder.and();
            }
            var instructorJoin = root.join(WorkoutSheet_.instructor, JoinType.LEFT);
            var instructorNameLowerCase = criteriaBuilder.lower(instructorJoin.get(Client_.name));
            return criteriaBuilder.like(instructorNameLowerCase, "%" + value.toLowerCase() + "%");
        };
    }

}
