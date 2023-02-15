import java.io.IOException;

class Baseclass{

    private void privatemethod(){
        System.out.println("in base class private method");
    }
    public void hello(String s) {

        privatemethod();
         System.out.println("hello");
     }

      static void hello2(String f){
         System.out.println("in base class static hello");
     }


}

class Derivedclass extends  Baseclass{


     public void hello(String s) {
         System.out.println("hello2");
//         privatemethod();

//         super.hello("anushka");
     }

     static void hello2(String f){

        System.out.println("in derived class static hello");
    }
/*
    private void privatemethod(){


        System.out.println("in derived class private method");

    }
*/


}

public class Inheritance {
     public static void main(String[]args) {

         Baseclass b = new Derivedclass();
//         Baseclass b1 = new Baseclass();
         b.hello("anshu");
         Baseclass.hello2("a");

         Derivedclass.hello2("a");
//         b1.privatemethod();



     }
}
