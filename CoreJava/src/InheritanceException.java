import java.io.IOException;

    public class InheritanceException {

        // SuperClass doesn't declare any exception
        void method() throws RuntimeException {
            System.out.println("SuperClass");
        }
    }

    // SuperClass inherited by the SubClass
    class SubClass extends InheritanceException {

        // method() declaring Checked Exception IOException
//        void method() throws IOException {

//            void method() throws ArithmeticException {
void method()  {

            // IOException is of type Checked Exception
            // so the compiler will give Error

            System.out.println("SubClass");
        }

        // Driver code
        public static void main(String args[]) {
            InheritanceException s = new SubClass();
            s.method();
        }
    }


