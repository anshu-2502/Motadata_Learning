public class MethodOverloading {
    public int sum(int x , int y){

        return x+y;
    }

    public int sum(int x, int y , int z){

        return x+y+z;
    }
    public double sum(double x, double y){

        return x+y;
    }

    //changing the parameters i.e. interchanging

    public void StudentId(String name, int roll_no)
    {

        System.out.println("Name :" + name + " " + "Roll-No :" + roll_no);

    }
    public void StudentId(int roll_no, String name)
    {

        System.out.println("Roll-No :" + roll_no + " " + "Name :" + name);

    }
    public static void main(String[]args){

        MethodOverloading m = new MethodOverloading();

        System.out.println(m.sum(3,3));

        System.out.println(m.sum(3,3,4));

        m.StudentId("Anshu", 1);

        m.StudentId(2, "Anushka");

    }
}
