package Multithreading.March13.reentrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class reentrantLock {

    private static ReentrantLock reentrantLock = new ReentrantLock(true);

    private static int count=0;

    private void isSync(){

        reentrantLock.lock();

        System.out.println("lock acquired");

        try{

            count++;

            System.out.println("the count is: "+count);

            Thread.sleep(1000);

            System.out.println("done");
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }

        finally {
            reentrantLock.unlock();
        }

    }
    public static void main(String[]args) throws InterruptedException {

        reentrantLock reentrantLockObject = new reentrantLock();

        Thread thread1 = new Thread(new Runnable() {
            @Override

            public void run() {

                reentrantLockObject.isSync();

                System.out.println(Thread.currentThread().getName());
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {

                reentrantLockObject.isSync();

                System.out.println(Thread.currentThread().getName());
            }
        });

        thread1.start();

        thread2.start();

       thread1.join();

       thread2.join();

        System.out.println("finished");
    }
}
