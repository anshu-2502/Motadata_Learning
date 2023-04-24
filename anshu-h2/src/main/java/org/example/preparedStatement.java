package org.example;

import java.sql.*;

public class preparedStatement {
    public static void main(String[] args) {

        Connection connection = null;

        PreparedStatement pst1 = null;

        PreparedStatement pst2 = null;

        PreparedStatement pst3 = null;

        ResultSet rs = null;


        try{

            Class.forName("org.h2.Driver");

            System.out.println("driver loaded");

            connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");

            System.out.println("got database connection");

            String sql = "Create table employees (ID int, name varchar(50) , salary int)";


             Statement statement = connection.createStatement();

             statement.execute(sql);

             System.out.println("Created table employees.");

            pst1 = connection.prepareStatement("INSERT INTO EMPLOYEES (ID, name, salary) VALUES(?,?,?)");

            pst1.setInt(1, 107);

            pst1.setString(2, "Sakshi");

            pst1.setInt(3, 7000);


            pst1.addBatch();

            pst1.setInt(1, 108);

            pst1.setString(2, "Anshu");

            pst1.setInt(3, 8000);



            pst1.addBatch();

            pst1.setInt(1, 109);

            pst1.setString(2, "Sankalp");

            pst1.setInt(3, 9000);



            pst1.addBatch();

            int a[] = pst1.executeBatch();


            pst2 = connection.prepareStatement("select ID , name , salary from employees where ID > ? ");

            pst2.setInt(1,104);

            rs =pst2.executeQuery();

            while(rs.next()){


                System.out.print(rs.getInt("id") + "\t");

                System.out.print(rs.getString("name") + "\t");

                System.out.println(rs.getString("salary"));


            }








        } catch (ClassNotFoundException e) {

            throw new RuntimeException(e);

        }
        catch (SQLException e) {

            throw new RuntimeException(e);

        }


    }
}
