package Multithreading.March9;

public class ThreadNaming {

    public static void main(String[]args){


        System.out.println(Thread.currentThread().getName());

        for(int threadIterator=0; threadIterator<10; threadIterator++){

            new Thread("Threadnumber" + threadIterator){
                public void run(){
                    System.out.println("Thread: " + getName()+ " runnning");
                }
            }.start();


        }

    }


}
