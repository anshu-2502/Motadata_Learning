package Advance_dsa_IMPLEMENTATION.MisclleniousQuestions_7mar;

import java.util.HashSet;
import java.util.Set;

public class doubleExists {

    public boolean checkIfExist(int[] arr) {

        Set<Integer> set = new HashSet<>();

        for (int i : arr) {
            if (set.contains(i * 2) || (i % 2 == 0 && set.contains(i / 2))) {
                return true;
            }

            set.add(i);
        }

        return false;
    }

    public static void main(String[]args){

        doubleExists doubleExists = new doubleExists();

        int [] inputArray = {10,2,5,3};

        System.out.println(doubleExists.checkIfExist(inputArray));
    }
}
