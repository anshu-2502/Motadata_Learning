package Multithreading.March15.Daemonthread;

public class inherited extends Thread {

    public void run(){
        if(Thread.currentThread().isDaemon()){
            System.out.println("p");
        }
        else{
            System.out.println("q");
        }
    }
    public static void main(String[]args){



        if(Thread.currentThread().isDaemon()){
            System.out.println("r");
        }
        else{
            System.out.println("s");
        }
        Thread t1 = new inherited();
        t1.setDaemon(true);
        t1.start();

    }
}
