package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {

    public static void main(String[] args) throws SQLException
    {


        String jdbcURL = "jdbc:h2:tcp://localhost/~/test";

        String user = "sa";

        String pass = "";

        Connection connection = DriverManager.getConnection(jdbcURL,user,pass);

        System.out.println("Connected to H2 database.");

        String sql = "Create table student (ID int, name varchar(50))";


        Statement statement = connection.createStatement();
//
//        statement.execute(sql);
//
//        System.out.println("Created table students.");
//
        sql = "insert into student values (1, 'Anushka')";

        int rows = statement.executeUpdate(sql);

        if (rows > 0) {

            System.out.println("Inserted a new row.");
        }

        connection.close();

    }
}
