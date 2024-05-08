package org.example.repository;

import org.example.model.Person;

import java.sql.SQLException;

public interface PersonRepository {

    boolean addPersonToDB(Person Person) throws SQLException;
}
