class Bicycle {
    public int gear;
    public int speed;
    public Bicycle(int gear, int speed)
    {
        this.gear = gear;
        this.speed = speed;
    }

    public void applyBrake(int decrement)
    {
        speed -= decrement;
    }

    public void speedUp(int increment)
    {
        speed += increment;
    }

    public String toString()
    {
        return ("No of gears are  " + gear + "  speed of bicycle is  " + speed +" ");
    }
}

// derived class
class MountainBike extends Bicycle {
    public int seatHeight;

    public MountainBike(int gear, int speed,
                        int startHeight) {
        super(gear, speed);
        seatHeight = startHeight;
    }

    public void setHeight(int newValue)
    {
        seatHeight = newValue;
    }

    @Override public String toString()
    {
        return (super.toString() + "seat height is  " + seatHeight);
    }
}
public class InheritanceExample {
    public static void main(String[]args){

        try {
            MountainBike mb = new MountainBike(3, 100, 25);
            System.out.println(mb.toString());
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
