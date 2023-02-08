public class TYpeCasting {
    static void typeCasting() {
        System.out.println("\n");
        // Explicit casting
        long y = 42;
        //int x = y;
        int x = (int)y;


        byte narrowdByte = (byte)123456;
//        byte narrowdByte = 123456;
        System.out.println("narrowdByte: " + narrowdByte);


        int iTruncated = (int)0.99;
        System.out.println("iTruncated: " + iTruncated);

        // Implicit cast (int to long)
        y = x;

        // Implicit cast (char to int)
        char cChar = 'A';
        int iInt = cChar;
        System.out.println("iInt: " + iInt);

        // byte to char using an explicit cast
        byte bByte = 65;
        cChar = (char)bByte; //widinng from byte
        System.out.println("cChar: " + cChar);
    }
    public static void main(String[]args){
        typeCasting();
    }

}
