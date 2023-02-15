public class UncheckedExceptions {
    public static void main(String[]args){


        int num1 =10;
        int num2 =0;
        int res;

        try {

             res = num1 / num2;
        }
        catch(ArithmeticException e) {

            System.out.println( "number can't be divided by zero" );
        }
    }
}
