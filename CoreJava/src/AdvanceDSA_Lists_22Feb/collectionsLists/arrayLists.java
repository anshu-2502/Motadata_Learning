package AdvanceDSA_Lists_22Feb.collectionsLists;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class arrayLists {

    public static  void arrayList(){

//        Collection<Integer> demoArraylist = new ArrayList<>();

        List<Integer> demoArraylist = new ArrayList<>();

        demoArraylist.add(1);

        demoArraylist.add(2);

        demoArraylist.add(3);

        demoArraylist.add(4);

        demoArraylist.add(null);



        System.out.println("demoArraylist: " + demoArraylist);

        //collection interface has a signature in which object o is passed , therefore it takes "3" as a number insted of index

        demoArraylist.remove(3);

        System.out.println("after removing:" + demoArraylist);

        demoArraylist.remove(3);

        System.out.println("after removing:" + demoArraylist);

        //adding at 0th position:
        demoArraylist.add(0,10);

        System.out.println("adding at desired position:" + demoArraylist);

        //set the 0th index element to 8

        demoArraylist.set(0, 9);

        System.out.println("after setting element to different number:" + demoArraylist);

        System.out.println("Performing the bulk operations: ");


        Collection<Integer> demoArraylist2 = new ArrayList<>();

        demoArraylist2.add(9);
        demoArraylist2.add(3);

        System.out.println("array list-2  " + demoArraylist2);

        demoArraylist.removeAll(demoArraylist2);
        System.out.println("removeall method call: "+ demoArraylist2);

        demoArraylist2.add(1);

        demoArraylist.retainAll(demoArraylist2);

        System.out.println("retain from 2nd array to 1st array: "+ demoArraylist);

        demoArraylist.addAll(demoArraylist2);

        System.out.println("adding all from 2nd array to 1st array: "+ demoArraylist);

        //set value set the value and returns the previous value which was changed.

        System.out.println("demoArraylist.set(2,2) : " + demoArraylist.set(2,2));

        System.out.println("after set method the array is:  "+ demoArraylist);


        //search methods :

        System.out.println("search methods: ");

        System.out.println(".contains() =" + demoArraylist.contains(1));

        System.out.println(".indexOf() ="+ demoArraylist.indexOf(9));

        System.out.println(".lastIndexOf() =" + demoArraylist.lastIndexOf(1));


        //Sublist : new list is backed by orignal list any changes made here refected,
        // in main list:

        //sublist created from index to index:

        List<Integer> demoArraylist3 = demoArraylist.subList(2,3);

        System.out.println("demoArraylist's :  sublist " + demoArraylist3);

        demoArraylist3.add(0,6);

        System.out.println("list 1: changed happend ? :" + demoArraylist);

        System.out.println("adding element in sublist " + demoArraylist3);

        demoArraylist3.add(0,7);
        System.out.println(" first array : changed ?"+ demoArraylist);

        System.out.println("subset array after adding 7: " + demoArraylist3);

        demoArraylist.set(2,8);
        System.out.println("subset changed after set ?" + demoArraylist3);

        //demoArraylist.add(0,8);


        //adding element in list 1 but it will  give error for same in list 3
        //we can oly make non-structural changes in list 1 then list3 will be printed.
        //we can set someting but can't add

      //  System.out.println("list1: " + demoArraylist);


//        System.out.println("list3:" + demoArraylist3);


        //-->> gives concurrent modificationexception

//        for(int element : demoArraylist){
//            System.out.println("element: " + element);
//
//            if(element==9){
//
//                demoArraylist.remove(Integer.valueOf(element));
//
//            }
//        }

    }

    public static void main(String[]args){

            arrayList();


    }
}
