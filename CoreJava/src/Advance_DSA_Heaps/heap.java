package Advance_DSA_Heaps;

public class heap {

    private int[] heap;

    private int size;

    public heap(int capacity){

        heap = new int[capacity];

    }

    public boolean isFull(){

        return size==heap.length;

    }

    public int getParent(int index){

        return (index-1)/2;

    }

    public void insert(int value){

        if(isFull()){
            throw new IndexOutOfBoundsException("Heap is full");

        }

        heap[size] = value;

        insertionHeapify(size);
        size++;


    }

    private void insertionHeapify(int index){

        int newValue = heap[index];

        while(index>0 && newValue>heap[getParent(index)]){

            heap[index] = heap[getParent(index)];

            index = getParent(index);


        }
        heap[index] = newValue;

    }

    public static void main(String[]args){



    }

}
