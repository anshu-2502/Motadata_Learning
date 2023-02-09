package Oops.Package1;

import OOPS.Package2.InheritC2;

public class InheritB {
    public static void main(String[] args) {
        //System.out.println("A1.privateMember: " + A1.privateMember);

        System.out.println("A1.defaultMember: " + InheritA.defaultMember);
        System.out.println("C1.defaultMember: " + InheritC.defaultMember);

        System.out.println("A1.protectedMember: " + InheritA.protectedMember);
        System.out.println("C1.protectedMember: " + InheritC.protectedMember);
        System.out.println("C2.protectedMember: " + InheritC2.protectedMember);

        System.out.println("A1.publicMember: " + InheritA.publicMember);
        System.out.println("C1.publicMember: " + InheritC.publicMember);
    }
}
