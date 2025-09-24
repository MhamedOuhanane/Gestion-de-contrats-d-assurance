package app.repository.interfaces;

import app.model.Client;
import app.model.Person;

import java.sql.SQLException;

public interface PersonRepository {
    Person createPerson(Person person) throws SQLException;
//    Person createPerson(Person person) throws SQLException;
}
