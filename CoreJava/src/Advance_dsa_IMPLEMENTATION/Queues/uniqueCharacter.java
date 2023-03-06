package Advance_dsa_IMPLEMENTATION.Queues;

import java.util.LinkedList;
import java.util.Queue;

public class uniqueCharacter {

    final static int MAX_CHAR =26;

    static void firstNonRepeating(String input_string){

        int[] charCount = new int[MAX_CHAR];

        Queue<Character> queue = new LinkedList<Character>();

        for(int stringIterator=0; stringIterator<input_string.length(); stringIterator++){

            char stringChar = input_string.charAt(stringIterator);

            queue.add(stringChar);

            charCount[stringChar - 'a']++;

            while(!queue.isEmpty()){

                if(charCount[queue.peek() -'a'] >1)
                    queue.remove();


                else{

                    System.out.println(queue.peek() + " ");
                    break;
                }
            }

            if(queue.isEmpty()){
                System.out.println(-1);
            }



        }



    }
    public static void main(String[]args){

        String inputString = "leetcode";

        firstNonRepeating(inputString);



    }
}
