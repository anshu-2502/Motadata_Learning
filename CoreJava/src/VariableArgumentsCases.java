public class VariableArgumentsCases {

    static void display(String... values){
        System.out.println("method invokation");
    }

    static void display(int num , String...values){
        System.out.println("number:"+ num);
    }

    static void display(long num, String... values){

    }
    public static void main(String[]args){

        display(  );
        display( "my", "name" , "is", "Anushka");

    }
}
