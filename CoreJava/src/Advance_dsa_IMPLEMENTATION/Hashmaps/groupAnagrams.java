package Advance_dsa_IMPLEMENTATION.Hashmaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class groupAnagrams {

    public static List<List<String>> groupAnagrams(String[] inputString) {

        List<List<String>> result = new ArrayList<>();


        HashMap<String, List<String>> hashMap = new HashMap<>();


        for(String stringElement: inputString){


            char[] chArr = stringElement.toCharArray();

            Arrays.sort(chArr);

            String key = new String(chArr);


            if(hashMap.containsKey(key)){

                hashMap.get(key).add(stringElement);

            } else {
                List<String> strList = new ArrayList<>();

                strList.add(stringElement);

                hashMap.put(key, strList);
            }
        }

        result.addAll(hashMap.values());

        return result;
    }

    public static void main(String[] args) {

        String[] inputString = {"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> result  = groupAnagrams(inputString);

        result.forEach(element -> System.out.println(element + " "));
    }
}

