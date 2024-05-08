package org.example;

import org.example.service.PersonService;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws SQLException {

        PersonService service = PersonService.getInstance();

        // INSERT
        // boolean result = service.createPerson("6543", "Jack");

        // Read all
        ResultSet rs = service.getAllPersonList();
        ResultSetMetaData rsMetaData = rs.getMetaData();
        for (int i= 1; i<rsMetaData.getColumnCount(); i++){
            System.out.println(rsMetaData.getColumnName(i));
        }
        //while (rs.next())  {
        //    System.out.println(rs.getString(1));
        //}
    }
}