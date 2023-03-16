package Multithreading.March16;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class PassengerThread extends Thread{

    private int duration;

    private CyclicBarrier barrier;

    public PassengerThread(int duration, CyclicBarrier barrier , String passengerName){

        //so that thread name will be equal to passenger name

        super(passengerName);

        this.duration=duration;

        this.barrier=barrier;
    }

    @Override
    public void run(){
        try{
            Thread.sleep(duration);

            System.out.println(Thread.currentThread().getName() + " is arrived.");

            //await method will decrement the barrier party i.e. 4 given in the code

            int await = barrier.await();

            if(await==0){

                System.out.println("all four passengers hve arrived");
            }


        }
        catch (InterruptedException | BrokenBarrierException e){

            e.printStackTrace();

        }
    }

}

public class cyclicBarrier {

    public static void main(String[]args){

        System.out.println(Thread.currentThread().getName() + " has started ");

        CyclicBarrier cyclicBarrier = new CyclicBarrier(4);

        PassengerThread passenger1 = new PassengerThread(1000, cyclicBarrier,"Anshu");

        PassengerThread passenger2 = new PassengerThread(2000, cyclicBarrier,"Tanu");

        PassengerThread passenger3 = new PassengerThread(3000, cyclicBarrier,"Akshi");

        PassengerThread passenger4 = new PassengerThread(4000, cyclicBarrier,"Mohil");


        PassengerThread passenger5 = new PassengerThread(1000, cyclicBarrier,"sharma");

        PassengerThread passenger6 = new PassengerThread(2000, cyclicBarrier,"tanushka");

        PassengerThread passenger7 = new PassengerThread(3000, cyclicBarrier,"agarwaal");

        PassengerThread passenger8 = new PassengerThread(4000, cyclicBarrier,"gupta");

        passenger1.start();

        passenger2.start();

        passenger3.start();

        passenger4.start();

        passenger5.start();

        passenger6.start();

        passenger7.start();

        passenger8.start();



    }
}
