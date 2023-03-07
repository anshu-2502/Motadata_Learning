package Advance_dsa_IMPLEMENTATION.MisclleniousQuestions_7mar;

import java.util.HashMap;

public class digitCountdigitValue {

    public boolean digitCount(String num) {

        HashMap<Integer,Integer> Digitmap = new HashMap<>();

        for(int iterator=0;iterator<num.length();iterator++){

            int number = Character.getNumericValue(num.charAt(iterator));

            Digitmap.put(number,Digitmap.getOrDefault(number,0)+1);
        }
        for(int iterator=0;iterator<num.length();iterator++){

            if(Digitmap.containsKey(iterator)){

                int digitCount = Digitmap.get(iterator);

                if(digitCount!=Character.getNumericValue(num.charAt(iterator))) {

                    return false;
                }
            }
            else{

                if(Character.getNumericValue(num.charAt(iterator))>0) {

                    return false;
                }
            }
        }
        return true;
    }


    public static void main(String[]args){
        digitCountdigitValue countDigits = new digitCountdigitValue();

//digit i occurs num[i] times in num, otherwise return false.

        //1. 0 occur 1 time(1's index is 0)

        String stringNumber = "1210";

        System.out.println(countDigits.digitCount(stringNumber));

    }
}
