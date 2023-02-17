package Feb16;

import java.io.IOException;

class InheritanceBaseClass{

    public void baseclassMethod() {

        System.out.println("base class hello");

    }


}

class InheritanceDerivedClass extends InheritanceBaseClass {

    public void baseclassMethod(){

        System.out.println("derived class hello");

    }


}
public class inheritance {

    public static void main(String[]args){

        InheritanceBaseClass inheritanceBaseClassObject = new InheritanceDerivedClass();
        
        inheritanceBaseClassObject.baseclassMethod();





    }
}
