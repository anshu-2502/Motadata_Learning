package Advance_dsa_IMPLEMENTATION.Hashmaps;

import java.util.HashSet;
import java.util.Set;

public class ArithmeticTriplets {
    public static int arithmeticTriplets(int[] nums, int diff) {

        Set<Integer> hashset = new HashSet<Integer>();

        for(int iterator: nums){

            hashset.add(iterator);
        }

        int ans=0;

        for(int iterator: nums){

            if(hashset.contains(iterator-diff) && hashset.contains(iterator+diff)){
                ans++;
            }

        }


        return ans;
    }
    public static void main(String[]args){

    int arr[] = {4,5,6,7,8,9,10};

    int difference = 3;

        System.out.println(arithmeticTriplets(arr,difference));

    }
}
