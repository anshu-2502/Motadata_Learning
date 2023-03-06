package Advance_dsa_IMPLEMENTATION.Hashmaps;

import java.util.HashMap;
import java.util.Map;

public class uniqueCharacter {

    public static int firstUniqueCharacter(String inputString){

        Map<Character , Integer> map = new HashMap<Character, Integer>();

        for(int stringIterator=0; stringIterator<inputString.length(); stringIterator++){

            char characterString = inputString.charAt(stringIterator);

            if(map.containsKey(characterString)){

                map.put(characterString , map.get(characterString)+1);
            }

            else{

                map.put(characterString,1);

            }
        }

        for(int stringIterator=0; stringIterator<inputString.length(); stringIterator++){

            if(map.get(inputString.charAt(stringIterator))==1){
                return stringIterator;
            }


        }
        return -1;
    }
    public static void main(String[]args){

        String inputString = "leetcode";

        System.out.println(firstUniqueCharacter(inputString));


    }
}
