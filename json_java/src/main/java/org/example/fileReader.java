package org.example;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.HashMap;
public class fileReader {


    public static void main(String[] args)
    {


        HashMap<String, Object> studentHashmap = new HashMap<String, Object>();


        studentHashmap.put("studentId", 1);
        studentHashmap.put("studentFirstName", "AAA");
        studentHashmap.put("studentLastName", "BBB");
        studentHashmap.put("studentStream", "PCMB");
        studentHashmap.put("studentMarks", "480");


        ObjectMapper mapper = new ObjectMapper();


        try {


            String studentJson = mapper.writeValueAsString(studentHashmap);


            System.out.println(studentJson);
        }


        catch (JsonGenerationException e) {


            e.printStackTrace();
        }

        catch (JsonMappingException e) {
            e.printStackTrace();
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }
}



