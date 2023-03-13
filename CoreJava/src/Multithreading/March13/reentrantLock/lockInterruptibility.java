package Multithreading.March13.reentrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class lockInterruptibility {

    private static ReentrantLock reentrantLock = new ReentrantLock();

    private void isSync(){

        System.out.println("Acquired..");

        long count = 0;

        for (int i=0; i< Integer.MAX_VALUE ; i++) {

            count += i;
        }
        System.out.println("Done..");

    }

    public static void main(String[]args) throws InterruptedException {

       lockInterruptibility lockInterruptibilityObject = new lockInterruptibility();

       Thread thread1 = new Thread(new Runnable() {
           @Override
           public void run() {
               System.out.println("in thread-1");

               try {

                   reentrantLock.lock();

                   lockInterruptibilityObject.isSync();

               }
               finally {
                   reentrantLock.unlock();
               }


           }
       });

       Thread thread2 = new Thread(new Runnable() {
           @Override
           public void run() {
               System.out.println("in thread-2");
               try {

                   reentrantLock.lock();

                   System.out.println("locked in thread-2");

                   lockInterruptibilityObject.isSync();


               }
               finally {
                   reentrantLock.unlock();
                   System.out.println("unlocked");
               }
           }
       });

       Thread thread3 = new Thread(new Runnable() {
           @Override
           public void run() {

               System.out.println("in thread-3");

               try {
                   reentrantLock.lockInterruptibly();

                   System.out.println("lock interupptbility called");

                   System.out.println("Acquiring from thread 3.");

                   lockInterruptibilityObject.isSync();


               }

               catch(InterruptedException e){
                   e.printStackTrace();
               }

               finally {
                   reentrantLock.unlock();
               }
           }
       });


       thread1.start();

       Thread.sleep(3000);

       thread2.start();

       thread3.start();

       thread2.interrupt();

       thread1.join();

       thread2.join();

       thread3.join();


    }
}
