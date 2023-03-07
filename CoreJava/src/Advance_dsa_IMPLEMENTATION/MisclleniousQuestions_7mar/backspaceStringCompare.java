package Advance_dsa_IMPLEMENTATION.MisclleniousQuestions_7mar;

import java.util.Stack;

public class backspaceStringCompare {

    public boolean backspaceCompare(String string1, String string2) {

        Stack<Character> stack1= new Stack<>();

        Stack<Character> stack2= new Stack<>();


        for(int iterator=0;iterator<string1.length();iterator++){

            if (string1.charAt(iterator) != '#') {

                stack1.push(string1.charAt(iterator));

            }
            else if (!stack1.isEmpty()) {

                stack1.pop();
            }
        }

        for(int iterator=0;iterator<string2.length();iterator++){

            if (string2.charAt(iterator) != '#') {

                stack2.push(string2.charAt(iterator));

            }
            else if (!stack2.isEmpty()) {

                stack2.pop();
            }
        }


        while(!stack1.isEmpty()&&!stack2.isEmpty()){

            if(stack1.pop()!=stack2.pop()){

                return false;
            }
        }
        if(stack1.isEmpty()&&stack2.isEmpty()){

            return true;
        }
        return false;
    }

    public static void main(String[]args){

        String string1 = "ab#c";
        String string2 = "ad#c";

        if(string1==null || string2==null){
            System.out.println("string is null");
        }

        else {

            try {
                backspaceStringCompare backspaceStringCompare = new backspaceStringCompare();

                backspaceStringCompare.backspaceCompare(string1, string2);
            }
            catch(Exception e){
                System.out.println(e);
            }
        }

    }
}
