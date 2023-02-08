public class Recursion {

    static int NonRecursiveFactorial(int number){

        if(number==1 || number==0){
            return 1;
        }

        int factorial = number;
        while(number>=2){

            factorial = factorial*(number-1);

            number--;
        }

        return  factorial;

    }

    static int RecursiveFactorial(int number){

        if(number==0){  //base condition

            return 1;
        }
        return number*RecursiveFactorial(number-1);
    }

    public static void main(String[]args){
        System.out.println("non recursively: "+ NonRecursiveFactorial(4));
        System.out.println("recursively: "+ RecursiveFactorial(4));
    }
}
