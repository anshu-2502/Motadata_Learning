package Multithreading.March16.DiningPhilosophersProblem;

import java.util.Random;

public class philosopher implements Runnable {

    private int philosopherID;

    private volatile boolean isFull;


    //left and right chopstick
    private chopstick leftChopStick;

    private chopstick rightChopstick;

    private Random random;

    private int eatingCounter;

    public philosopher(int iterator, chopstick chopstick, chopstick chopstick1) {
    }


    @Override
    public void run() {

    }
}
