
//pass by value to understand deeply
public class Balloon {
    private String color;
    public Balloon(){

    }
    public  Balloon(String c){
        this.color =c;

    }
    public String getColor(){
        return color;
    }
    public void setColor(String color){
        this.color = color;
    }
    // swap the values
    public static void swap( Object o1, Object o2){
        Object temp = o1;
        o1 =o2;
        o2 =temp;

    }
//change the values
    public static void changevalue(Balloon balloon){ //memory: 100
        balloon.setColor("Red"); // memory: 100
        balloon = new Balloon("Green"); //memory:200
        balloon.setColor("Blue"); //memory:200
    }

    public static void main(String[]args){
        Balloon red = new Balloon("Red");
        Balloon blue = new Balloon("Blue");
        swap(red,blue);
        System.out.println("After the swap method executes:");
        System.out.println("`red` color value = " + red.getColor());
        System.out.println("`blue` color value = " + blue.getColor());

        changevalue(blue);
        System.out.println("After the changeValue method executes:");
        System.out.println("`blue` color value = " + blue.getColor());



    }
}

