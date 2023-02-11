import java.lang.Cloneable;
public class CloneableclassExample implements Cloneable {

    int integer;
    String string;

    public CloneableclassExample(int integer, String string){
        this.integer =integer;
        this.string =string;
    }

    protected Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
    public static void main(String[]args) throws CloneNotSupportedException{

        CloneableclassExample cloneableclassExampleobject = new CloneableclassExample(21, "Anushka");

        CloneableclassExample b = (CloneableclassExample)cloneableclassExampleobject.clone();

        System.out.println(b.integer);
        System.out.println(b.string);

    }
}
