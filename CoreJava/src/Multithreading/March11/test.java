package Multithreading.March11;
class ChildClass1 extends Thread {
    // overriding the run() method
    public void run() {
        System.out.println("Run method of the first class.");
    }
}


class ChildClass2 extends Thread {
    // overriding the run() method
    public void run() {
        System.out.println("Run method of the second class.");
    }
}

class ChildClass3 extends Thread {
    // overriding the run() method
    public void run() {
        System.out.println("Run method of the third class.");
    }
}

public class test {
    public static void main(String args[]) {
        // creating object of the sub classes.
        ChildClass1 cc1 = new ChildClass1();
        ChildClass2 cc2 = new ChildClass2();
        ChildClass3 cc3 = new ChildClass3();
        cc1.start();
        cc2.start();
        cc3.start();


    }
}
