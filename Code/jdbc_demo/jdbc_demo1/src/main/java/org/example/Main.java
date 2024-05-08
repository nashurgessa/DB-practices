package org.example;

import org.example.service.PersonService;

import java.sql.SQLException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws SQLException {

        PersonService service = PersonService.getInstance();

        // INSERT
        boolean result = service.createPerson("6543", "Jack");

        //


    }
}