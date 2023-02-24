package Advance_DSA_queues_24feb;

public class circularQueue {

    int size =5;

    int front , rear;

    int items[] = new int[size];

    circularQueue(){

        front =-1;

        rear = -1;
    }

    boolean isFull(){

        if(front==0 && rear ==size-1){
            return true;
        }

        if(front == rear+1){
            return true;
        }
        return false;
    }

    boolean isEmpty(){

        if(front ==-1){

            return true;

        }
        else{

            return false;
        }

    }

    void enqueue(int element){
        if(isFull()){
            System.out.println("queue is full");

        }
        else{
            if(front==-1){
                front=0;
            }

            rear = (rear+1) % size;

            items[rear] = element;
            System.out.println("inserted: " + element);
        }

    }

    int dequeue(){

        int element;
        if(isEmpty()){
            System.out.println("queue is empty");
            return -1;
        }

        else{
            element = items[front];
            if(front ==rear){
                front =-1;
                rear = -1;

            }

            //if queue has only one element so we reset queue after del it

            else{
                front = (front+1) %size;
            }

            return (element);
        }

    }

    void display(){

 int loopIterator;
        if(isEmpty()){
            System.out.println("empty queue");
        }
        else{
            System.out.println("front ->" + front);
            System.out.println("items->");

            for( loopIterator=front ; loopIterator!= rear; loopIterator = (loopIterator+1)% size){
                System.out.println(items[loopIterator] + " ");
            }
            System.out.println(items[loopIterator]);

            System.out.println("Rear ->" + rear);
        }
    }


    public static void main(String[]args){

        circularQueue queue =  new circularQueue();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(4);

        queue.enqueue(5);
        queue.enqueue(3);

        //fails to enqueue as capacity full:

        queue.enqueue(6);

        queue.display();
        int element = queue.dequeue();

        if (element != -1) {
            System.out.println("Deleted Element is " + element);
        }

        queue.display();

        queue.enqueue(7);

        queue.display();





    }
}
