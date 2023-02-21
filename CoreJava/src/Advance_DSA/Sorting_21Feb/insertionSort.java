package Advance_DSA.Sorting_21Feb;

public class insertionSort {

    static void insertionSort(int []inputArray){

        int inputArrayLength = inputArray.length;

        for(int outerLoopIteraor=1; outerLoopIteraor<inputArrayLength; outerLoopIteraor++){

            int insertionValue = inputArray[outerLoopIteraor];

            int innerLoopIterator = outerLoopIteraor-1;

            while(innerLoopIterator >=0 && inputArray[innerLoopIterator]>insertionValue){

                inputArray[innerLoopIterator+1] = inputArray[innerLoopIterator];

                innerLoopIterator--;

            }

            inputArray[innerLoopIterator+1] = insertionValue;

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

    public static void main(String[]args){

        int[] inputArray = {2,7,4,1,5,3};

        try {

            printArray(inputArray);

            insertionSort(inputArray);

            System.out.println("sorted array:");

            printArray(inputArray);
        }

        catch (ArrayIndexOutOfBoundsException e){

            System.out.println("Array Index out of bound");

        }




    }
}
