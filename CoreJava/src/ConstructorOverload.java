public class ConstructorOverload {

    ConstructorOverload(String name){
        System.out.println("constructor with one argument: "+ name);
    }

    ConstructorOverload(String name, int age){
        System.out.println("constructor with two argument, name:"+ name +" and age "+ age);
    }

    ConstructorOverload(String name, long phone){
        System.out.println("constructor with different data types, name:"+ name +" and phone "+ phone);
    }
    public static void main(String[]args){

        ConstructorOverload c1 = new ConstructorOverload("anushka");
        ConstructorOverload c2 = new ConstructorOverload("anushka" , 21);
        ConstructorOverload c3 = new ConstructorOverload("anushka",7023868885L);
    }
}
