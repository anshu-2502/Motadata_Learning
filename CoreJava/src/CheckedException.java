import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CheckedException {
    public static void main (String[] args)  {
//        FileInputStream finalInputStreamObject = null;
//
//        finalInputStreamObject = new FileInputStream( "/home/anshu/Desktop/AnshuSharma(2019BtechCSE009).pdf" );
//
//        int k;
//
//        while (( k = finalInputStreamObject.read() ) != -1) {
//            System.out.println( (char) k );
//        }
//
//        finalInputStreamObject.close();


        FileInputStream finalInputStreamObject = null;

        try {

            finalInputStreamObject = new FileInputStream( "/home/anshu/Desktop/AnshuSharma(2019BtechCSE009).pdf" );
        }
        catch(FileNotFoundException e){
            System.out.println("give the right path: ");
        }
        int k;

        try {

            while (( k = finalInputStreamObject.read() ) != -1) {
                System.out.println( (char) k );
            }
            finalInputStreamObject.close();
        }
        catch ( IOException e){
            System.out.println("I/O ERROR OCCURRED");
        }
        finally {
            System.out.println("finally block executed.");
        }
    }
}
