import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TryCatch {
    public static void main(String[]args){
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("test.txt"));
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }

        //try with resources:
        try (Scanner scan = new Scanner(new File("test.txt"))) {
            while (scan.hasNext()) {
                System.out.println(scan.nextLine());
            }
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }
    }

}
