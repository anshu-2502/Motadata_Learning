package Feb16;

class StudentData{

    private int StudentID;

    private String StudentName;

    private int StudentAge;

    StudentData(){

        StudentID = 101;

        StudentName = "Anshu";

        StudentAge = 21;

    }

    StudentData(int id , String name , int age){

        StudentID = id;

        StudentName = name;

        StudentAge = age;

    }

    public int getStudentID (){

        return StudentID;
    }

    public void setStudentID(int StudentID){

        this.StudentID =StudentID;

    }

    public String getStudentName (){

        return StudentName;
    }

    public void setStudentName(String StudentName){

        this.StudentName =StudentName;

    }

    public int getStudentAge (){

        return StudentAge;
    }

    public void setStudentAge(int StudentAge){

        this.StudentAge =StudentAge;

    }


}

public class ConstructorOverloading {

    public static void main(String[]args) {

        StudentData StudentDataObject = new StudentData();

        System.out.println( "Student Name is: " + StudentDataObject.getStudentName() );

        System.out.println( "Student Age is: " + StudentDataObject.getStudentAge() );

        System.out.println( "Student ID is: " + StudentDataObject.getStudentID() );


        StudentData StudentDataObject2 = new StudentData( 101, "Anushka", 25 );

        System.out.println( "Student Name is: " + StudentDataObject2.getStudentName() );

        System.out.println( "Student Age is: " + StudentDataObject2.getStudentAge() );

        System.out.println( "Student ID is: " + StudentDataObject2.getStudentID() );

    }
}
