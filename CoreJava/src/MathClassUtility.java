public class MathClassUtility {

    private static void mathDemo() {

        double randomValue = Math.random();
        int SelectedValue = (int) (randomValue * 100) + 1;

        System.out.println(randomValue);
        System.out.println(SelectedValue);

        // round : rounding floating point to nearest integers
        long RoundingValue1 = Math.round(24.45);
        int RoundingValue2 = Math.round(24.5f);

        System.out.println(RoundingValue1);
        System.out.println(RoundingValue2);

        // ceil : round-up
        double ceilValue1 = Math.ceil(24.45);
        double ceilValue2 = Math.ceil(25.0);

        System.out.println(ceilValue1);
        System.out.println(ceilValue2);

        // floor : round down
        double floorValue1 = Math.floor(24.45);
        double floorValue2 = Math.floor(25.0);

        System.out.println(floorValue1);
        System.out.println(floorValue2);

        double maxValue = Math.max(24.45, 24.5);
        System.out.println(maxValue);

        double absoluteValue = Math.abs(-24.45);
        System.out.println(absoluteValue);

        double powerValue = Math.pow(2.0, 4.0);
        System.out.println(powerValue);

        double notAnumber = 0.0/0.0;
        double sqrt = Math.sqrt(notAnumber);
        System.out.println(notAnumber);

        double logValue = Math.log(100/8);   //inverse documentary frequency
        System.out.println(logValue);
    }
    public static void main(String[]args){
        try{
            MathClassUtility math = new MathClassUtility();
            math.mathDemo();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
