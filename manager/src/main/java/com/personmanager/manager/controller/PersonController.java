package com.personmanager.manager.controller;

import com.personmanager.manager.domain.Person;
import com.personmanager.manager.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/v1/person")
public class PersonController implements MVCController{


    private final PersonService service;

    @Autowired
    public PersonController(PersonService service) {
        this.service = service;
    }

    @GetMapping()
    public Page<Person> getPersons(@RequestParam( value = "name", required = false) String name, Pageable pageable){
        return service.getPersons(name, pageable);
    }

    @GetMapping("{/id}")
    public Person getPerson(@PathVariable Long id) {
        return service.getPersonById(id);
    }

    @PostMapping
    public Person createPerson(@Valid @RequestBody Person person) {
        return service.createPerson(person);
    }

    @PutMapping("{/id}")
    public Person updatePerson(@Valid @RequestBody Person person, @PathVariable Long id) {
        return service.updatePerson(id, person);
    }

    @DeleteMapping
    public void deletePerson(@PathVariable Long id) {
        service.deletePerson(id);
    }
}
