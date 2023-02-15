class ApplicationException extends Exception {
    public ApplicationException(Exception e) {
        super(e);
    }
}
public class ChainedException {

    public static void test() throws ApplicationException {
        try {
            int a = 0;
            int b = 1;
            System.out.println(b/a);
        }catch(Exception e) {
            throw new ApplicationException(e);
        }
    }
    public static void main(String[] args) {
        try {
            test();
        }catch(ApplicationException e) {
            System.out.println(e.getMessage());
        }
    }


}



