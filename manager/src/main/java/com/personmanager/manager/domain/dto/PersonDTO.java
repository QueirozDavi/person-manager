package com.personmanager.manager.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PersonDTO {

    private Long id;

    private String name;

    private char gender;

    @Email
    private String email;

    @NotNull
    private String birthDate;

    @CPF
    @Size(max = 11, min = 11)
    @NotNull
    private String cpf;

    private String birthPlace;

    private String nationality;
}
