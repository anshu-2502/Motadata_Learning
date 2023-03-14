package Multithreading.March14.Atomic;


class threadCount extends Thread{
    int total = 0;
    public void run(){

        int max = 100000;

        for (int i = 0; i < max; i++){

            total++;
        }
    }
}
public class withoutAtomic {
    public static void main(String args[]) throws InterruptedException{
        threadCount count = new threadCount();

        Thread first = new Thread(count, "First");

        Thread second = new Thread(count, "Second");

        first.start();

        second.start();

        first.join();

        second.join();

        System.out. println("Loop count without using Atomic Variables in Java: "+count.total);
    }
}
