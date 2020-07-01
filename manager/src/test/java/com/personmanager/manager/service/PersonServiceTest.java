package com.personmanager.manager.service;

import com.personmanager.manager.databuilder.builder.PersonBuilder;
import com.personmanager.manager.databuilder.builder.PersonDTOBuilder;
import com.personmanager.manager.databuilder.builder.UserBuilder;
import com.personmanager.manager.domain.Person;
import com.personmanager.manager.domain.dto.PersonDTO;
import com.personmanager.manager.exception.BadRequestException;
import com.personmanager.manager.exception.NotFoundException;
import com.personmanager.manager.repository.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

import static com.personmanager.manager.asserts.PersonAssert.assertThat;
import static com.personmanager.manager.util.Constants.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    private Person person;
    private PersonDTO personDTO;
    private Long id = 123L;

    @InjectMocks
    private PersonService service;
    @Mock
    private PersonRepository personRepository;
    @Mock
    ModelMapper modelMapper;

    @BeforeEach
    void setUp() {
        person = new PersonBuilder().withId().withCorrectCPF().build();
        personDTO = new PersonDTOBuilder().withCorrectCPF().build();
    }

    @Test
    void shouldExceptionWhePersonNotFound() {
        when(personRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () ->   service.getPersonById(id),
                PERSON_NOT_FOUND_ERROR_MESSAGE );
    }

    @Test
    void shouldNotCreateWhenCpfExists() {
        when(personRepository.existsByCpf(personDTO.getCpf())).thenReturn(Boolean.TRUE);

        assertThrows(BadRequestException.class, () ->   service.createPerson(personDTO),
                CPF_ALREADY_USED_ERROR_MESSAGE );
    }

    @Test
    void shouldNotCreateWhenDateHaveIncorrectFormat() {
        PersonDTO personDTO = new PersonDTOBuilder()
                .withId()
                .withCorrectCPF()
                .withIncorrectBirthDate()
                .build();

        assertThrows(BadRequestException.class, () ->   service.createPerson(personDTO),
                DATE_VERIFIER_BAD_REQUEST_MESSAGE );
    }

    @Test
    void shouldCreateWhenDateCorrectFormatAndCpfDontExists() {
        PersonDTO personDTO = new PersonDTOBuilder()
                .withCorrectCPF()
                .withCorrectBirthDate()
                .build();

         when(modelMapper.map(personDTO, Person.class)).thenReturn(person);
         when(service.createPerson(personDTO)).thenReturn(person);

         Person p = service.createPerson(personDTO);

        assertThat(person).EqualsTo(p);
    }
}
