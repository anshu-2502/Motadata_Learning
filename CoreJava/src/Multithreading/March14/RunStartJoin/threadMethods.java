package Multithreading.March14.RunStartJoin;

public class threadMethods extends Thread {


    public synchronized  void start(){

        System.out.println("start method");
    }
    public synchronized void run(){

//        for(int i=0; i<5; i++){
//            System.out.println(i);
//        }

        System.out.println("run method");
    }


    public static void main(String[]args){

        Thread thread1 = new threadMethods();

        thread1.start();

        thread1.run();
//
        Thread thread2 = new threadMethods();

        thread2.run();

    }
}
