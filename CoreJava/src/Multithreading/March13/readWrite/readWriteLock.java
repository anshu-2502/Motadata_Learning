package Multithreading.March13.readWrite;


import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class readWriteLock {

    ReadWriteLock readWritelock = new ReentrantReadWriteLock();

    private int count=0;

    public int incrementAndgetCount(){

        readWritelock.writeLock().lock();

        try{
            count++;
            return count;
        }
        finally {
            readWritelock.writeLock().unlock();
        }
    }

    public  int getCount(){

        readWritelock.readLock().lock();

        try{
            return count;
        }
        finally {
            readWritelock.readLock().unlock();
        }
    }
    public static void main(String[]args){

        readWriteLock readWriteLock = new readWriteLock();

        System.out.println(readWriteLock.getCount());

        System.out.println(readWriteLock.incrementAndgetCount());

        System.out.println(readWriteLock.incrementAndgetCount());

    }
}
