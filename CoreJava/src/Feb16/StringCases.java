package Feb16;

public class StringCases {

    public static void main(String[]args){


        String stringvariable1 = new String("created in pool as well as heap");

        String stringvariable2 = "hi anushka";

        stringvariable1 = stringvariable2+ "  " + stringvariable1;

        System.out.println(stringvariable1);

        System.out.println("total string objects= 4");



    }
}
