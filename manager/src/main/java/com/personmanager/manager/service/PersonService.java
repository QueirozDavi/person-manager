package com.personmanager.manager.service;

import com.personmanager.manager.domain.Person;
import com.personmanager.manager.exception.ForbiddenException;
import com.personmanager.manager.exception.NotFoundException;
import com.personmanager.manager.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private final PersonRepository repository;

    @Autowired
    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }


    public Person createPerson(Person person) {
        return repository.save(person);
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
