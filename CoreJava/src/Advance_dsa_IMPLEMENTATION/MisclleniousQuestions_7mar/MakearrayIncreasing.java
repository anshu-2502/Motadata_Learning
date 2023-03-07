package Advance_dsa_IMPLEMENTATION.MisclleniousQuestions_7mar;

public class MakearrayIncreasing {
    public boolean canBeIncreasing(int[] nums) {

        boolean removed = false;

        for (int iterator = 1; iterator < nums.length; ++iterator){

            if (nums[iterator - 1] >= nums[iterator]) {

                if (removed){
                    return false;
                }

                removed = true;

                if (iterator > 1 && nums[iterator - 2] >= nums[iterator]){

                    nums[iterator] = nums[iterator - 1];
                }
            }
        }

        return true;
    }

    public static void main(String[]args){



        int[] inputArray = {1,2,10,8,9};

        try {

            MakearrayIncreasing makearrayIncreasing = new MakearrayIncreasing();

            System.out.println(makearrayIncreasing.canBeIncreasing(inputArray));

        }
        catch(Exception e){
            System.out.println(e);
        }

    }

}
