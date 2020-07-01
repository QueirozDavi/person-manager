package com.personmanager.manager.service;

import com.personmanager.manager.domain.Person;
import com.personmanager.manager.domain.dto.PersonDTO;
import com.personmanager.manager.exception.BadRequestException;
import com.personmanager.manager.exception.ForbiddenException;
import com.personmanager.manager.exception.NotFoundException;
import com.personmanager.manager.repository.PersonRepository;
import com.personmanager.manager.util.DateVerifier;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private final PersonRepository repository;
    private final ModelMapper mapper;
    private final DateVerifier dateVerifier;

    @Autowired
    public PersonService(PersonRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
        dateVerifier = new DateVerifier();
    }


    public Person createPerson(PersonDTO personDTO) {

        if(repository.existsByCpf(personDTO.getCpf()))
            throw new BadRequestException("This CPF already used.");

        dateVerifier.verifyDate(personDTO.getBirthDate());

        return repository.save(mapper.map(personDTO, Person.class));
    }

    public Person updatePerson(Long id, Person person) {

        if (id.equals(person.getId()))
            throw new ForbiddenException("Id parameter must be the same id of person request body.");

        if (repository.existsById(person.getId()))
            return repository.save(person);
        else
            throw new NotFoundException("Person not found");
    }

    public Person getPersonById(Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Person not found"));
    }

    public Page<Person> getPersons(String name, Pageable pageable) {
        return repository.findByNameIgnoreCaseContaining(name, pageable);
    }

    public void deletePerson(Long id) {

        if (repository.existsById(id))
            repository.deleteById(id);
        else
            throw new NotFoundException("Person not found");
    }

}
