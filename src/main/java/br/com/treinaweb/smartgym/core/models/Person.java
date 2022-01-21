package br.com.treinaweb.smartgym.core.models;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@MappedSuperclass
@NoArgsConstructor
public abstract class Person {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, length = 11, unique = true)
    private String cpf;

    @Column(nullable = false)
    private LocalDate birthDate;

    @Column(nullable = false, length = 11)
    private String phone;

    @JoinColumn(nullable = false)
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Address address;

    @OneToOne
    @JoinColumn(nullable = false)
    private User user;

}
