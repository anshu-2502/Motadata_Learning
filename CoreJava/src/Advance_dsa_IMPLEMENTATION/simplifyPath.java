package Advance_dsa_IMPLEMENTATION;

import java.util.Stack;

public class simplifyPath {

    public static String simplifyPath(String path){

        String[] parting = path.split("/");

        Stack<String> stack = new Stack<String>();

        for(int iterator=0; iterator < parting.length; iterator++){

            if(parting[iterator].equals("") || parting[iterator].equals(".")){

                continue;

            } else if (parting[iterator].equals("..")) {

                if(!stack.empty()){
                    stack.pop();
                }

            }

            else{
                stack.push(parting[iterator]);
            }
        }

        String result = "";

        if(stack.isEmpty()){

            return "/";
        }
        else{
            while(!stack.isEmpty()){

                result ="/" +stack.pop() + result;
            }

            return  result;

        }

    }
    public static void main(String[]args){

        String userString = "/home//foo/";

        System.out.println(simplifyPath(userString));



    }
}
