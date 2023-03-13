package Multithreading.March11.ThreadMethods;

public class yeildMethod implements Runnable
{
    public void run()
    {
        System.out.println("Started " + Thread.currentThread());

        // calling yield() method on current thread to move it

        // back to ready state from running state

        Thread.yield();

        System.out.println("Ended " + Thread.currentThread());
    }
    public static void main (String[] args)
    {
        yeildMethod y1 = new yeildMethod();

        // creating first thread

        Thread t1 = new Thread(y1, "First child thread");

        yeildMethod y2 = new yeildMethod();

        // creating second thread

        Thread t2 = new Thread(y1, "Second child thread");

        // calling thread will execute run() function

//        t1.setPriority(8);
//
//        t2.setPriority(4);

        t1.start();

        t2.start();
    }
}