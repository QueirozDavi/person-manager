package com.personmanager.manager.databuilder.builder;

import com.personmanager.manager.config.DTOMapper;
import com.personmanager.manager.domain.Person;
import com.personmanager.manager.domain.User;
import com.personmanager.manager.domain.dto.UserDTO;

import java.sql.Date;
import java.time.Instant;

public class PersonBuilder {

    private Person person;

    public PersonBuilder() {
        person = new Person();
        person.setEmail("fabianasandramelo_@l3ambiental.com.br");
        person.setName("Fabiana Sandra Melo");
        person.setNationality("Brasileira");
        person.setBirthPlace("Olinda");
        person.setBirthDate(Date.from(Instant.now()));
        person.setCreatedAt(Instant.now());
        person.setCreatedBy(1L);
        person.setUpdatedAt(Instant.now());
        person.setUpdatedBy(1L);
    }

    public Person build(){
        return person;
    }

    public PersonBuilder withCorrectCPF() {
        person.setCpf("91723908088");
        return this;
    }

    public PersonBuilder withIncorrectCPF() {
        person.setCpf("91723908081");
        return this;
    }

    public PersonBuilder withId() {
        person.setId(1L);
        return this;
    }

}
