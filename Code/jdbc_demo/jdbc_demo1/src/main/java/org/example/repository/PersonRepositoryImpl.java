package org.example.repository;

import org.example.config.DataBaseConnectionManager;
import org.example.model.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonRepositoryImpl implements PersonRepository{
    private Connection conn;

    // constructor
    public PersonRepositoryImpl() throws SQLException {
        conn = DataBaseConnectionManager.getConnection();
    }

    @Override
    public boolean addPersonToDB(Person person) throws SQLException {
        String sql = "INSERT INTO person (ID, name) VALUES (?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, person.getID());
        stmt.setString(2, person.getName());
        int result = stmt.executeUpdate();
        return result > 0;
    }

    @Override
    public ResultSet selectAllPersons() throws SQLException {
        String sql = "SELECT * FROM person";
        return conn.createStatement().executeQuery(sql);
    }
}
