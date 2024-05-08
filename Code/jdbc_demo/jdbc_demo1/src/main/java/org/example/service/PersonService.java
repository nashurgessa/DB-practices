package org.example.service;

import org.example.model.Person;
import org.example.repository.PersonRepository;
import org.example.repository.PersonRepositoryImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonService {
    PersonRepository repository;
    // constructor
    private PersonService() throws SQLException {
        repository = new PersonRepositoryImpl();
    }

    private static PersonService instance;
    public static PersonService getInstance() throws SQLException {
        if (instance == null) {
            instance = new PersonService();
        }

        return instance;
    }

    public boolean createPerson(String ID, String name) throws SQLException {
        Person newPerson = new Person(ID, name);
        return repository.addPersonToDB(newPerson);
    }

    public ResultSet getAllPersonList() throws SQLException {
        return repository.selectAllPersons();
    }

}
