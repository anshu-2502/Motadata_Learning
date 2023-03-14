package Multithreading.March11;

public class test extends Thread
{
    public static void main(String [] args)
    {

        Thread t1 = new Thread(){
            @Override
            public void run() {
                notify();
            }
        };

       // t1.start();


        System.out.print("1 ");
        synchronized(args)
        {
            System.out.print("2 ");
            try
            {
                System.out.println("-------------");
                args.wait(5000);

            }
            catch(InterruptedException e){ }
        }
        System.out.print("3 ");
    }

}