package com.personmanager.manager.asserts;

import com.personmanager.manager.domain.Person;
import com.personmanager.manager.domain.User;
import com.personmanager.manager.domain.dto.PersonDTO;
import org.assertj.core.api.AbstractAssert;

public class PersonAssert extends AbstractAssert<PersonAssert, Person> {

	public PersonAssert(Person actual) {
		super(actual, PersonAssert.class);
	}

	public static PersonAssert assertThat(Person actual) {
	    return new PersonAssert(actual);
	}
	
	public PersonAssert EqualsTo(Person expected) {
		isNotNull();
		
		if(!actual.getName().equals(expected.getName()))
			 failWithMessage("Expected Person to have name %s", expected.getName());
		
		if(!actual.getId().equals(expected.getId()))
			 failWithMessage("Expected Person to have id %s", expected.getId());

		if(!actual.getBirthDate().equals(expected.getBirthDate()))
			failWithMessage("Expected Person to have BirthDate %s", expected.getBirthDate());

		if(!actual.getBirthPlace().equals(expected.getBirthPlace()))
			failWithMessage("Expected Person to have BirthPlace %s", expected.getBirthPlace());

		if(!actual.getEmail().equals(expected.getEmail()))
			failWithMessage("Expected Person to have Email %s", expected.getEmail());

		if(!actual.getNationality().equals(expected.getNationality()))
			failWithMessage("Expected Person to have Nationality %s", expected.getNationality());

		if(!actual.getCpf().equals(expected.getCpf()))
			failWithMessage("Expected Person to have CPF %s", expected.getCpf());
		
		return this;
	}
	
}
