package Multithreading.March10.Synchronization;

class Display{

    public static synchronized void wish(String name) {

        for(int i=0;i<3;i++){

        System.out.print("Good Morning: ");

        System.out.println(name);

        try{

        Thread.sleep(2000);

        }
        catch(InterruptedException e)
        {
            System.out.println();
        }

           }

     }
          }

class MyThread extends Thread{
    Display display;
    String name;
    MyThread(Display display,String name)
    {
        this.display=display;
        this.name=name;
    }
    public void run()
    {

        display.wish(name);

    }
}

public class staticSynchronized {
    public static void main(String arg[])
    {
        Display d1=new Display();

        Display d2=new Display();

        MyThread t1=new MyThread(d1,"Anshu");

        MyThread t2=new MyThread(d2,"Anushka");

        t1.start();

        t2.start();
    }
}
