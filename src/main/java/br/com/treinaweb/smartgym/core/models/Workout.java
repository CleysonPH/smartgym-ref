package br.com.treinaweb.smartgym.core.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Workout {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true)
    private Double load;

    @Column(nullable = true)
    private Integer frequency;

    @Column(nullable = true)
    private Integer series;

    @Column(nullable = true)
    private Integer rest;

    @Column(nullable = true)
    private String observations;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Exercise exercise;

    @ManyToOne
    @JoinColumn(nullable = false)
    private WorkoutSheet workoutSheet;

    @Override
    public String toString() {
        return "Workout [exercise=" + exercise.getName() + ", frequency=" + frequency + ", id=" + id + ", load=" + load
                + ", series=" + series + "]";
    }

}
