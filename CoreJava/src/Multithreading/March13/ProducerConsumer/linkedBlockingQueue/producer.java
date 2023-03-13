package Multithreading.March13.ProducerConsumer.linkedBlockingQueue;

import java.util.concurrent.BlockingQueue;

public class producer implements  Runnable {

    private final BlockingQueue<Integer> taskqueue;

    private final int MAX_CAPACITY;

    public producer(BlockingQueue<Integer> sharedQueue, int size){
        this.taskqueue = sharedQueue;
        this.MAX_CAPACITY = size;

    }
    @Override
    public void run() {
        int counter =0;
        while(true){

            try{
                produce(counter++);
            }
            catch(InterruptedException e){

                e.printStackTrace();
            }
        }

    }

    private void produce(int number) throws InterruptedException{

        synchronized (taskqueue){
            while(taskqueue.size() ==MAX_CAPACITY){
                System.out.println("queue is full" + Thread.currentThread().getName());
                taskqueue.wait();
            }

            Thread.sleep(1000);
            taskqueue.add(number);
            System.out.println("produced" + number);
            taskqueue.notifyAll();
        }

    }
}
