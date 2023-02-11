//static method in interface

interface  StaticMethodInterface{

    static void greet(){
        System.out.println("hello");

    }
      void methodToBeOverride(String str);

}
public class StaticInterface implements StaticMethodInterface {
    public static void main(String[]args){

        StaticInterface staticInterfaceobject = new StaticInterface();

        StaticMethodInterface.greet();

        staticInterfaceobject.methodToBeOverride("overidden method");

    }
    @Override
    public void methodToBeOverride(String str) {
        System.out.println(str);

    }
}
