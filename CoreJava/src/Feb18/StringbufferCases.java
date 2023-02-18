package Feb18;

public class StringbufferCases {

    public static void main (String[] args) {


        System.out.println("string bufffer");


        StringBuffer sbu = new StringBuffer("hello");
        StringBuffer sbu1 = new StringBuffer("hello");

        System.out.println(sbu.equals(sbu1));

        System.out.println(sbu==sbu1);

        StringBuilder stringbuilderObject1 = new StringBuilder("hello");

        StringBuilder stringBUilderObject2 = new StringBuilder("hello");

        System.out.println("string builder");

        System.out.println(stringbuilderObject1.equals( stringBUilderObject2 ));

        System.out.println(stringbuilderObject1==stringBUilderObject2);


    }
}
