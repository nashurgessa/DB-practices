package org.example.service;

import org.example.config.DatabaseConnectionManager;
import org.example.model.Person;
import org.example.repository.PersonRepository;
import org.example.repository.PersonRepositoryImp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.example.config.DatabaseConnectionManager.getConnection;

public class PersonService {

    // Private Constructor
    private PersonService() throws SQLException {
    }

    private static PersonService instance;

    public static synchronized PersonService getInstance() throws SQLException {
        if (instance == null) {
            instance = new PersonService();
        }
        return instance;
    }

    //
    PersonRepository repository = new PersonRepositoryImp();

    // Business methods
    public void addPerson(String ID, String name){
        Person person = new Person(ID, name);
        repository.addPerson(person);
    }

    public ResultSet getPersonList() throws SQLException {
        return repository.getAllPersonsInfo();
    }

    public void addPerson(String ID, String name, String mother, String father){

    }

    public Person getPerson(int id) {
        // Logic to get a person
        return null;  // Assuming implementation exists
    }

    public void updatePerson(Person person) {
        // Logic to update a person
    }

    public void deletePerson(int id) {
        // Logic to delete a person
    }


}
