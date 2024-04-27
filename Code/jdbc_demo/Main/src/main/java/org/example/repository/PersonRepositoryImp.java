package org.example.repository;

import com.mysql.cj.jdbc.exceptions.SQLExceptionsMapping;
import org.example.config.DatabaseConnectionManager;
import org.example.model.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonRepositoryImp implements PersonRepository{
    Connection connection = DatabaseConnectionManager.getConnection();

    public PersonRepositoryImp() throws SQLException {

    }

    @Override
    public void addPerson(Person person) {
        String sql = "INSERT into person (id, name, mother, father) values (?, ?, ?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, person.getID());
            statement.setString(2, person.getName());
            statement.setString(3, person.getMother());
            statement.setString(4, person.getFather());
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
    }

    @Override
    public ResultSet getAllPersonsInfo() throws SQLException {
        String sql = "SELECT * FROM person";
        ResultSet resultSet = connection.createStatement().executeQuery(sql);

        return resultSet;
    }
}
