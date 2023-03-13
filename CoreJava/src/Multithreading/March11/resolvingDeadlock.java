package Multithreading.March11;

public class resolvingDeadlock {
    private class resource1 {
        private int value = 10;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    // resource2
    private class resource2 {
        private int value = 10;

        public int getValue() {

            return value;

        }

        public void setValue(int value) {

            this.value = value;

        }
    }
    public static void main(String args[]) {

        resolvingDeadlock resolvingDeadlock = new resolvingDeadlock();

        final resource1 resource1Object = resolvingDeadlock.new resource1();

        final resource2 resource2Object = resolvingDeadlock.new resource2();

        // Thread-1
        Runnable runnable = new Runnable() {
            public void run() {

                synchronized (resource2Object) {

                    try {
                        /* Adding delay so that both threads can start trying to lock resources */

                        Thread.sleep(100);

                    } catch (InterruptedException e) {

                        e.printStackTrace();
                    }
                    // Thread-1 have resource1 but need resource2 also
                    synchronized (resource1Object) {

                        System.out.println("In block 1");
                    }
                }
            }
        };

// Thread-2
        Runnable runnable2 = new Runnable() {
            public void run() {

                synchronized (resource2Object) {
                    // Thread-2 have resource2 but need resource1 also

                    synchronized (resource1Object) {

                        System.out.println("In block 2");
                    }
                }
            }
        };


        new Thread(runnable).start();

        new Thread(runnable2).start();
    }



    }


