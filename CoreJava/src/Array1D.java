public class Array1D {
    String name;
    static void arrays(){


        int scores[] = new int[]{70,30,67,89};
        System.out.println("exam-1: " +scores[0]);
        System.out.println("exam-2: " +scores[1]);
        System.out.println("final-exam: "+ scores[2]);
        System.out.println("project: "+ scores[3]);
    }

    public static void main(String[]args){
        arrays();
        Array1D[] arrayslist = {new Array1D(), new Array1D(), new Array1D()};
        arrayslist[0] = new Array1D();
        arrayslist[1] = new Array1D();
        arrayslist[2] = new Array1D();

        arrayslist[0].name = "Anshu";

        System.out.println("one: "+ arrayslist[0].name);
        System.out.println("two: "+ arrayslist[1].name);
        System.out.println("three: "+ arrayslist[2].name);
    }
}
