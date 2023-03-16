package Multithreading.March16.DiningPhilosophersProblem;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class chopstick {

    private int chopstickID;

    //may be several philosopher will try to use same chopsticks:
    private Lock lock;

    public chopstick(int chopstickID){

        this.chopstickID = chopstickID;

        this.lock = new ReentrantLock();

    }

    //phiosophers can pick up the given chopstick and can put down the
    //given chopstick.

    public boolean pickUP(philosopher philosopher, chopstickState state) throws InterruptedException{

        //this is where we will have to simulate deadlock

        //there may be cases where philosopher is waiting for other philosopher
        //to finish eating so that they can have chopstick


        //try to get the lock(chopsticks)

       if(lock.tryLock(10, TimeUnit.MILLISECONDS)){

           System.out.println(philosopher + "picked up "+ state.toString()+ " " + this + " chopstick"+chopstickID);

            return  true;

       }

       //transforming chopstick object into the string



        return false;
    }


    public void putDown(philosopher philosopher){
        lock.unlock();

        //this means chopstick
        System.out.println(philosopher + " put down" + this + "chopstick"+ chopstickID);
    }


}
