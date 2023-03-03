package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class mapToJson {

    public static void main(String args[]) {


        ObjectMapper mapper = new ObjectMapper();


        Map<String, Object> userData = new HashMap<String, Object>();


        String name, price, model;

        String colors[];


        Scanner sc = new Scanner(System.in);


        System.out.println("Enter the name of the car: ");

        name = sc.nextLine();

        System.out.println("Enter the modal number of the car: ");

        model = sc.nextLine();

        System.out.println("Enter the price of the car: ");

        price = sc.nextLine();

        colors = new String[3];

        colors[0] = "Red";

        colors[1] = "Black";

        colors[2] = "White";


        sc.close();


        userData.put("Car", name);

        userData.put("Price", price);

        userData.put("Model", model);

        userData.put("Colors", colors);


        try {


            mapper.writeValue(new File("/home/anshu/Downloads/sampleWriteFile.json"), userData);

            System.out.println("Map data successfully written to the Sample.json file.");

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
