package Multithreading.March9;

public class stopAthread {

     static class StoppableRunnable implements Runnable {

         private boolean stopRequested = false;

         public synchronized void requestStop(){  //only one thread can call these syncronized method in same time.

             this.stopRequested =true;
         }

         public synchronized boolean isStopRequested(){
             return this.stopRequested;
         }

         private void sleep(long millis){
             try{

                 Thread.sleep(millis);
             }
             catch (InterruptedException e){
                 e.printStackTrace();
             }
         }


         @Override
         public void run() {

             System.out.println("stoppable runnable running");

             while(!isStopRequested()){
                 sleep(1000);
                 System.out.println("...");
             }

             System.out.println("StoppableRunnable stopped");

         }
     }
        public static void main(String[]args){

         StoppableRunnable stoppableRunnable = new StoppableRunnable();

         Thread thread = new Thread(stoppableRunnable , "The Thread");

         thread.start();

         try{

             Thread.sleep(5000);

         }
         catch(InterruptedException e){

             e.printStackTrace();

         }

            System.out.println("requesting stop");

            stoppableRunnable.requestStop();

            System.out.println("stop requested");

    }
}
