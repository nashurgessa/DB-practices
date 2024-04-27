package org.example.repository;

import org.example.model.Person;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface PersonRepository {
    void addPerson(Person person);

    ResultSet getAllPersonsInfo() throws SQLException;
}
