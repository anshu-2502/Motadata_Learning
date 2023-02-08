public class LabelledBreak {
    public static void main(String[]args){

        try {
            int num = 0;
            forloop1:
            for (int iteration1 = 0; iteration1 < 10; iteration1++) {
                for (int iteration2 = 0; iteration2 < 10; iteration2++) {
                    if (iteration1 == 5 && iteration2 == 5) {
                        break forloop1;
                    }
                    num++;
                    System.out.println("i: " + iteration1 + ", j: " + iteration2 + ", num: " + num);
                }
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
