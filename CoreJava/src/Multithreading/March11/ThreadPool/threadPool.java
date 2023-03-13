package Multithreading.March11.ThreadPool;

import java.util.concurrent.ExecutorService;

import java.util.concurrent.Executors;
class WorkerThread implements Runnable {
    private String message;
    public WorkerThread(String message){

        this.message=message;
    }

    private void processmessage() {

        try {
            Thread.sleep(2000);

        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void run() {

        System.out.println(Thread.currentThread().getName()+" (Start) message = "+message);

        processmessage();//call processmessage method that sleeps the thread for 2 seconds

        System.out.println(Thread.currentThread().getName()+" (End)");//prints thread name
    }

}
public class threadPool {
    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(5);//creating a pool of 5 threads

        for (int iterator = 0; iterator < 10; iterator++) {

            Runnable worker = new WorkerThread("" + iterator);

            executor.execute(worker);//calling execute method of ExecutorService

        }

        executor.shutdown();

        while (!executor.isTerminated()) {

        }

        System.out.println("Finished all threads");
    }
}
