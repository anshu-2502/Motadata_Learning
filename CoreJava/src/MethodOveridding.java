class Bank{
    int getRateOfInterest(){
        return 0;
    }
}

class AXISBank extends Bank{
    @Override
    int getRateOfInterest() {
        return 7;
    }
}
class SBI extends Bank{
    @Override
    int getRateOfInterest() {
        return 6;
    }
}

class ICICI extends Bank{
    @Override
    int getRateOfInterest() {
        return 9;
    }
}
public class MethodOveridding {

    public static void main(String[]args){
        SBI sbiclassobject=new SBI();
        ICICI iciciclassobject=new ICICI();
        AXISBank axisclassobject=new AXISBank();
        System.out.println("SBI Rate of Interest: "+sbiclassobject.getRateOfInterest());
        System.out.println("ICICI Rate of Interest: "+iciciclassobject.getRateOfInterest());
        System.out.println("AXIS Rate of Interest: "+axisclassobject.getRateOfInterest());

    }
}
