 public class NestedClass {

        String outerField = "Outer field";
        static String staticOuterField = "Static outer field";

        class InnerClass {
            void accessMembers() {
                System.out.println(outerField);
                System.out.println(staticOuterField);
            }
        }

        static class StaticNestedClass {
            void accessMembers(NestedClass outer) {
                // Compiler error: Cannot make a static reference to the non-static
                //     field outerField
                // System.out.println(outerField);
                System.out.println(outer.outerField);
                System.out.println(staticOuterField);
            }
        }

        public static void main(String[] args) {
            System.out.println("Inner class:");

            NestedClass outerObject = new NestedClass();
            NestedClass.InnerClass innerObject = outerObject.new InnerClass();
            innerObject.accessMembers();

            System.out.println("Static nested class:");

            StaticNestedClass staticNestedObject = new StaticNestedClass();
            staticNestedObject.accessMembers(outerObject);


        }
    }
