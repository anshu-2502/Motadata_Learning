package Advance_DSA.Sorting_21Feb;

public class selectionSort {

    static void selectionSort(int inputArray[])
    {
        int ArrayLength = inputArray.length;

        for (int outerIteration = 0; outerIteration < ArrayLength-1; outerIteration++)
        {
            int minValue_index = outerIteration;

            for (int innerIteration = outerIteration+1; innerIteration < ArrayLength; innerIteration++) {

                if (inputArray[innerIteration] < inputArray[minValue_index]) {

                    minValue_index = innerIteration;

                }
            }

            int temporaryValue = inputArray[minValue_index];

            inputArray[minValue_index] = inputArray[outerIteration];

            inputArray[outerIteration] = temporaryValue;
        }
    }
    static void printArray(int inputArray[])
    {
        int ArrayLength = inputArray.length;

        for (int iteration=0; iteration<ArrayLength; ++iteration) {

            System.out.print(inputArray[iteration] + " ");

        }

        System.out.println();
    }

    public static void main(String[]args){

        int[] inputArray = {2,7,4,1,5,3};

        try {

            printArray(inputArray);

            selectionSort(inputArray);

            System.out.println("sorted array:");

            printArray(inputArray);
        }

        catch (ArrayIndexOutOfBoundsException e){

            System.out.println("Array Index out of bound");

        }


    }
}
