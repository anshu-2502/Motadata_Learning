
interface PrivateMethodexample{
    public abstract void abstractMethod();

    public default void defaultMethodExample(){

        privateMethod();

        privatestaticMethod();

        System.out.println("inside default method");


    }

    private  void privateMethod(){

        System.out.println("private method in interface");

    }

    private static  void privatestaticMethod(){

        System.out.println("private static method in interface");

    }
}

public class PrivateMethodInterface implements PrivateMethodexample{
    @Override
    public void abstractMethod() {

        System.out.println("abstract method classes , overriden from interface");

    }

    public static void main(String[]args){

        PrivateMethodInterface PrivateMethodInterfaceobject = new PrivateMethodInterface();

        PrivateMethodInterfaceobject.defaultMethodExample();

        PrivateMethodInterfaceobject.abstractMethod();

    }
}
