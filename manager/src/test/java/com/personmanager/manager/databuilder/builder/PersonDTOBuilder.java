package com.personmanager.manager.databuilder.builder;

import com.personmanager.manager.domain.dto.PersonDTO;

import java.sql.Date;
import java.time.Instant;

public class PersonDTOBuilder {

    private PersonDTO personDTO;

    public PersonDTOBuilder() {
        personDTO = new PersonDTO();
        personDTO.setEmail("fabianasandramelo_@l3ambiental.com.br");
        personDTO.setName("Fabiana Sandra Melo");
        personDTO.setNationality("Brasileira");
        personDTO.setBirthPlace("Olinda");
    }

    public PersonDTO build(){
        return personDTO;
    }

    public PersonDTOBuilder withCorrectCPF() {
        personDTO.setCpf("91723908088");
        return this;
    }

    public PersonDTOBuilder withIncorrectCPF() {
        personDTO.setCpf("91723908081");
        return this;
    }

    public PersonDTOBuilder withCorrectBirthDate() {
        personDTO.setBirthDate("25/12/2009");
        return this;
    }

    public PersonDTOBuilder withIncorrectBirthDate() {
        personDTO.setBirthDate("31/02/2009");
        return this;
    }

    public PersonDTOBuilder withId() {
        personDTO.setId(1L);
        return this;
    }
}
