package Multithreading.March13.ProducerConsumer.linkedBlockingQueue;

import java.util.concurrent.BlockingQueue;

public class consumer implements Runnable {

    private final BlockingQueue<Integer> taskqueue;
    public consumer(BlockingQueue<Integer> taskqueue) {
        this.taskqueue = taskqueue;
    }

    @Override
    public void run() {

        while(true){

            try{

                consume();
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
        }

    }

    private void consume() throws InterruptedException{

        synchronized (taskqueue){
            while(taskqueue.isEmpty()){
                System.out.println("queue is empty" + Thread.currentThread().getName());

                taskqueue.wait();
            }
            Thread.sleep(1000);
            int remove =taskqueue.remove();
            System.out.println("consumed " + remove);
            taskqueue.notifyAll();
        }
    }
}
