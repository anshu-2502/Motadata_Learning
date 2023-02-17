package Feb16;

public class Overloading {


    public void sum(int a , int b){

        System.out.println("The sum is "+a+b);
    }

    public void sum(long a , long b){

        System.out.println("the sum is "+a+b);

    }

    public void sum(int a , long b){

        System.out.println("first");

    }


    public void sum(long a, int b){

        System.out.println("second");

    }

    public static void main(String[]args){

        Overloading overloadingObj = new Overloading();

        overloadingObj.sum(10,10);

    }
}
