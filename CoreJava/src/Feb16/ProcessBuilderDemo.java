package Feb16;

import java.io.*;

import java.lang.*;

import java.util.*;

public class ProcessBuilderDemo {

    public static void main(String[]args) throws IOException{

        List<String> list = new ArrayList<String>();

        list.add("notepad.exe");

        try {

            ProcessBuilder build = new ProcessBuilder( list );

            System.out.println( "command: " + build.command() );

        }

        catch(Exception e){

            System.out.println(e);

        }


    }
}
