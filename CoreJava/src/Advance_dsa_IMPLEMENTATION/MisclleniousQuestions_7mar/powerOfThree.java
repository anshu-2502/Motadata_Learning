package Advance_dsa_IMPLEMENTATION.MisclleniousQuestions_7mar;

public class powerOfThree {

    public boolean powerofThree(int number){

        if(number<1){
            return false;
        }

        while(number%3 ==0 ){

            number = number/3;

        }

        return number==1;

    }


    public static void main(String[]args){

        try {

            int number = 81;

            powerOfThree powerOfThree = new powerOfThree();

            System.out.println(powerOfThree.powerofThree(number));

        }

        catch(Exception e){
            System.out.println(e.getStackTrace());
        }


    }
}
