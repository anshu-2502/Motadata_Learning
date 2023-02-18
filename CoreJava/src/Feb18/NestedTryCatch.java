package Feb18;

public class NestedTryCatch {

    public static void main(String[] args){

//        try{
//
//            System.out.println("main try block");
//
//            int b = 99/0;
//
//            try{
//
//                System.out.println("block-2");
//
//                Integer integer = new Integer( "hii" );
//
//                try{
//
//                    int a = 4/0;
//
//                }catch (ArrayIndexOutOfBoundsException e ){
//
//                    System.out.println("index out of bound");
//                }
//            }
//            catch(NumberFormatException e){
//
//                System.out.println("number format");
//
//            }
//            System.out.println("before main catch block");
//        }
//        catch(ArithmeticException e){
//
//            System.out.println("arithmetic exception");
//
//        }


        try{


            try{

                int a= 453/0;

                System.out.println("block-1");

            }
            catch(Exception e){
                System.out.println("block-1 exception");
            }

            try{

                System.out.println("block-2");

                int a = 34/0;


            }

            catch (Exception e){

                System.out.println("block-2 exception");
            }

            System.out.println("try block before main ");
        }
        catch (Exception e){
            System.out.println("e");
            System.out.println("main try block");
        }


    }
}
