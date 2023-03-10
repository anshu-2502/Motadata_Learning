package Multithreading.March9;

class MyRunnable implements  Runnable{

    private int count=0;

    @Override
    public void run() {

        for(int iterator=0; iterator<1_000_000; iterator++){

//            synchronized (this){
//                this.count ++;
//            }
//
                 count++;
        }

        System.out.println(Thread.currentThread().getName() + " : " + this.count);

    }
}
public class raceCondition {

    public static void main(String[]args){

        //not sharing any data i.e. seperable
//not shared so 2 millions printed
//        Runnable runnableObject1 = new MyRunnable();
//        Runnable runnableObject2 = new MyRunnable();


//inceremnting same variable shared between 2 threads.
        Runnable runnable = new MyRunnable();

        Thread thread1 = new Thread(runnable, "Thread1");

        Thread thread2 = new Thread(runnable, "Thread2");

        thread1.start();
        thread2.start();

    }
}
