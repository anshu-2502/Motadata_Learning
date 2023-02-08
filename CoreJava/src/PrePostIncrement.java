public class PrePostIncrement {

    static void preAndPost() {
        System.out.println("preAndPost ...");

        int x = 5;

        //--x;
        //System.out.println("x: " + x);

        //int y = x--;
        //System.out.println("y: " + y + ", x: " +  x);

        int index = 0;
        int[] array = new int[3];
        array[index++] = 10;
        array[index++] = 20;
        array[index++] = 30;

        System.out.println(index);
    }
    public static void main(String[]args){

        try{
            preAndPost();
        }catch(Exception e){
            System.out.println(e);
        }

    }
}
