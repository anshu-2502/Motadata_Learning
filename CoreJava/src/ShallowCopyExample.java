class ShallowCopyInstance{
    int shallowCopyVariable = 30;

}
public class ShallowCopyExample {
    public static void main(String[]args){

        //becoz shallow copy both the instances points same memory location.

        ShallowCopyInstance instance1 = new ShallowCopyInstance();

        ShallowCopyInstance instance2 = new ShallowCopyInstance();

        instance1 =instance2;

        instance2.shallowCopyVariable =4;

        if(instance1.equals(instance2)){
            System.out.println( instance2 +" " + instance1 + " "+ " true");
        }

        System.out.println(instance2.shallowCopyVariable);



    }


}
