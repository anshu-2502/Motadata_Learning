package Multithreading.March10.Synchronization;
        class Table{
            synchronized void printTable(int number){   //method not synchronized

                 for(int iterator=1;iterator<=5;iterator++){

                     System.out.println(number*iterator);

                     try{

                  Thread.sleep(400);

            }
            catch(Exception e){

                System.out.println(e);

            }
        }

    }
}

    class MyThread1 extends Thread{
        Table table;
        MyThread1(Table table){

            this.table=table;
     }
      public void run(){

            table.printTable(5);

    }

}
class MyThread2 extends Thread{
    Table table;
    MyThread2(Table table){

        this.table=table;

    }
    public void run(){

        table.printTable(100);

    }
}
public class Synchronization {

    public static void main(String[]args){
        Table obj = new Table();//only one object
        MyThread1 table1=new MyThread1(obj);
        MyThread2 table2=new MyThread2(obj);
        table1.start();
        table2.start();
    }
}
