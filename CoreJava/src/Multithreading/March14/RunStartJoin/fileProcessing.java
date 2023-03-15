package Multithreading.March14.RunStartJoin;

import Multithreading.March11.ThreadMethod;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class fileProcessing {

    private static void runThread(File[] filesList, int numberOfThreads, int thread, int filesPerThread, int remainingFiles){

        List<File> inFile = new ArrayList<>();

        //assigning files equally to each threads

        for(int iterator=thread*filesPerThread; iterator<(thread+1)*filesPerThread;iterator++){

            inFile.add(filesList[iterator]);
        }

        //assigning remaining files to the last thread

        if(thread==numberOfThreads-1 && remainingFiles>0){

            for(int remainingFilesIterator = filesList.length-remainingFiles; remainingFilesIterator<filesList.length; remainingFilesIterator++){

                inFile.add(filesList[remainingFilesIterator]);
            }
        }

        //processing files one by one:
try {
    for (File file : inFile) {
        System.out.println("processing" + file.getName() + "in thread" + Thread.currentThread().getName());
    }
}
catch(Exception e){
    System.out.println("file not found");
}

    }
    public static void main(String[]args){

        File filePath = new File("/home/anshu/Documents/Files");

        File filesList[] = filePath.listFiles();

        int numberOfThreads = 2;

        Thread[] threads = new Thread[numberOfThreads];

        final int filesPerThread = filesList.length/numberOfThreads;

        final int remainingFiles = filesList.length%numberOfThreads;

        //assigning files dynamically to each thread

        for(int threadIterator=0; threadIterator<numberOfThreads; threadIterator++){

            final int thread = threadIterator;

            threads[threadIterator] = new Thread(){
                public void run(){

                    runThread(filesList, numberOfThreads, thread, filesPerThread,remainingFiles);

                }
            };


        }



        for(Thread thread1 :threads){
            thread1.start();

            ThreadMethod.yield();
            System.out.println("main thread running");

            //starting processing all the threads

//            try{
//                thread1.join();
//
//
//            }
//            catch (InterruptedException e){
//
//            }
        }

        for(Thread thread2: threads){

            try{
                thread2.join();  //waiting until all threads completes the execution


            }
            catch (InterruptedException e){

            }
        }

    }
}
