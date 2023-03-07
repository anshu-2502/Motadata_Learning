package Advance_dsa_IMPLEMENTATION.MisclleniousQuestions_7mar;

public class CycleinLInklist {

    static Node head;

    static class Node {
        int data;
        Node next;

        Node(int d)
        {
            data = d;
            next = null;
        }
    }

    static public void push(int new_data)
    {


        Node new_node = new Node(new_data);

        new_node.next = head;


        head = new_node;
    }

    static boolean detectLoop(Node h)
    {

        if (head == null)
            return false;
        else {


            while (head != null) {

                if (head.data == -1) {
                    return true;
                }


                else {
                    head.data = -1;
                    head = head.next;
                }
            }
            return false;
        }
    }


    public static void main(String[] args)
    {

        try {
            CycleinLInklist llist = new CycleinLInklist();

            llist.push(1);
            llist.push(2);
            llist.push(3);
            llist.push(4);
            llist.push(5);


            llist.head.next.next.next.next.next
                    = llist.head.next.next;

            if (detectLoop(llist.head)) {
                System.out.println("Loop Found");

            } else {
                System.out.println("Not Found");
            }

        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}

