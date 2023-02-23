package AdvanceDSA_Lists_22Feb.collectionsLists.linkedLists;

import java.util.*;

public class collectionLinkedlists {

    public static void main(String[]args){

        LinkedList<String> linkedList = new LinkedList<String>();

        System.out.println("initital elements" + linkedList);

        linkedList.add("hi");

        linkedList.add("hello");

        linkedList.add("anushka");

        System.out.println("after add() method: " + linkedList);

        //adding at specific index:

        linkedList.add(1 , "goodmorning");

        System.out.println("after adding at desired position:  "+linkedList);

        LinkedList<String> linkedList2 = new LinkedList<String>();

        linkedList2.add("anshu");

        linkedList2.add("sharma");

        linkedList.addAll(linkedList2);

        System.out.println(linkedList);

        LinkedList<String> linkedList3 = new LinkedList<String>();

        linkedList3.add("john");

        linkedList3.add("rahul");

        linkedList.addAll(1, linkedList3);

        System.out.println(linkedList);

        linkedList.addFirst("adding-first");

        linkedList.addLast("adding last");

        System.out.println(linkedList);

        System.out.println("--remove methods:--");

        linkedList.remove("hello");
        System.out.println("remove method: "+ linkedList);

        linkedList.remove(0);
        System.out.println("removing 0th index:" + linkedList);

        LinkedList<String> linkedlist4 = new LinkedList<>();

        linkedlist4.add("remove-method");

        linkedlist4.add("testing remove linkedlist4");

        linkedList.addAll(linkedlist4);

        System.out.println("after adding linked list-4: " + linkedList);

        linkedList.removeAll(linkedlist4);

        System.out.println("removing all elements linklist4 "+ linkedList);

        linkedList.removeFirst();

        System.out.println("remove from first"+ linkedList);

        linkedList.removeLast();

        System.out.println("removing last: "+ linkedList);

        linkedList.removeFirstOccurrence("john");

        System.out.println("removing first occurrence:" + linkedList);

//        linkedList.clear();

//        System.out.println(linkedList);

        Iterator linkedlistIterator = linkedList.descendingIterator();

        while(linkedlistIterator.hasNext()){

            System.out.println(linkedlistIterator.next());

        }

    }
}
