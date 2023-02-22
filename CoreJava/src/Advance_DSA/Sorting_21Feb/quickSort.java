package Advance_DSA.Sorting_21Feb;

public class quickSort {

    static void swap(int[] inputArr, int element1, int element2)
    {
        int temporaryVariable = inputArr[element1];
        inputArr[element1] = inputArr[element2];
        inputArr[element2] = temporaryVariable;
    }


//last element as pivot:

    static int partition(int[] inputArr, int low, int high)
    {

        int pivot = inputArr[high];

        int smallerElementIndex = (low - 1);

        for (int currentELementIndex = low; currentELementIndex <= high - 1; currentELementIndex++) {


            if (inputArr[currentELementIndex] < pivot) {

                smallerElementIndex++;

                swap(inputArr, smallerElementIndex, currentELementIndex);
            }
        }
        swap(inputArr, smallerElementIndex + 1, high);
        return (smallerElementIndex + 1);
    }


    static void quickSort(int[] inputArr, int low, int high)
    {
        if (low < high) {


            int partitionINdex = partition(inputArr, low, high);

            //before partition sorting:

            quickSort(inputArr, low, partitionINdex - 1);

            //after partition sorting:

            quickSort(inputArr, partitionINdex + 1, high);
        }
    }

    static void printArray(int[] arr, int size)
    {
        for (int i = 0; i < size; i++)
            System.out.print(arr[i] + " ");

        System.out.println();
    }

    public static void main(String[]args){

        int[] inputArray = { 10, 7, 8, 9, 1, 5 };
        int arrayLength = inputArray.length;

        try {

            quickSort(inputArray, 0, arrayLength - 1);
            System.out.println("Sorted array: ");
            printArray(inputArray, arrayLength);

        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("array index out of bound");
        }

    }
}
