package Advance_dsa_IMPLEMENTATION.Hashmaps;
import java.util.Arrays;
import java.util.HashMap;

public class twoSum {

    public static  int[] twoSum(int[] numbers, int target) {

        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();

        for (int i = 0; i < numbers.length; i++) {

            Integer complement = (Integer) (target - numbers[i]);

            if (hash.containsKey(complement)) {

                int toReturn[] = {hash.get(complement) , i };

                return toReturn;
            }

            hash.put(numbers[i], i);

        }

        return null;

    }

    public static void main(String[] args){

        int nums [] = {2,7,11,15};

        int target = 9;

        System.out.println(Arrays.toString(twoSum(nums,target)));

    }


}