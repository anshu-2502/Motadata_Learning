package Advance_dsa_IMPLEMENTATION;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class stackUsingQueue {
    Queue<Integer> queue1 ;
    Queue<Integer> queue2  ;


    public stackUsingQueue(){

        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();

    }

    public void push(int element){

         if(queue1.size() ==0){

             queue1.add(element);

         }

         else{

             int length = queue1.size();

             for(int queue1Iterator =0; queue1Iterator<length ; queue1Iterator++){

                 queue2.add(queue1.remove());
             }

             queue1.add(element);

             for(int queue2Iterator=0; queue2Iterator<length; queue2Iterator++){

                 queue1.add(queue2.remove());
             }

         }
    }

    public int pop(){

        if(queue1.size()==0){

            System.out.println("empty");
        }
        return queue1.remove();
    }

    public int peek(){
        if(queue1.size()==0){

            System.out.println("empty");
        }

        return queue1.peek();
    }


    public boolean isEmpty(){
        return queue1.isEmpty() && queue2.isEmpty();
    }

    public int getSize()
    {
        return queue1.size();
    }

    public void displayStack(){



        int length = getSize();

        if(length==0){
            System.out.println("empty queue");
        }

        else{

            Iterator queueIterator = queue1.iterator();

            while(queueIterator.hasNext()){
                System.out.println(queueIterator.next() + " ");
            }

            System.out.println();
        }

    }

    public static void main(String[]args){

        Scanner scannerInput = new Scanner(System.in);

        stackUsingQueue stackUsingQueue = new stackUsingQueue();

        stackUsingQueue.push(1);

        stackUsingQueue.push(2);

        stackUsingQueue.push(3);

        stackUsingQueue.push(4);


        stackUsingQueue.displayStack();

        System.out.println("poping element");
        System.out.println(stackUsingQueue.pop());

        System.out.println("display after poping:");
        stackUsingQueue.displayStack();

        System.out.println("peek element:");
        System.out.println(stackUsingQueue.peek());











    }
}
