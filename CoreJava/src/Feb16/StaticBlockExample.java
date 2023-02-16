package Feb16;

    public class StaticBlockExample
    {
//        public static String variable1;

//        public static String variable2;

        {
            System.out.println("hi am i first ?");
        }


        static
        {

            System.out.println("In static block" );


            System.out.print("in static block method calling: ");
            DisplayStatic();

            Print();

        }
        static void DisplayStatic()
        {

            System.out.println("display static method-1");


        }

        static void Print()
        {

            System.out.println("static  print method-2");


        }



        public static void main(String arg[])
        {

            StaticBlockExample staticBlockExampleObject = new StaticBlockExample();

            StaticBlockExample staticBlockExampleObject2 = new StaticBlockExample();


            System.out.println("Hi Anushka");

            System.out.println("method-1 :");
            DisplayStatic();

            System.out.println("method-2 :");
            Print();
        }
    }

