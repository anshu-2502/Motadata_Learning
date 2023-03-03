package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.Map;

public class DatafromJson {

    public static void main(String[]args){

        ObjectMapper mapper = new ObjectMapper();


        File fileObj = new File("/home/anshu/Downloads/sampleJson.json");

        try {
            Map<String, Object> userData = mapper.readValue(fileObj, new TypeReference<Map<String, Object>>() {});

            System.out.println("Name : " + userData.get("Name"));

            System.out.println("Mobile : " + userData.get("Mobile"));

            System.out.println("Designation : " + userData.get("Designation"));

            System.out.println("Pet : " + userData.get("Pet"));

            System.out.println("Address : " + userData.get("Address"));

        } catch (Exception e) {

            e.printStackTrace();
        }


    }
}
