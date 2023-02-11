import java.io.*;
interface Vehicle{
    void changeGear(int a);
    void speedUp(int a);
    void applyBreaks(int a);
}

class cycle  implements Vehicle {
    int speed;
    int gear;


    public void changeGear(int newGear) {
        gear = newGear;

    }

    @Override
    public void speedUp(int speedIncrement) {
        speed = speed + speedIncrement;

    }

    @Override
    public void applyBreaks(int speedDecrement) {

        speed = speed - speedDecrement;

    }

    public void printStates() {
        System.out.println("speed: " + speed
                + " gear: " + gear);
    }
}

class bike implements Vehicle{
    int speed;
    int gear;

    // to change gear
    @Override
    public void changeGear(int newGear){

        gear = newGear;
    }

    // to increase speed
    @Override
    public void speedUp(int increment){

        speed = speed + increment;
    }

    @Override
    public void applyBreaks(int decrement) {
        speed = speed + decrement;
    }

    // to decrease speed

    public void printStates() {
        System.out.println("speed: " + speed
                + " gear: " + gear);
    }

}

    public class interfacesInJava  {
    public static void main(String[]args){
        cycle cycleobject = new cycle();
        cycleobject.changeGear(2);
        cycleobject.speedUp(3);
        cycleobject.applyBreaks(1);

        System.out.println("Bicycle present state :");
        cycleobject.printStates();

        bike bikeobject = new bike();
        bikeobject.changeGear(1);
        bikeobject.speedUp(3);
        bikeobject.applyBreaks(2);


        System.out.println("Bike present state :");
        bikeobject.printStates();


    }
}
