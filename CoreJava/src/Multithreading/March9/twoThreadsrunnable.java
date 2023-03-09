package Multithreading.March9;

public class twoThreadsrunnable {

    public static void main(String[]args){

        Runnable runnable = () ->{
            String threadName = Thread.currentThread().getName();

            System.out.println(threadName + " running");
        };

        Thread thread = new Thread(runnable , "the thread-1 ");
        thread.start();

        Thread thread2 = new Thread(runnable , "the thread-2 ");
        thread2.start();

        Thread thread3 = new Thread(runnable , "the thread-3 ");
        thread3.start();

    }
}
