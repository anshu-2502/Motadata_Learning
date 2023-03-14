package Multithreading.March14.Atomic;

//atomic variable are used to solve the problem on concurrency
//threads may execute simultaneously causing a write problem

import java.util.concurrent.atomic.AtomicInteger;

public class atomicVariable extends Thread{

    //creating an instance of atomic variable

    AtomicInteger total;

    atomicVariable(){
        total = new AtomicInteger();

    }

    public void run(){
        int maximum = 100000;

        for(int iterator=0; iterator<maximum; iterator++ ){

            total.addAndGet(1);
        }
    }

    public static void main(String args[])throws InterruptedException{
        atomicVariable count = new atomicVariable();

        Thread first = new Thread(count, "First");

        Thread second = new Thread(count, "Second");

        first.start();

        second.start();

        first.join();

        second.join();

        System.out. println("Loop count using Atomic Variables in Java: "+count.total);
    }






}
