package Multithreading.March16.Executors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

class Processor implements Callable<String>{

    private int id;

    public Processor(int id){
        this.id = id;
    }

    @Override
    public String call() throws Exception{

        Thread.sleep(2000);

        return "Id:" + id;

    }
}
public class CallableAndFuture {

    public static void main(String[]args){

        ExecutorService service = Executors.newFixedThreadPool(2);

        List<Future<String>> list = new ArrayList<>();

        for(int iterator=0; iterator<5; iterator++){

            Future<String>future = service.submit(new Processor(iterator+1));

      list.add(future);
        }

        for(Future<String> f: list){

            try{
                System.out.println(f.get());
            }
            catch(InterruptedException | ExecutionException e){
                e.printStackTrace();
            }
        }

    }
}
