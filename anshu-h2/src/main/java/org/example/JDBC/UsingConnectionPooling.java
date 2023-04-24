package org.example.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UsingConnectionPooling {

    public static void main(String[] args) throws SQLException {

        String driver= "org.h2.Driver";

        String url = "jdbc:h2:tcp://localhost/~/test";

        String username ="sa";

        String password ="";

        ConnectionPooling connectionPooling = new ConnectionPooling(driver,url,username,password,5,10,true);

        Connection connection = connectionPooling.getConnection();

        Connection connection1 = connectionPooling.getConnection();

        System.out.println("connected from connection pooling");

        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM EMPLOYEES");

        System.out.println("connected from connection pooling-2");

        PreparedStatement preparedStatement1 = connection1.prepareStatement("SELECT * FROM EMPLOYEES");

        ResultSet resultSet = preparedStatement.executeQuery();

        ResultSet resultSet2 = preparedStatement1.executeQuery();

        while(resultSet.next()){

            System.out.println(resultSet.getInt("ID"));

            System.out.println(resultSet.getString("NAME"));

        }

        while(resultSet2.next()){

            System.out.println(resultSet2.getInt("ID"));

            System.out.println(resultSet2.getString("NAME"));

        }

        if(resultSet !=null){

            resultSet.close();

        }


        if(preparedStatement!=null){

            preparedStatement.close();

        }

        if(resultSet2 !=null){

            resultSet2.close();

        }


        if(preparedStatement1!=null){

            preparedStatement1.close();

        }

        connectionPooling.free(connection);
        connectionPooling.free(connection1);

        System.out.println("released connection ");





    }
}
