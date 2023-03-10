package Multithreading.March10.Synchronization;

class Sender{
    public void senderMessage(String message){

        System.out.println("sending a message: " + message);

        try{

            Thread.sleep(800);

        }
        catch(Exception e){

            System.out.println("thread interrupted");

        }

        System.out.println(message + "sent");
    }

}

class SenderWThreads extends Thread{

    private String message;

    Sender sender;

    SenderWThreads(String message , Sender object){
        this.message = message;
        sender = object;
    }

    public void run(){
        synchronized (sender){
            sender.senderMessage(message);
        }
    }


}
public class SynchronizedBlock {

    public static void main(String[]args){

        Sender sender = new Sender();

        SenderWThreads sender1 = new SenderWThreads("hie " , sender);

        SenderWThreads sender2 = new SenderWThreads("welcome here ",sender);

        sender1.start();

        sender2.start();

        try{
            sender1.join();

            sender2.join();
        }

        catch(Exception e){
            System.out.println("interrupted");
        }


    }
}
