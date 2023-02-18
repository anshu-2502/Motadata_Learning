package Feb18;

public class MethodOverloading {

    public static int sum(int a, int b){

        int sum =a+b;

        System.out.println("sum is" + a+b);

        System.out.println((a+b));

        return sum;

    }

    public static long sum(long a,long b){

        long sum = a+b;

        return sum;

    }


    public static void main(String[]args){


        sum(10,10);

    }
}
