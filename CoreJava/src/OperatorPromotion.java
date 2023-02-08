public class OperatorPromotion {
    static void charTypePromotion() {
        System.out.println("Operator promotion ...");
        char Value = 50;  //utf-16 , 50 corrosponds to 2
        System.out.println("Value: " +  Value);
        System.out.println("(73 - value): " + (73 - Value)); // value gets promoted to int
        System.out.println("(value - '3'): " + (Value - '3')); // value & '3' are promoted to ints
        System.out.println("('a' + 'b'): " + ('a' +'b')); // 'a' & 'b' are promoted to ints and the respective equivalents 97 & 98 are added
    }

    public static void main(String[]args){
        try{
            charTypePromotion();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
