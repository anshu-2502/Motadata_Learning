class deepCopyInstance{
    int deepCopyVariable = 34;

}
public class DeepCopyExample {

    //changes in one entitiy cant be seen in other entity
    //each entity has its own independent reference

    public static void main(String[]args){

        deepCopyInstance deepCopyInstanceobject1 = new deepCopyInstance();
        deepCopyInstance deepCopyInstanceobject2 = new deepCopyInstance();

        deepCopyInstanceobject1.deepCopyVariable =7;

        System.out.println("object-1: "+deepCopyInstanceobject1);
        System.out.println("object-2: "+deepCopyInstanceobject2);

        System.out.println("object-1: "+deepCopyInstanceobject1.deepCopyVariable);
        System.out.println("object-2: "+deepCopyInstanceobject2.deepCopyVariable);


    }
}
