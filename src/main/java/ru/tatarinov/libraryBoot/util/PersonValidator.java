package ru.tatarinov.libraryBoot.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.tatarinov.libraryBoot.models.Person;
import ru.tatarinov.libraryBoot.services.PeopleService;


@Component
public class PersonValidator implements Validator {

    private final PeopleService peopleService;

    @Autowired
    public PersonValidator(PeopleService peopleService) {
        this.peopleService = peopleService;
    }


    @Override
    public boolean supports(Class<?> aClass) {
        return Person.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Person person = (Person) o;

        if (peopleService.getPersonFindByName(person.getName()).isPresent()) {
            errors.rejectValue("name", "500", "Человек с таким ФИО уже существует");
        }
    }
}
