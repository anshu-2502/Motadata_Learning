package Multithreading.March16;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class countDownLatch {

    static class Service implements Runnable{
        private CountDownLatch countDownLatch;

        private int waitTime;

        public Service(CountDownLatch countDownLatch, int waitTime){

            this.countDownLatch = countDownLatch;

            this.waitTime = waitTime;
        }

        @Override
        public void run(){

            System.out.println("Service started: " + Thread.currentThread().getName());

            try{
                TimeUnit.SECONDS.sleep(waitTime);
            }

            catch(InterruptedException e){
                e.printStackTrace();
            }

            System.out.println("service ended"+ Thread.currentThread().getName());

             countDownLatch.countDown();
        }
    }

    public static void main(String[]args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(3);

        new Thread(new Service(countDownLatch,2)).start();

        new Thread(new Service(countDownLatch,5)).start();

        new Thread(new Service(countDownLatch,2)).start();

        countDownLatch.await();

        System.out.println("done all threads");

    }
}
