package Advance_DSA.Sorting_21Feb;

public class BubbleSort {

    public static void BubbleSorting(int[]inputArray, int inputArrayLength){

        for(int outerLoopIterator =0; outerLoopIterator < inputArrayLength-1 ; outerLoopIterator++){



            boolean swapped = false;

            for(int innerLoopIterator=0; innerLoopIterator < inputArrayLength - outerLoopIterator -1 ; innerLoopIterator++ ){

                if(inputArray[innerLoopIterator]> inputArray[innerLoopIterator+1]){

                    int temporaryVariable = inputArray[innerLoopIterator];

                    inputArray[innerLoopIterator] = inputArray[innerLoopIterator+1];

                    inputArray[innerLoopIterator+1] = temporaryVariable;


                    swapped = true;
                }

            }

            if(swapped ==false){

                break;

            }

        }

    }




    static void printArray(int array[])
    {
        int arrayLength = array.length;

        for (int arrayIterator = 0; arrayIterator < arrayLength; arrayIterator++) {

            System.out.print(array[arrayIterator] + " ");

        }

        System.out.println();
    }

    public static void main(String []args){

         int[] inputArray = {2,7,4,1,5,3};

         try {

             printArray(inputArray);

             BubbleSorting(inputArray, 6);

             System.out.println("sorted array:");

             printArray(inputArray);
         }

         catch (ArrayIndexOutOfBoundsException e){

             System.out.println("Array Index out of bound");

         }






    }

}
