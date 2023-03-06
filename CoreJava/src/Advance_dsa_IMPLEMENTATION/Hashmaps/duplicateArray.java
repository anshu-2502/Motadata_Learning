package Advance_dsa_IMPLEMENTATION.Hashmaps;

import java.util.HashSet;

public class duplicateArray {

    public void duplicateArray(int[] array){

        HashSet<Integer> hashSet = new HashSet<>();

        for(int element : array){
            if(!hashSet.add(element)){

                System.out.println(element);
            }
        }

    }

    public static void main(String[]args){

        int[] array = {10,29,45,66,45};
        duplicateArray d = new duplicateArray();

        d.duplicateArray(array);



    }
}
