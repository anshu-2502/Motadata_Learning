public class NestedTryCatch {
    public static void main(String[]args){
//        try{
//            try {
//                try {
//                    int arr[] = {1, 2, 3, 4};
//                    System.out.println( arr[10] );
//                }
//
//                catch(ArithmeticException e){
//                    System.out.println("try block-3");
//                }
//
//
//            }
//            catch (ArithmeticException e){
//                System.out.println("try block-2");
//            }
//        }
//        catch (ArithmeticException e){
//            System.out.println("main base try-block");
//        }
//
//        catch (ArrayIndexOutOfBoundsException e){
//            System.out.println("in main");
//        }
//        catch (Exception e){
//            System.out.println("in main, exception class called");
//        }


        try{  //-->> main try block
            try{
                System.out.println("inside block-1");
                int b =45/0;
                System.out.println(b);
            }
            catch(ArithmeticException e1){
                System.out.println("Exception e1");
            }

            try{
                System.out.println("inside block-2");
                int b= 45/0;
                System.out.println(b);
            }
            catch (ArrayIndexOutOfBoundsException e2){
                System.out.println("exception e2");
            }
            System.out.println("just any other statement");
        }

        catch (ArithmeticException e3){
            System.out.println("arithmetic exception");
            System.out.println("inside parent try catch");
        }


        catch (ArrayIndexOutOfBoundsException e4){
            System.out.println("array index out of bound exception");
            System.out.println("inside parent try catch");
        }

        catch (Exception e5){
            System.out.println("inside parent try catch");
        }

        System.out.println("end");

    }
}
