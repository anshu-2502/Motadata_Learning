package Feb18;


import java.io.FileNotFoundException;
import java.io.IOException;

class exceptionchecking{

    public void exceptionCheckingMethod()throws IOException {

        System.out.println("base class executed");

    }

}
public class CheckedException extends exceptionchecking {


    public void exceptionCheckingMethod() throws ArithmeticException {

        System.out.println("derived class executed");

    }


    public static void main (String[] args) {

        exceptionchecking ec = new CheckedException();
        try {

            ec.exceptionCheckingMethod();
        }
        catch (Exception e){

        }


    }
}
