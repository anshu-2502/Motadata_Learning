import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;
public class Stringbuilder {
    public static void main(String[]args){

//        StringBuilder stringbuilderobject = new StringBuilder();
//        stringbuilderobject.append("Anushka");
//        System.out.println("string="+ stringbuilderobject.toString());
//
//        StringBuilder stringBuilderObject2 = new StringBuilder("Anshu");
//
//        System.out.println("string2= "+ stringBuilderObject2.toString());

        StringBuilder stringBuilderObject3 = new StringBuilder(4);
        stringBuilderObject3.append("Anushka ");

        System.out.println("string object3= "+ stringBuilderObject3.toString());

        stringBuilderObject3.append("Sharma");
        System.out.println("string object3 after appending= "+ stringBuilderObject3.toString());

        stringBuilderObject3.insert(7," Ramesh");
        System.out.println("string object3 after insert being called= "+ stringBuilderObject3.toString());

        stringBuilderObject3.replace(0,7,"Anshu");
        System.out.println("string object3 after replace being called= "+ stringBuilderObject3.toString());

        stringBuilderObject3.delete(2,5);
        System.out.println("string object3 after delete being called= "+ stringBuilderObject3.toString());

        stringBuilderObject3.reverse();
        System.out.println("string object3 after reversing: "+ stringBuilderObject3.toString());



        //
//        System.out.println("String object 3 capacity = "+ stringBuilderObject3.capacity());
//
//        StringBuilder stringBuilderObject4 = new StringBuilder(stringbuilderobject);
//        System.out.println("string 4= "+ stringBuilderObject4.toString());
////
//        StringBuilder s1 = new StringBuilder("Hello");
//        StringBuilder s2 =new StringBuilder("Hello");
//
//        System.out.println(s1.equals(s2));
//
//        System.out.println(s1==s2);
//
//        System.out.println();
//
//
//        System.out.println("string");
//
//        String s11 = new String("hello");
//        String s12 = "hello";
//        String s13 = "hello";
//
//        System.out.println(s11.equals(s12));
//
//        System.out.println(s11==s12);
//
//        System.out.println("string bufffer");
//
//
//        StringBuffer sbu = new StringBuffer("hello");
//        StringBuffer sbu1 = new StringBuffer("hello");
//
//        System.out.println(sbu.equals(sbu1));
//
//        System.out.println(sbu==sbu1);




    }
}
