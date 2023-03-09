package Multithreading.March9;

import java.util.ArrayList;
import java.util.List;

public class multipleVirtualThreads {

    public static void main(String[]args){

        List<Thread> virtualThreads = new ArrayList<>();

        int virtualThreadCount = 100_000;

        for(int iterator=0; iterator<virtualThreadCount; iterator++){

            int virtualThreadIndex = iterator;

            Thread virtualThread = Thread.ofVirtual().start(()->{
                int result = 1;
                for(int virtualThreadIterator=0; virtualThreadIterator<10; virtualThreadIterator++){
                    result = result*(virtualThreadIterator+1);
                }

                System.out.println("Result[" + virtualThreadIndex + "]:" + result);
            });

            virtualThreads.add(virtualThread);
        }

        for(int iterator=0; iterator<virtualThreads.size(); iterator++){

            try{
                virtualThreads.get(iterator).join();
            }

            catch(InterruptedException e){

                throw new RuntimeException(e);

            }


        }


    }


}
