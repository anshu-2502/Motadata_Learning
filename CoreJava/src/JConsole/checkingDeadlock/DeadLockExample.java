package JConsole.checkingDeadlock;

public class DeadLockExample {
    public static Object ResourceA = new Object();
    public static Object ResourceB = new Object();

    private static class Worker1 implements Runnable {
        public void run() {
            synchronized (ResourceA) {
                System.out.println("Worker1: Holding ResourceA...");
                doSomeWork();
                System.out.println("Worker1: Waiting for ResourceB...");
                synchronized (ResourceB) {
                    System.out.println("Worker1: Holding ResourceA & ResourceB...");
                    doSomeOtherWork();
                }
            }
        }

        public void doSomeWork() {
            try {
                System.out.println("Worker1: Doing Some Work...");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void doSomeOtherWork() {
            try {
                System.out.println("Worker1: Doing Some Other Work...");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class Worker2 implements Runnable {
        public void run() {
            synchronized (ResourceB) {
                System.out.println("Worker2: Holding ResourceB...");
                doSomeWork();
                System.out.println("Worker2: Waiting for ResourceA...");
                synchronized (ResourceA) {
                    System.out.println("Worker2: Holding ResourceB & ResourceA...");
                    doSomeOtherWork();
                }
            }
        }

        public void doSomeWork() {
            try {
                System.out.println("Worker2: Doing Some Work...");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void doSomeOtherWork() {
            try {
                System.out.println("Worker2: Doing Some Other Work...");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


    public static void main(String[] args) {
        Thread t1 = new Thread(new Worker1(), "Thread_1");
        Thread t2 = new Thread(new Worker2(), "Thread_2");

        t1.start();
        t2.start();
    }



}