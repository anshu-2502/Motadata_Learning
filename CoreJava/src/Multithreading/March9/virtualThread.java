package Multithreading.March9;

public class virtualThread {

    public static void main(String[]args){

        // creating runnable starting virtual thread

        Runnable runnable =() ->{

            for(int iterator=0; iterator<10; iterator++){



                System.out.println("Index: " + iterator);

            }
        };

        Thread virtualThread1 = Thread.ofVirtual().start(runnable);


        //creating but not starting virtual thread

        Thread virtualUnstartedThread = Thread.ofVirtual().unstarted(runnable);

        virtualUnstartedThread.start();

        //joining a virtual thread:
        //join will block thread until virtual thread has finished

        try{
            virtualUnstartedThread.join();
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }

    }
}
