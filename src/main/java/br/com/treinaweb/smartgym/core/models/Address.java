package br.com.treinaweb.smartgym.core.models;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;

@Data
@Entity
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Address {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String publicPlace;

    @Column(nullable = false, length = 8)
    private String zipCode;

    @Column(nullable = false, length = 5)
    private String number;

    @Column(nullable = false)
    private String neighborhood;

    @Column(nullable = false, length = 30)
    private String city;

    @Column(nullable = false, length = 2)
    private String state;

    @Column(nullable = true)
    private String complement;

    @Override
    public String toString() {
        return new StringBuilder()
            .append(publicPlace)
            .append(", n° ")
            .append(number)
            .append(", ")
            .append(complement)
            .append(" - ")
            .append(neighborhood)
            .append(". ")
            .append(state)
            .append(" - ")
            .append(city)
            .append(". CEP: ")
            .append(zipCode)
            .toString();
    }

}
