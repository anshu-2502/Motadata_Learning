package Advance_dsa_IMPLEMENTATION.MisclleniousQuestions_7mar;

public class powerN {

    static float power(float number, int power)
    {
        float temporaryVariable;
        if (power == 0) {
            return 1;
        }
        temporaryVariable = power(number, power / 2);

        if (power % 2 == 0) {
            return temporaryVariable * temporaryVariable;
        }
        else {
            if (power > 0) {
                return number * temporaryVariable * temporaryVariable;
            }
            else {
                return (temporaryVariable * temporaryVariable) / number;
            }
        }
    }

    public static void main(String[]args){

        try {

            float number = 9;

            int power = -2;

            System.out.println(power(number, power));
        }

        catch(Exception e){
            System.out.println(e);
        }
    }
}
