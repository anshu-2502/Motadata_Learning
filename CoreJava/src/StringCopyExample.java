//Strings are immutable so in string its neither deepcopy nor shallow copy
public class StringCopyExample {

    public static void main(String[]args){

        String string1 = new String("my name is anshu ");

        String string2 = string1;

        string2 = "my name is anushka";

        System.out.println("The hash code of string1 is: " + string1.hashCode());
        System.out.println( "THE FIRST OBJECT OF STRING IS : "+string1);

        System.out.println("The hash code of string2 is: " + string2.hashCode());
        System.out.println( "THE FIRST OBJECT OF STRING IS : "+string2);

    }
}
