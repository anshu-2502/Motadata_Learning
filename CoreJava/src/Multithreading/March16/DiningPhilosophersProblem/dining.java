package Multithreading.March16.DiningPhilosophersProblem;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class dining {

    public static void main(String[]args) throws InterruptedException{
        ExecutorService executorService = null;

        philosopher[] philosophers = null;

        chopstick[] chopsticks =null;

        try{
            philosophers = new philosopher[constants.NUMBER_OF_PHILOSOPHERS];

            chopsticks = new chopstick[constants.NUMBER_OF_CHOPSTICK];

            for(int iterator=0; iterator<constants.NUMBER_OF_CHOPSTICK; iterator++ ) {

                chopsticks[iterator] = new chopstick(iterator);
            }

                executorService= Executors.newFixedThreadPool(constants.NUMBER_OF_PHILOSOPHERS);

            for(int iterator=0; iterator<constants.NUMBER_OF_PHILOSOPHERS; iterator++ ) {

                philosophers[iterator] = new philosopher(iterator, chopsticks[iterator], chopsticks[(iterator+1)%constants.NUMBER_OF_PHILOSOPHERS]);

                //executing the phliosophers threads one by one:

                executorService.execute(philosophers[iterator]);

            }

            Thread.sleep(constants.SIMULATION_RUNNING_TIME);

            for(philosopher philosopher: philosophers){

//                philosopher.setFull(true);
            }

        }
        finally{
            executorService.shutdown();

            while(!executorService.isTerminated()){

                Thread.sleep(1000);

            }

            //how many times philosopher eats
            for(philosopher philosopher: philosophers){
                System.out.println(philosopher + "eat #");
            }


        }

    }
}
