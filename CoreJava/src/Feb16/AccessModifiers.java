package Feb16;

class BaseClass{

//    void display(){
//
//        System.out.println("BaseClass:- default modifier ");
//
//    }

//    public void display(){
//
//        System.out.println("BaseClass:- public  ");
//
//    }

    protected void display(){

        System.out.println("protected: base class");

    }

//    private void display(){
//
//        System.out.println("private :base class");
//
//    }

}

class DerivedClass extends BaseClass{


}

class DerivedderivedClass extends  DerivedClass{

}
public class AccessModifiers {

    public static void main(String[]args){


        BaseClass BaseClassObject = new BaseClass();

        DerivedClass derivedClassObject = new DerivedClass();

        DerivedClass DerivedClassObject = new DerivedderivedClass();

//        derivedClassObject.display();

        DerivedClassObject.display();








    }
}
