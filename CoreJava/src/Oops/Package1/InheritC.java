package Oops.Package1;

public class InheritC extends InheritA{
    public static void main(String[] args) {
        //System.out.println("privateMember: " + privateMember);
        // Inherited members are directly accessible
        System.out.println("defaultMember: " + defaultMember);
        System.out.println("protectedMember: " + protectedMember);
        System.out.println("publicMember: " + publicMember);
    }
}
