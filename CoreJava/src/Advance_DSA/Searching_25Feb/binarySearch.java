package Advance_DSA.Searching_25Feb;


public class binarySearch {

    int binarySearch(int array[], int left, int right, int value)
    {
        if (right >= left) {
            int mid = left + (right - left) / 2;


            if (array[mid] == value) {

                return mid;

            }


            if (array[mid] > value) {

                return binarySearch(array, left, mid - 1, value);

            }


            return binarySearch(array, mid + 1, right, value);
        }


        return -1;
    }


    public static void main(String args[])
    {
        binarySearch ob = new binarySearch();
        int array[] = { 2, 3, 4, 10, 40 };
        int length = array.length;
        int value = 10;
        int result = ob.binarySearch(array, 0, length - 1, value);
        if (result == -1) {

            System.out.println("Element not present");
        }
        else {

            System.out.println("Element found at index " + result);

        }
    }
}
