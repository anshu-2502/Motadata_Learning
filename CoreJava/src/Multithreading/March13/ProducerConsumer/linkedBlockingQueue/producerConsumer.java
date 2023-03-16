package Multithreading.March13.ProducerConsumer.linkedBlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class producerConsumer {

    public static void main(String[]args){

        BlockingQueue<Integer> taskqueue = new LinkedBlockingQueue<>();

        int MAX_CAPACITY=5;

        Thread producerThread = new Thread(new producer(taskqueue, MAX_CAPACITY), "Producer");


        Thread consumerThread = new Thread(new consumer(taskqueue), "Consumer");

        producerThread.start();

        consumerThread.start();


        Thread producerThread2 = new Thread(new producer(taskqueue, MAX_CAPACITY), "Producer2");


        Thread consumerThread2 = new Thread(new consumer(taskqueue), "Consumer2");

        producerThread2.start();

        consumerThread2.start();

    }

}
