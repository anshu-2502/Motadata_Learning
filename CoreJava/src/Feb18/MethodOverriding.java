package Feb18;

class MethodOverridingExample{

    public void overridingmethod(){
        System.out.println("in parent class ");
    }

    public double sum(double a, double b){
        double sum = a+b;

        System.out.println("in parent class sum");
        return sum;

    }

//    public long sum(long a, long b){
//        long sum = a+b;
//        return sum;
//    }

}
public class MethodOverriding extends MethodOverridingExample {

    public void overridingmethod(){
        System.out.println("in child class ");
    }

    public double sum(double a, double b){
        double sum = a+b;
        return sum;
    }

    public static void main(String[]args){

        MethodOverridingExample methodOverridingExampleObject = new MethodOverriding();

        methodOverridingExampleObject.overridingmethod();

        System.out.println(methodOverridingExampleObject.sum(  10.0,10.0));



    }
}
