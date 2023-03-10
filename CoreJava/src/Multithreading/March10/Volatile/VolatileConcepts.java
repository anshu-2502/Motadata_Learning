package Multithreading.March10.Volatile;

 class VolatileData
{
    private volatile int counter = 0;
    public int getCounter()
    {
        return counter;
    }
    public void increaseCounter()
    {
        ++counter;      //increases the value of counter by 1
    }
}

class VolatileThread extends Thread
{
    private final VolatileData data;
    public VolatileThread(VolatileData data)
    {
        this.data = data;
    }
    @Override
    public void run()
    {
        int oldValue = data.getCounter();

        System.out.println("[Thread " + Thread.currentThread().getId() + "]: Old value = " + oldValue);

        data.increaseCounter();

        int newValue = data.getCounter();

        System.out.println("[Thread " + Thread.currentThread().getId() + "]: New value = " + newValue);
    }
}
public class VolatileConcepts {
    private final static int noOfThreads = 2;
    public static void main(String[] args) throws InterruptedException
    {
        VolatileData volatileData = new VolatileData();     //object of VolatileData class

        Thread[] threads = new Thread[noOfThreads];
        //creating Thread array

        for(int iterator = 0; iterator < noOfThreads; ++iterator) {

            threads[iterator] = new VolatileThread(volatileData);

        }
        for(int iterator = 0; iterator < noOfThreads; ++iterator){

            threads[iterator].start();
        }
                           //starts all reader threads
        for(int iterator = 0; iterator < noOfThreads; ++iterator) {

            threads[iterator].join();

        }//wait for all threads
    }
}