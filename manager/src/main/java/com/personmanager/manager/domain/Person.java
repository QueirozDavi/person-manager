package com.personmanager.manager.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.personmanager.manager.domain.audit.UserDateAudit;
import com.personmanager.manager.util.DateVerifier;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@Entity
@Table(name = "PERSON", uniqueConstraints = {@UniqueConstraint(columnNames = {"email", "cpf"})})
public class Person extends UserDateAudit {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "GENDER")
    private char gender;

    @Email
    @Column(name = "EMAIL")
    private String email;

    @NotNull
    @Column(name = "BIRTH_DATE", nullable = false)
    private Date birthDate;

    @CPF
    @Size(max = 11, min = 11)
    @NotNull
    @Column(name = "CPF", length = 11, unique = true, nullable = false)
    private String cpf;

    @Column(name = "BIRTH_PLACE")
    private String birthPlace;

    @Column(name = "NATIONALITY")
    private String nationality;

}
