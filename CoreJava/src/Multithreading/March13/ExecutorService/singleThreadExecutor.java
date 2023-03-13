package Multithreading.March13.ExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class singleThreadExecutor {

    public static void main(String[]args){

        System.out.println("Inside: " + Thread.currentThread().getName());

        System.out.println("creating executor");

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        System.out.println("runnable");

        Runnable runnable = () ->{

            System.out.println("Inside" + Thread.currentThread().getName());

        };

        System.out.println("submit the task specified");

        executorService.submit(runnable);

        System.out.println("Shutting down the executor");
        executorService.shutdown();
    }
}
