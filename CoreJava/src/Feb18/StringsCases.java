package Feb18;

public class StringsCases {

    public static void main(String[]args){

        String s = new String("anushka");

        String s2 = "anushka";

        System.out.println("Equals literal and object : " + s.equals(s2));

        System.out.print("== literal and object :");
        System.out.println(s==s2);

        String s3 = new String("anushka");

        System.out.println(" equals object and object : " + s.equals(s3));

        System.out.print("== object and object :");
        System.out.println(s==s3);

        String s4 = "anushka";

        System.out.println(" equals literal and literal : " + s2.equals(s4));

        System.out.print("== literal and literal :");

        System.out.println(s2==s4);




    }
}
