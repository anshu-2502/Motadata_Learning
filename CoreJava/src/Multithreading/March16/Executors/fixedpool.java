package Multithreading.March16.Executors;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Task implements Runnable{

    private int Taskid;

    public Task(int Taskid){

        this.Taskid = Taskid;

    }

    public void run(){

        System.out.println("Work with ID" + Taskid + " is in work - thread id: "+ Thread.currentThread().getId());

        long duration =(long) (Math.random()*5);

        try{
            TimeUnit.SECONDS.sleep(duration);
        }
        catch(InterruptedException e){
            e.printStackTrace();

            Thread.currentThread().interrupt();
        }


    }

}
public class fixedpool {
    public static void main(String[]args) {

        //it is a single thread that will execute tasks sequentially
        //so one after other
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for (int iterator = 0; iterator < 10; iterator++) {

            executorService.execute(new Task(iterator + 1));
        }
        //We prevent the executor to execute the frther tasks.

        executorService.shutdown();

        //terminating actual running tasks:

        try {
            if (!executorService.awaitTermination(1000, TimeUnit.MILLISECONDS)) {
                executorService.shutdownNow();
            }


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    }
