public class StringOperations {

    static void stringInBuiltMethods() {


        String s = "hello world!";
        System.out.println("s: " + s);

        if (! s.isEmpty()) {

            System.out.println("length of string: " + s.length());
            System.out.println("checking whether string is empty: " + s.isEmpty());

            // Comparison
            System.out.println("equals method: " + s.equals("HELLO WORLD!"));

            //once we ignore the case the both the values are same irrespective of capital letters or small letters
            System.out.println("ignorecase method : " + s.equalsIgnoreCase("HELLO WORLD!"));

            //compares the two string lexographically , comapre on base of unicode value
            System.out.println("comparision: " + s.compareTo("HELLO WORLD!"));

            // Searching

            System.out.println("string contains method: " + s.contains("HELLO WORLD!"));
            System.out.println("contains method on world " + s.contains("world!"));

            //checking starting of the method:
            System.out.println("checking start: " + s.startsWith("HELLO WORLD!"));
            System.out.println("starts with " + s.startsWith("hello world!"));

            //ends with methods
            System.out.println("ending with: " + s.endsWith("!"));
            System.out.println("index of character: " + s.indexOf("lo"));
            System.out.println("index of single char " + s.indexOf('o'));
            System.out.println("last index of method " + s.lastIndexOf('o'));  //can appera on many places

            // Examining individual characters
            System.out.println("char at position: " + s.charAt(4));

            // Extracting substrings
            System.out.println("print substring starting from a particular index: " + s.substring(4));
            System.out.println("print substring starting from and till given index " + s.substring(4, 9));

            // Case conversions (String is immutable. So, only a copy is returned)
            System.out.println("s.toUpperCase(): " + s.toUpperCase());
            System.out.println("s.toLowerCase(): " + s.toLowerCase());

            System.out.println("s.trim(): " + s.trim()); // returns a copy of string after trimming any leading & trailing white spaces


            // Replace (replace comma's with white-space)
            System.out.println("replace comma with white space:  " + s.replaceAll("o", "r"));

            // Split (split a line of text by tab or comma or white space)
            System.out.println("splitting the string with a desired char: ");
            String[] sa = s.split("o");
            for (String temp : sa) {
                System.out.println(temp);
            }

            // Static method (includes overloaded methods)
            System.out.println("string representation of double value:" + String.valueOf(1.3));

        }
    }

    public static void main(String[]args){

        try{

        stringInBuiltMethods();

            }
        catch (Exception e){
            System.out.println(e);
        }

    }
}
