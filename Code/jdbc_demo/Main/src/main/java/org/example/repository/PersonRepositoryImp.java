package org.example.repository;

import org.example.config.DatabaseConnectionManager;
import org.example.model.Person;

import java.sql.*;

public class PersonRepositoryImp implements PersonRepository{
    Connection conn = DatabaseConnectionManager.getConnection();

    public PersonRepositoryImp() throws SQLException {}

    @Override
    public void addPerson(Person person) {
        String sql = "INSERT INTO person (id, name, mother, father) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, person.getID());
            stmt.setString(2, person.getName());
            stmt.setString(3, person.getMother());
            stmt.setString(4, person.getFather());
            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Adding person failed, no rows affected.");
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
            // Consider rethrowing exception or implementing another error handling strategy
        }
    }


    @Override
    public ResultSet getAllPersonsInfo() throws SQLException {
        String sql = "SELECT * FROM person";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        return rs;
    }

    @Override
    public boolean deletePerson(String ID) {
        String sql = "DELETE FROM person WHERE id = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, ID);
            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean updatePerson(String ID, Person person) {
        String sql = "UPDATE person SET name = ?, mother = ?, father = ? WHERE id = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, person.getName());
            stmt.setString(2, person.getMother());
            stmt.setString(3, person.getFather());
            stmt.setString(4, ID);
            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

}
