package org.example.JDBC;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Tables {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {

        FileInputStream fis=new FileInputStream("src/main/resources/databaseinfo.properties");

        Properties p=new Properties ();

        p.load (fis);

        String dname= (String) p.get ("Dname");

        String url= (String) p.get ("URL");

        String username= (String) p.get ("Uname");

        String password= (String) p.get ("password");


        Connection connection = DriverManager.getConnection(url, username, password);

        System.out.println("connection established");

        String sql = "Create table student1 (ID int, name varchar(50))";

        Statement statement = connection.createStatement();

        statement.execute(sql);


    }
}
