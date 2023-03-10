package Multithreading.March9;

import static java.lang.Thread.sleep;

public class DaemonThread {

    public static void main(String[]args) throws InterruptedException {

        Runnable runnable =() ->{
            while(true){
                try {
                    sleep(1000);

                    System.out.println("Running");

                } catch (InterruptedException e) {

                    e.printStackTrace();
                }
            }
        };

        Thread thread = new Thread(runnable , "my thread");

        //even after main thread terminated one thread is running and jvm is kept alive
        //and then we need to mark daemon thread, upto when mainthread runs
        //it runs.
        thread.setDaemon(true);//stopped in undefined state

        thread.start(); // main thread

        sleep(3100);

    }
}
