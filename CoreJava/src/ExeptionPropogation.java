import java.io.IOException;

public class ExeptionPropogation {

    void method1() throws IOException{
        System.out.println("hello in method 2");
        throw new IOException("device error");

    }

    void method2() throws IOException{
        method1();
        System.out.println("executed 1");
    }

    void method3(){
        try{
            System.out.println("executed 2");
            method2();
            System.out.println("executed 3");
        }
        catch(Exception e){
            System.out.println("exception handled");
        }
    }


    public static void main(String[]args){

        ExeptionPropogation exeptionPropogationObject = new ExeptionPropogation();
        exeptionPropogationObject.method3();




    }
}
