package AdvanceDSA_Lists_22Feb.Stack;

import java.util.NoSuchElementException;

public class stacks_array {
    protected int arr[];
    protected int top, size, len;

    public stacks_array(int n)
    {
        size = n;
        len = 0;
        arr = new int[size];
        top = -1;
    }

    public boolean isEmpty()
    {
        return top == -1;
    }

    public boolean isFull()
    {
        return top == size -1 ;
    }

    public int getSize()
    {
        return len ;
    }

    public int peek()
    {
        if( isEmpty() )
            throw new NoSuchElementException("Underflow Exception");
        return arr[top];
    }

    public void push(int i)
    {
        if(top + 1 >= size)
            throw new IndexOutOfBoundsException("Overflow Exception");
        if(top + 1 < size )
            arr[++top] = i;
        len++ ;
    }
    /*  Function to delete an element from the stack */
    public int pop()
    {
        if( isEmpty() )
            throw new NoSuchElementException("Underflow Exception");
        len-- ;
        return arr[top--];
    }

    public void display()
    {
        System.out.print("Stack = ");
        if (len == 0)
        {
            System.out.print("Empty");
            return ;
        }
        for (int i = top; i >= 0; i--)
            System.out.print(arr[i]+" ");
        System.out.println();
    }



    public static void main(String[]args){





    }

}
