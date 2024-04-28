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
            /*
            // Insertion
            personService.addPerson("0019", "Nashu1");
            System.out.println("Insertion Successfully");
             */

            // get All persons in the DB
            /*
            ResultSet rs = personService.getPersonList();
            String ID, name, motherID, fatherID;
            System.out.println("----------------------------------------------------");
            while (rs.next()) {
                ID = rs.getString("ID");
                name = rs.getString("name");
                motherID = rs.getString(3);
                //if (rs.wasNull()) {
                //    System.out.println("Mother is Null");
                //}
                fatherID = rs.getString(4);
                //if (rs.wasNull()) {
                //    System.out.println("Father is Null");
                //}
                System.out.println("Id: "+ ID + " name: "+ name +" mother Id: " + motherID + " FatherID: " + fatherID);
                System.out.println("-------------------------------------------------");
            }
            */


        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }

    }
}