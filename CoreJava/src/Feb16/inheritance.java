package Feb16;

import java.io.IOException;

class InheritanceBaseClass{

    public void baseclassMethod()  {

//    public void baseclassMethod() throws IOException  {

        System.out.println("base class hello");

    }


}

class InheritanceDerivedClass extends InheritanceBaseClass {

    public void baseclassMethod() throws ArithmeticException{

//    public void baseclassMethod() throws IOException{

        System.out.println("derived class hello");

    }


}
public class inheritance {

    public static void main(String[]args){

        InheritanceBaseClass inheritanceBaseClassObject = new InheritanceDerivedClass();

        InheritanceBaseClass inheritanceBaseClassObject2 = new InheritanceBaseClass();

        try {

            inheritanceBaseClassObject.baseclassMethod();

            inheritanceBaseClassObject2.baseclassMethod();

        }
        catch (Exception e){

            System.out.println(e);

        }





    }
}
