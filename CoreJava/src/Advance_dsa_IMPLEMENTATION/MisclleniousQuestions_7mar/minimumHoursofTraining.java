package Advance_dsa_IMPLEMENTATION.MisclleniousQuestions_7mar;

public class minimumHoursofTraining {

    public static int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        //Variable to store ans
        int ans=0;

        int energysum=0;
        //Variable to store the total energy require

        for(int num:energy){

            energysum+=num;
        }
        //If initialEnergy is less than totalEnergy require so adding the
        // difference among the two energy + 1 to initalEnergy

        if(initialEnergy<(energysum+1)){

            ans+=energysum-initialEnergy+1;

            initialEnergy=energysum+1;
        }
        int iterator=0;

        //Variable add keeps track of the experience require to be added to initialExperience

        int add=0;
        while(iterator<experience.length){

            //If initialExperience is less then the require experience than
            //  differnce among the two experiences + 1,
            // and storing the max of this  value and value in variable add in add

            if(initialExperience<=experience[iterator]){

                add=Math.max(add,experience[iterator]-initialExperience+1);
            }
            //Decreasing energy

            initialEnergy-=energy[iterator];

            //Adding experience
            initialExperience+=experience[iterator];

            ++iterator;
        }
        //Adding the required experience to be added to ans variable
        ans+=add;

        return ans;
    }

    public static void main(String[]args){

        int initialEnergy = 5;
        int initialExpirence=3;
        int[] energy={1,4,3,2};
        int[]expirence={2,6,3,1};

        System.out.println(minNumberOfHours(initialEnergy, initialExpirence,energy,expirence));

    }

}
