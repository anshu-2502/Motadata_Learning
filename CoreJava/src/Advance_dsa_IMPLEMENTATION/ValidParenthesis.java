package Advance_dsa_IMPLEMENTATION;

import java.util.Stack;

public class ValidParenthesis {

    public static void validParenthsis(String inputParenthesis){

        Stack<Character> characterStack = new Stack<Character>();

        for(char stackElement : inputParenthesis.toCharArray()){

            if(stackElement == '(' || stackElement =='{'|| stackElement== '['){

                characterStack.push(stackElement);

            }

            else{

                if(characterStack.empty()){
                    System.out.println(inputParenthesis + "invalid parenthesis");
                    return;
                }

                else{

                    char top = (Character) characterStack.peek();

                    if(stackElement == ')' && top =='(' ||  stackElement == '}' && top =='{' || stackElement == ']' && top =='['){

                        characterStack.pop();
                    }

                    else {
                        System.out.println(inputParenthesis + " invalid parenthesis");
                        return;
                    }

                }

            }

        }

        if(characterStack.isEmpty()){
            System.out.println(inputParenthesis + " valid parenthesis");
        }

        else{
            System.out.println( inputParenthesis + " invalid parenthesis");

        }

    }

    public static void main( String args[] ) {
        String input_str1 = "{{}}()[()]";
        String input_str2 = "(][)";
        String input_str3 = ")";

        validParenthsis(input_str1);

        validParenthsis(input_str2);

        validParenthsis(input_str3);


    }
}
