package Multithreading.March16.Executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Work implements Runnable{

    private int Workid;

    public Work(int Workid){

        this.Workid = Workid;

    }

    public void run(){

        System.out.println("Work with ID" + Workid + " is in work - thread id: "+ Thread.currentThread().getName());

        long duration =(long) (Math.random()*5);

        try{
            TimeUnit.SECONDS.sleep(duration);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }


    }

}
public class singlethreadExecutor {
    public static void main(String[]args){

        //it is a single thread that will execute tasks sequentially
        //so one after other
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        for(int iterator=0; iterator<10; iterator++){

            executorService.execute(new Work(iterator));
        }
        executorService.shutdown();

    }
}
