package Multithreading.March14.Synchronized;

class TicketCounter {
    int availableSeats = 2;
    void bookTicket(String name, int numberOfSeats) {

        if((availableSeats >= numberOfSeats) && (numberOfSeats > 0)) {

            System.out.println(name+" : "+ numberOfSeats + " Seats Booked!");

            availableSeats = availableSeats-numberOfSeats;

        } else {

            System.out.println(name +" : Seats Not Available");

        }
    }
}
class TicketBookingThread extends Thread {
    TicketCounter ticketCounter;
    String name;
    int seats;
    TicketBookingThread(TicketCounter ticketCounter, String name, int seats) {

        this.ticketCounter = ticketCounter;

        this.name = name;

        this.seats = seats;
    }
    public void run() {

        synchronized(ticketCounter) { //object locking , this keyword will not lock the booking ticket counter, bcoz it will block the
            //block .

            ticketCounter.bookTicket(name, seats);
        }
    }
}
public class SynchronizedBlock {
    public static void main(String[] args) {
        TicketCounter ticketCounter = new TicketCounter();

        TicketBookingThread thread1 = new TicketBookingThread(ticketCounter, "Anshu", 2);

        TicketBookingThread thread2 = new TicketBookingThread(ticketCounter, "Anushka", 1);

        thread1.start();

        thread2.start();
    }
}