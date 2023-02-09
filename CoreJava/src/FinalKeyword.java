
//final class and final method:
final class FinalClass {
    public  final void display() {
        System.out.println("This is a final method.");
    }

}
//final class cannot be overidden:

//public class FinalKeyword extends FinalClass {
public  class FinalKeyword {

    //creating final method:
    final static int a =5;
    public static  void main(String[]args){
        final int b =6;
        //final instance variable can't be change
//        a= 4;
        //final local variable can't be changed
//        b =12;
        System.out.println("final instance variable = " + a);
        System.out.println("final local variable = " + b);

        FinalKeyword finalkeywordobject = new FinalKeyword();

//        finalkeywordobject.display();


    }


}
