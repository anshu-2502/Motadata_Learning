package AdvanceDSA_Lists_22Feb.collectionsLists.linkedLists;

import java.util.Scanner;

public class singleLinkedList {

    protected Node start;
    protected Node end;
    public int size;


    public singleLinkedList() {
        start = null;
        end = null;
        size = 0;
    }

    public boolean isEmpty() {
        return start == null;
    }

    public int getSize() {
        return size;
    }

    public void insertAtStart(int Value) {

        Node nodePointer = new Node(Value, null);

        size++;

        if (start == null) {
            start = nodePointer;
            end = start;

        } else {

            nodePointer.setLink(start);
            start = nodePointer;

        }
    }

    public void insertAtEnd(int Value) {

        Node nodePointer = new Node(Value, null);
        size++;
        if (start == null) {

            start = nodePointer;
            end = start;

        } else {

            end.setLink(nodePointer);

            end = nodePointer;

        }

    }

    public void insertAtPosition(int Value, int position) {

        Node nodePointer = new Node(Value, null);

        Node startPointer = start;

        position = position - 1;

        for (int positionIterator = 1; positionIterator < size; positionIterator++) {

            if (positionIterator == position) {

                Node temporaryVariable = startPointer.getLink();

                startPointer.setLink(nodePointer);

                nodePointer.setLink(temporaryVariable);

                break;

            }

            startPointer = startPointer.getLink();

        }

        size++;

    }

    public void deleteAtPos(int position) {

        if (position == 1) {

            start = start.getLink();

            size--;

            return;

        }

        if (position == size) {

            Node startPointer = start;

            Node tailPointer = start;

            while (startPointer != end) {

                tailPointer = startPointer;

                startPointer = startPointer.getLink();

            }

            end = tailPointer;

            end.setLink(null);

            size--;

            return;

        }

        Node nodePointer = start;

        position = position - 1;

        for (int loopIterator = 1; loopIterator < size; loopIterator++) {

            if (loopIterator == position) {

                Node temporaryNode = nodePointer.getLink();

                temporaryNode = temporaryNode.getLink();

                nodePointer.setLink(temporaryNode);

                break;

            }

            nodePointer = nodePointer.getLink();

        }

        size--;

    }

    public void display() {

        if (size == 0) {

            System.out.println("single linked list");

        }

        if (start.getLink() == null) {

            System.out.println(start.getData());

            return;

        }

        Node nodePointer = start;

        System.out.println(start.getData() + "->");

        nodePointer = start.getLink();

        while (nodePointer.getLink() != null) {

            System.out.println(nodePointer.getData() + "->");

            nodePointer = nodePointer.getLink();

        }

        System.out.println(nodePointer.getData());

    }


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        singleLinkedList list = new singleLinkedList();

        char ch;

        do
        {
            System.out.println("Singly Linked List Operations");
            System.out.println("1. insert at begining");
            System.out.println("2. insert at end");
            System.out.println("3. insert at position");
            System.out.println("4. delete at position");
            System.out.println("5. check empty");
            System.out.println("6. get size");

            int choice = input.nextInt();

            switch (choice)
            {
                case 1 :
                    System.out.println("Enter integer element to insert");

                    list.insertAtStart( input.nextInt() );

                    break;
                case 2 :
                    System.out.println("Enter integer element to insert");

                    list.insertAtEnd( input.nextInt() );

                    break;
                case 3 :
                    System.out.println("Enter integer element to insert");

                    int num = input.nextInt() ;

                    System.out.println("Enter position");

                    int pos = input.nextInt() ;

                    if (pos <= 1 || pos > list.getSize() ) {

                        System.out.println("Invalid position");

                    }
                    else {

                        list.insertAtPosition(num, pos);
                    }
                    break;
                case 4 :
                    System.out.println("Enter position");
                    int p = input.nextInt() ;
                    if (p < 1 || p > list.getSize() ) {

                        System.out.println("Invalid position");
                    }
                    else {
                        list.deleteAtPos(p);
                    }
                    break;
                case 5 :
                    System.out.println("Empty status = "+ list.isEmpty());
                    break;
                case 6 :
                    System.out.println("Size = "+ list.getSize());
                    break;
                default :
                    System.out.println("Wrong Entry");
                    break;
            }

            list.display();
            System.out.println("Do you want to continue (Type y or n) ");
            ch = input.next().charAt(0);
        }

        while (ch == 'Y'|| ch == 'y');


    }
}
