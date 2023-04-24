package org.example;

import java.sql.*;

public class SQL_Queries {

    static final String DB_URL = "jdbc:h2:~/SQL2";
    static final String USER = "Anshu";
    static final String PASS = "1234";

    static final String QUERY = "SELECT id, first_name, last_name, age FROM Students";


    public static void main(String[] args) {



        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(QUERY);
        ) {
            String createTable = "CREATE TABLE STUDENTS " + "(id INTEGER not NULL, " + " first_name VARCHAR(255), " + " last_name VARCHAR(255), " + " age INTEGER, " + " PRIMARY KEY ( id ))";

//            stmt.executeUpdate(createTable);

            System.out.println("Created table in given database...");

            System.out.println("inserting records: ");

            String sql = "INSERT INTO Students VALUES (1, 'Anshu', 'Sharma', 22)";

//            stmt.executeUpdate(sql);

            sql = "INSERT INTO Students VALUES (2, 'Anushka', 'Sharma', 21)";

//            stmt.executeUpdate(sql);

            sql = "INSERT INTO Students VALUES (3, 'Tanu', 'Sharma', 20)";

//            stmt.executeUpdate(sql);

            sql = "INSERT INTO Students VALUES(4, 'Tina', 'Sharma', 11)";

//            stmt.executeUpdate(sql);

            System.out.println("Inserted records into the table...");


            System.out.println("updating the age...");

           sql = "UPDATE STUDENTS " +"SET age = 16 WHERE id in (4)";

//           stmt.executeUpdate(sql);

            System.out.println("deleting: ");

            sql = "DELETE FROM STUDENTS WHERE ID =3";

//            stmt.executeUpdate(sql);


            System.out.println("altering table...");

            sql = "ALTER TABLE students add location varchar(30)";
//            stmt.executeUpdate(sql);


            System.out.println("aggregrate functions....");

            System.out.println("count: ");

            sql = "SELECT COUNT(*) FROM STUDENTS WHERE AGE>=20";

            ResultSet aggFunction = stmt.executeQuery(sql);

            aggFunction.next();

            System.out.println("Table contains "+aggFunction.getInt("count(*)")+" rows");
//

            while(rs.next()){

                System.out.print("ID: " + rs.getInt("id"));

                System.out.print(", Age: " + rs.getInt("age"));

                System.out.print(", FirstName: " + rs.getString("first_name"));

                System.out.println(", LastName: " + rs.getString("last_name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


}
