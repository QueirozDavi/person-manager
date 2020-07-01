package com.personmanager.manager.config;

import com.personmanager.manager.domain.Person;
import com.personmanager.manager.domain.dto.PersonDTO;
import com.personmanager.manager.exception.BadRequestException;
import org.modelmapper.ModelMapper;
import org.modelmapper.Converter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper getModelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addConverter(getMaptoPersonMapper(), PersonDTO.class, Person.class);

        return modelMapper;
    }

    private Converter<PersonDTO, Person> getMaptoPersonMapper(){
        return context ->{
            PersonDTO source = context.getSource();
            Person person = new Person();

            try {
                person.setBirthDate(parseDate(source.getBirthDate()));
            } catch (ParseException e) {
                e.printStackTrace();
            }

            person.setBirthPlace(source.getBirthPlace());
            person.setCpf(source.getCpf());
            person.setEmail(source.getEmail());
            person.setName(source.getName());
            person.setGender(source.getGender());
            person.setNationality(source.getNationality());

            return person;
        };
    }

    private Date parseDate(String dateStr) throws ParseException{

        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        format.setLenient(false);

        return format.parse(dateStr);
    }
}
