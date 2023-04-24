package org.example;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class date {

    public static void main(String[] args) throws ClassNotFoundException, SQLException, ParseException {


        Class.forName("org.h2.Driver");

        System.out.println("driver loaded");

       Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");

        System.out.println("got database connection");

        String sql = "Create table person (user_no int, user_name varchar(50) , sqdob date  , sqdoj date)";

        Statement statement = connection.createStatement();

//        statement.execute(sql);

        System.out.println("Created table persons.");

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Person No:");

        int user_no=sc.nextInt();

        System.out.println("Enter Person Name:");

        String user_name=sc.next();

        System.out.println("Enter DOB(dd-mm-yy):");

        String user_dob=sc.next();

        System.out.println("Enter DOJ(yyyy-mm-dd):");

        String user_doj=sc.next();

        SimpleDateFormat sdf= new SimpleDateFormat("dd-mm-yy");

        java.util.Date sdob=sdf.parse(user_dob);

        java.sql.Date sqdob= new java.sql.Date(sdob.getTime());

        java.sql.Date sqdoj=java.sql.Date.valueOf(user_doj);

        String sqlQuery="insert into person values(?,?,?,?)";

        PreparedStatement ps = connection.prepareStatement(sqlQuery);

        ps.setInt(1,user_no);

        ps.setString(2,user_name);

        ps.setDate(3,sqdob);

        ps.setDate(4,sqdoj);

        int  rc =ps.executeUpdate();

        if(rc==0) {
            System.out.println("Record Not inserted");
        }
        else {
            System.out.println("Record inserted");
        }



        PreparedStatement ps1 = connection.prepareStatement("select * from person");
        ResultSet rs =ps1.executeQuery();
        SimpleDateFormat simpleDateFormat= new SimpleDateFormat("dd-MMM-yyyy");
        while(rs.next())
        {
            java.sql.Date d=rs.getDate(3);
            String s=simpleDateFormat.format(d);
            System.out.println(s);
        }

    }
}
