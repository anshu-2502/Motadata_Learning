package Advance_DSA.Sorting_21Feb;

public class mergeSort {

    static void merge(int inputArray[], int left, int mid, int right)
    {

        int subarraySize1 = mid - left + 1;

        int subarraySize2 = right - mid;


        int LeftSubarray[] = new int[subarraySize1];

        int RightSubarray[] = new int[subarraySize2];

       //copying data to temp arrays:

        for (int leftarrayIterator = 0; leftarrayIterator < subarraySize1; leftarrayIterator++) {

            LeftSubarray[leftarrayIterator] = inputArray[left + leftarrayIterator];

        }

        for (int rightarrayIterator = 0; rightarrayIterator < subarraySize2; rightarrayIterator++) {

            RightSubarray[rightarrayIterator] = inputArray[mid + 1 + rightarrayIterator];

        }



        // Initial indexes of first and second subarrays

        int indexsubarray1 = 0, indexsubarray2 = 0;

        // Initial index of merged subarray array

        int indexmergedarray = left;

        while (indexsubarray1 < subarraySize1 && indexsubarray2 < subarraySize2) {

            if (LeftSubarray[indexsubarray1] <= RightSubarray[indexsubarray2]) {

                inputArray[indexmergedarray] = LeftSubarray[indexsubarray1];

                indexsubarray1++;

            }
            else {

                inputArray[indexmergedarray] = RightSubarray[indexsubarray2];

                indexsubarray2++;
            }

            indexmergedarray++;
        }

        // Copy remaining elements of left subarray:


        while (indexsubarray1 < subarraySize1) {

            inputArray[indexmergedarray] = LeftSubarray[indexsubarray1];

            indexsubarray1++;

            indexmergedarray++;

        }

      // copy remaining elements of right subarray:

        while (indexsubarray2 < subarraySize2) {

            inputArray[indexmergedarray] = RightSubarray[indexsubarray2];

            indexsubarray2++;

            indexmergedarray++;

        }
    }

    static void Mergesort(int inputArray[], int left, int right)
    {
        if (left < right) {
            // Find the middle point

            int mid = left + (right - left) / 2;

            // Sorting first and second halves
            sort(inputArray, left, mid);

            sort(inputArray, mid + 1, right);

            // Merge the sorted halves

            merge(inputArray, left, mid, right);
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


            System.out.println("Given Array");

            printArray(inputArray);


            Mergesort(inputArray, 0, inputArray.length - 1);

            System.out.println("Sorted array");

            printArray(inputArray);
        }

        catch (ArrayIndexOutOfBoundsException e){

            System.out.println("Array Index out of bound");

        }


    }
}



