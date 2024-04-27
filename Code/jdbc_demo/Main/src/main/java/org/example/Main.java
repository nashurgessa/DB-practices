package org.example;

import org.example.service.PersonService;

import java.sql.ResultSet;
import java.sql.SQLException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws SQLException {
        try {
            PersonService personService = PersonService.getInstance();

            personService.addPerson("0019", "Nashu1");
            System.out.println("Insertion Successfully");

            ResultSet queryResult = personService.getPersonList();

            String ID, name;
            while (queryResult.next()) {
                ID = queryResult.getString("ID");
                name = queryResult.getString("name");
                System.out.println("Id: "+ ID + "name: "+ name);
            }
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }

    }
}