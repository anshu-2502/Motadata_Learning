package Feb16;

class VariableScopingTest{
    private int integerdataPrivate =4;

    protected int integerDataProtected =6;

    static int integerDataStatic= 8;

    int integerDataDefault=10;

}

public class VariableScoping extends VariableScopingTest {

    private int integerdataPrivate =4;

    protected int integerDataProtected =6;

    static int integerDataStatic= 9;

    int integerDataDefault=10;


    public static void main(String[]args){

        VariableScopingTest variableScopingObject = new VariableScoping();

//        System.out.println("Private variable in same class"+ variableScopingObject.integerdataPrivate);

        System.out.println("Protected variable scope class "+ variableScopingObject.integerDataProtected);

        System.out.println("static variable in derived class "+ integerDataStatic);

        System.out.println("static variable in base class "+ variableScopingObject.integerDataStatic);

        System.out.println("static variable in base class "+ variableScopingObject.integerDataDefault);

    }
}
