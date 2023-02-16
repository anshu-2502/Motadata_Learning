import java.io.IOException;

class InheritClass{
    public void mymethod() throws IOException {
        System.out.println("in inherit-class : my method");
    }
}
public class InheritanceExceptionHandle extends InheritClass {

    public void mymethod() throws IOException{
        System.out.println("in my method");
    }


    {
        System.out.println("hi {}");
    }
    public static void main(String[]args) throws IOException {
        InheritClass inheritanceExceptionHandleObject = new InheritanceExceptionHandle();
        inheritanceExceptionHandleObject.mymethod();

    }
}
