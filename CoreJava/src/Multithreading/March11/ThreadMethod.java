package Multithreading.March11;

public class ThreadMethod extends Thread {
    public void run() {

        for(int i=0;i<10;i++) {

            System.out.println("thread methods demo");

            try {

                System.out.println("thread is going to sleep");

                ThreadMethod.sleep(1000);

                System.out.println("thread wake up");

            } catch (InterruptedException e) {

                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) throws
            InterruptedException {
        ThreadMethod de = new
                ThreadMethod();

        System.out.println("getstate1"+de.getState());
        Runnable state;
        de.start();
        System.out.println("getstate2"+de.getState());

        System.out.println("getstate3"+de.getState());

        System.out.println("getstate4"+de.getState());

        System.out.println("thread Name"+de.getName());

        System.out.println("getstate5"+de.getState());
    }
}