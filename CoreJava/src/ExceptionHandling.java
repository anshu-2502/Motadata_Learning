import java.awt.*;
import java.io.FileNotFoundException;
import  java.io.IOException;
import java.io.*;

public class ExceptionHandling {
    public static void main(String[]args){
        int a =5;
        int b=0;

        try{
            System.out.println(a/b);
        }
        catch(ArithmeticException e){
            System.out.println("stack trace: ");
            e.printStackTrace();

            System.out.println("this method prints exception information in format of name of the exception: description of exception");
            System.out.println(e.toString());

            System.out.println("getMessage method");
            System.out.println(e.getMessage());

        }

    }
}
