class MyException extends Exception{
String str1;

MyException(String str2){
    str1=str2;
}
    public String toString () {
        return ("My Exception Occured");
    }
}

class InvalidProductException extends Exception{
    public InvalidProductException(String s){
        super(s);
    }
}
public class CustomException {

    void productCheck(int weight) throws InvalidProductException{
        if(weight<100){
            throw new InvalidProductException( "Product Invalid" );
        }
    }
    public static void main(String[]args){
        try{
            throw  new MyException("error message");
        }
        catch (MyException ex){
            System.out.println("caught");
            System.out.println(ex);
        }

        CustomException customExceptionObject = new CustomException();
        try{
            customExceptionObject.productCheck( 80 );
        }
        catch(InvalidProductException ex){
            System.out.println("caught in exception");
            System.out.println(ex.getMessage());
        }

    }
}
