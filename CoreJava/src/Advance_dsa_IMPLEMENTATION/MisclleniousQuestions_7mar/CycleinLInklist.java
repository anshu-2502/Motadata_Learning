package Advance_dsa_IMPLEMENTATION.MisclleniousQuestions_7mar;

public class CycleinLInklist {

      Node head;

   static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

     public void push(int new_data) {


        Node new_node = new Node(new_data);

        new_node.next = head;


        head = new_node;
    }

     boolean detectLoop(Node head) {
        Node slowPointer = head, fastPointer = head;

        while (slowPointer != null && fastPointer != null && fastPointer.next != null) {

            slowPointer = slowPointer.next;

            fastPointer = fastPointer.next.next;

            if (slowPointer == fastPointer) {

                return true;
            }
        }

        return false;
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

            if (llist.detectLoop(llist.head)) {
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

