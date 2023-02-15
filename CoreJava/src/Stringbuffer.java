public class Stringbuffer {
    public static void main(String[]args){

        StringBuffer stringbufferobject = new StringBuffer("Anshu");
        System.out.println("string initially: "+ stringbufferobject);

        stringbufferobject.append(" Sharma");
        System.out.println("string append: "+ stringbufferobject);

        stringbufferobject.insert(5," Ramesh");
        System.out.println("string insert: "+ stringbufferobject);

        stringbufferobject.reverse();
        System.out.println("string reverse: "+ stringbufferobject);

        System.out.println("string capacity: "+ stringbufferobject.capacity());
        stringbufferobject.ensureCapacity(22);
        System.out.println("string capacity: "+ stringbufferobject.capacity());









    }
}
