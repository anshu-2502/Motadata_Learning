public class Encapsulation {

    // private field
    private int age;

    // getter method
    public int getAge() {
        return age;
    }

    // setter method
    public void setAge(int age) {
        this.age = age;
    }
    public static void main(String[] args) {

        try{

        // create an object of Person
        Encapsulation encapsulatedobject = new Encapsulation();

        // change age using setter
        encapsulatedobject.setAge(24);

        // access age using getter
        System.out.println("My age is " + encapsulatedobject.getAge());
    }
        catch (Exception e){
            System.out.println(e);
        }
    }

}
