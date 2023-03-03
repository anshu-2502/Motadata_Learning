import java.util.*;

public class TestMapandList {

    public static void main(String[]args){


        List<Map<String, Object>> list = new ArrayList<>();

        Map<String, Object> map1 = new HashMap<>();
        Map<String, Object> map2 = new HashMap<>();
        Map<String, Object> map3 = new HashMap<>();
        Map<String, Object> map4 = new HashMap<>();
        Map<String, Object> map5 = new HashMap<>();

        map1.put("Age", 23);
        map2.put("Age", 24);
        map3.put("Age", 25);
        map4.put("Age", 23);
        map5.put("Age", 24);

        map1.put("Name", "Rohan");
        map2.put("Name", "Shyam");
        map3.put("Name", "George");
        map4.put("Name", "Ram");
        map5.put("Name", "Sam");

        list.add(map1);
        list.add(map2);
        list.add(map3);
        list.add(map4);
        list.add(map5);

        System.out.println("before sorting: ");

        for (Map<String, Object> map : list) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();

                System.out.print( key + " " + value);

                System.out.println("");
            }
        }


        list.sort(Comparator.comparing((Map<String, Object> map) -> (Integer) map.get("Age"))
                .thenComparing((Map<String, Object> map) -> (String) map.get("Name"))
        );


        System.out.println("after sorting: ");

        for (Map<String, Object> map : list) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();

                System.out.print( key + " " + value);

                System.out.println("");
            }
        }


    }
}
