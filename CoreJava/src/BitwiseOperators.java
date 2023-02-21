public class BitwiseOperators {
    static void bitwiseOperators() {
        System.out.println("\nInside bitwiseOperators ...");
        int xValue = 1;
        int yValue = 3;

        System.out.println("xValue & y: " + (xValue & yValue));
        System.out.println("xValue | yValue: " + (xValue | yValue));
        System.out.println("xValue ^ yValue: " + (xValue ^ yValue));


        System.out.println("~xValue: " + (~xValue));
        System.out.println("true & false: " + (true & false));

        char CharacterExValueample1 = 'a'; // U+0061 --> 0110 0001
        char CharacterExValueample2 = 'b'; // U+0062 --> 0110 0010
        System.out.println("CharacterExValueample1  | CharacterExValueample2 : " + (CharacterExValueample1 | CharacterExValueample2)); // 0110 0011 --> 99 in decimal

    }
    public static void main(String[]args){
        try{
            bitwiseOperators();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
