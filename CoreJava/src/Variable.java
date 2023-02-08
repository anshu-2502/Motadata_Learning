import java.math.BigDecimal;

public class Variable {
    int id =1000;
    byte age =10;
    short rank = 165;
//    int Phone= (int)1234567890;
    long phone=12345_678_90L;
    byte minValue = Byte.MIN_VALUE;
    byte maxValue = Byte.MAX_VALUE;

    char degree = 'B';

    float gpa = 8.5f;

    boolean international = true;
    double tutionfees = 12000.0;
    double international_fee = 5000.0;

    void compute(){
        int nextID = id+1;

        if(international == true){
            tutionfees = international_fee + tutionfees;
        }


        System.out.println("id:"+ id);
        System.out.println("next id:"+ nextID);
        System.out.println("age"+ age);
        System.out.println("phone:"+ phone );
        System.out.println("gpa:" + gpa);
        System.out.println("minvalue of byte: "+ minValue);
        System.out.println("minvalue of byte: "+ maxValue);
        System.out.println("Degeree: "+ degree);
        System.out.println("FEES: "+ tutionfees);

    }
    public static void main(String[]args){
        Variable v = new Variable();
        v.compute();

//        floating point pitfalls:
        System.out.println(0.1+0.2);
        System.out.println(1-0.9);

        //rounding off:
        BigDecimal first_number = new BigDecimal("0.1");
        BigDecimal second_number = new BigDecimal("0.2");

        System.out.println(first_number.add(second_number));


    }
}
