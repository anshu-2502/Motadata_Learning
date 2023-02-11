interface DefaultInterface{
    //abstract method:
    public void square(int a);

    default  void defaultMethodExecution(){
        System.out.println("default method in interface");
    }
}

public class DefaultMethodInterface implements  DefaultInterface {

    @Override
    public void square(int a) {
        System.out.println("area of square:"+ a*a);
    }

    public static void main(String[]args){
        DefaultMethodInterface defaultMethodInterfaceObject = new DefaultMethodInterface();
        defaultMethodInterfaceObject.square(5);
        defaultMethodInterfaceObject.defaultMethodExecution();





    }

}
