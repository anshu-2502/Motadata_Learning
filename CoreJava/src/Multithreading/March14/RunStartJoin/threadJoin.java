package Multithreading.March14.RunStartJoin;

class MyRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("Thread started:::"+Thread.currentThread().getName());
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread ended:::"+Thread.currentThread().getName());
    }

}
public class threadJoin {

    public static void main(String[]args){

        Thread thread1 = new Thread(new MyRunnable(), "thread1");

        Thread thread2 = new Thread(new MyRunnable() , "thread2");

        Thread thread3 = new Thread(new MyRunnable() , "thread2");

        thread1.start();


        //starting the second thread after waiting for 2 sec

        try{
            thread1.join(2000);
        }
        catch(InterruptedException e){

        }

        thread2.start();

        //starting the third thread only when first thread is dead

        try{
            thread1.join();

        }
        catch(InterruptedException e){

        }

        thread3.start();

        //let all threads finish execution before finishing main thread

        try{
            thread1.join();
            thread2.join();
            thread3.join();
        }

        catch(InterruptedException e){

        }

        System.out.println("all threads are dead");

    }


}
