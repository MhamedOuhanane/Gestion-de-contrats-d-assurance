package app.repository.interfaces;

import app.model.Person;

import java.sql.SQLException;

public interface PersonRepository {
    Person createPerson(Person person);
    Boolean deletePerson(Person person);
}
