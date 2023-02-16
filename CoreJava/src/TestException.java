class ExceptionBaseClass{
    public void method(){

        int a = 4;
        int b = 5;
        int[]arr = {1,2,3,4,5};
        try{

//            int divide1 = a/0;

            try {
                int divide = a / arr[arr.length];
            }
            catch(Exception e){
                System.out.println(e);
            }

            int divide1 = a/0;

        }
        catch(Exception e){
            System.out.println(e);
        }

//        try {
//            int divide = a / arr[arr.length];
//        }
//        catch(Exception e){
//            System.out.println(e);
//        }
    }
}
public class TestException {
    public static void main(String[]args){
        ExceptionBaseClass exceptionBaseClassobject = new ExceptionBaseClass();

        exceptionBaseClassobject.method();

    }
}
