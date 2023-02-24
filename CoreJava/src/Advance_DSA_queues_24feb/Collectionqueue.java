package Advance_DSA_queues_24feb;

import java.util.*;

public class Collectionqueue {

    public static void main(String[]args) {

        Queue<String> str_queue = new LinkedList<>();

        str_queue.add("one");

        str_queue.add("two");

        str_queue.add("three");

        Iterator iterator = str_queue.iterator();
        while(iterator.hasNext()){
            String element = (String) iterator.next();
            System.out.print(element + " ");
        }

        str_queue.peek();

        str_queue.remove();

        str_queue.offer("anushka");

        str_queue.add("sharma");

        str_queue.size();

        System.out.println(" ");
         iterator = str_queue.iterator();
        while(iterator.hasNext()){
            String element = (String) iterator.next();
            System.out.print(element + " ");
        }



    }

}
