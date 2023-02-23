package AdvanceDSA_Lists_22Feb.collectionsLists;

public class costumArrayList {

    //stores object in array:
    private Object[] arrayList;

    //current amount of elements in array:
    private int elementsInArray;

    //if default constructor is called then size will be 10:

    public costumArrayList(){

        this(10);

    }

    public costumArrayList(int capacity) {
        if (capacity <= 0) {

            System.out.println("The size must be greater than 0. Try again.");

            return;
        }

        // initialize capacity to be n of array
        // and elements in array to be 0.

        this.arrayList = new Object[capacity];

        this.elementsInArray = 0;
    }

    // place an object at end of arraylist:

    public void add(Object element){

        // if array is full then double the size of array
        //by making copy

        if(checkIfArrayFull()){

            copyArray(0,"double");

        }
        this.arrayList[this.elementsInArray] = element;

        this.elementsInArray++;

    }

    //placing an element at given index's position:

    public void add(int index, Object element) {
        if (checkIfArrayFull()) {

            copyArray(0, "double");

        }

        if(index>=this.arrayList.length){

            System.out.println("index out of bound");

            System.exit(-1);
        }

        //temp object will store the arraylist object passed at given index.

        Object temporaryVariable = this.arrayList[index];

        arrayList[index] = element;

        //temp2 will be assigned index+1 element .

        Object temporaryLoopVariable ;

        for(int loopIterator= index; loopIterator<this.arrayList.length-1;loopIterator++){

            temporaryLoopVariable = arrayList[loopIterator+1];

            arrayList[loopIterator+1] = temporaryVariable;

            temporaryVariable = temporaryLoopVariable;
        }

        // this copy array will compact the array, if capacity was 20 and array has 10 elements,
        //user wants to add at 15 position, will move it from 15 to 10.

        copyArray(0, "");

        this.elementsInArray++;

    }

    //get the element at given index:

    public Object get(int index){

        Object element = null;

        try{

            element = this.arrayList[index];

        }
        catch(ArrayIndexOutOfBoundsException e){

            System.out.println("index out of bound");

        }

        return element;


    }
    //size of arraylist:

    public int size(){

        return this.elementsInArray;

    }

    public boolean isEmpty(){

        return  this.elementsInArray ==0;

    }

    //check if element is present, returns index of first occurence:

    public int find(Object element){

        for(int findIterator=0 ; findIterator<this.arrayList.length; findIterator++){

            if(element.equals(this.arrayList[findIterator])){

                return  findIterator;
            }

        }

        return  -1;
    }

    //check if element is in the list:

    public boolean isInList(Object element){

        return find(element) >=0;

    }

    //removes the first occurence of element:

    public void remove(Object element){

        for(int listIterator=0; listIterator<this.elementsInArray; listIterator++){

            if(element.equals(this.arrayList[listIterator])){

                this.arrayList[listIterator] = null;

                this.elementsInArray--;

                //again compacting the array:

                copyArray(0, "");

                return;

            }

        }

    }

    public boolean checkIfArrayFull(){

        return this.arrayList.length == this.elementsInArray;

    }




    public void copyArray(int size, String action){

        size = increaseArraySize(size,action);

        Object[] temporaryArray = new Object[size];

        int temporaryElement = 0;

        for(int copyArrayItrator=0; copyArrayItrator<this.arrayList.length; copyArrayItrator++ , temporaryElement++){

            if(this.arrayList[copyArrayItrator]==null){

                temporaryElement--;
                continue;
            }

            temporaryArray[temporaryElement] = this.arrayList[copyArrayItrator];

        }

//        this.arrayList = null;

//        this.arrayList = new Object[temporaryArray.length];

        this.arrayList = temporaryArray;



    }

    private int increaseArraySize(int size, String action){

        if(action.equals("double")){
            size = this.arrayList.length * 2;

        }
        else{
            size = this.arrayList.length + size;

        }

        return size;

    }

    public static void main(String[] args) {

        try {

            System.out.println("Create Constructor setting ArrayList to capacity 50");
            costumArrayList numeric = new costumArrayList(50);

            System.out.println("The ArrayList is empty: " + numeric.isEmpty());
            System.out.println("The numer of elements in array is: " + numeric.size());

            System.out.println("Populate the ArrayList with values from 1 to 20");
            for (int i = 0; i < 50; i++) {
                numeric.add((int) (Math.random() * 20) + 1);
            }

            System.out.println("The ArrayList is empty: " + numeric.isEmpty());
            System.out.println("The number of elements in array is: " + numeric.size());

            System.out.println("Add an element to the end of the ArrayList: i.e. 12345");
            numeric.add(12345);
            System.out.println("The index of 12345 is " + numeric.find(12345));

            System.out.println("The number of elements in array is: " + numeric.size());
            System.out.println("The value of element 50 is: " + numeric.get(50));

            System.out.println("Element at index 5 before removal: " + numeric.get(5));
            System.out.println("The number of elements in array is: " + numeric.size());
            System.out.println("Remove element at index 5");
            numeric.remove(numeric.get(5));
            System.out.println("Element at index 5 after removal: " + numeric.get(5));
            System.out.println("The number of elements in array is: " + numeric.size());

            System.out.println("Add an element at specific position");
            System.out.println("Element at index 10 before insertion: " + numeric.get(10));
            numeric.add(10, 200);
            System.out.println("Element at index 10 after insertion: " + numeric.get(10));
            System.out.println("Element at index 11 after insertion: " + numeric.get(11));

            System.out.println("Check to see if particular element is in array?");
            System.out.println("Is 12345 in array? " + numeric.isInList(12345));
            System.out.println("Is 123456 in array? " + numeric.isInList(123456));

            for (int i = 0; i < numeric.size(); i++) {
                System.out.println("ArrayList[" + i + "]: " + numeric.get(i));
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("************************************************");

        System.out.println("Tests the default constructor");

        try {
            costumArrayList test = new costumArrayList();
            System.out.println("Current size: " + test.size());
            System.out.println("Is the Array List empty? : " + test.isEmpty());
            test.add("a");
            test.add("b");
            test.add("aa");
            test.add("bh");
            test.add("G");
            test.add("d");
            test.add("a");
            test.add("e");
            test.add("bd");
            test.add("c");
            test.add(2, "ANSHU");
            test.add(2, "ANUSHKA");
            test.add(10, "SHARMA");
            test.add(19, "HI");
            test.remove("HELLO");
            test.remove("x");
            System.out.println("Current size: " + test.size());
            System.out.println("Is the Array List empty? : " + test.isEmpty());
            System.out.println("Object at index 1: " + test.get(1));
            System.out.println("Object at index 3: " + test.get(3));
            System.out.println("Position of G: " + test.find("G"));
            System.out.println("Position of na: " + test.find("na"));
            System.out.println("Is bd in array list? : " + test.isInList("bd"));
            System.out.println("Is bda in array list? : " + test.isInList("bda"));

            for (int i = 0; i < test.size(); i++) {
                System.out.println("ArrayList[" + i + "] : " + test.get(i));
            }

            System.out.println("Out of bounds test: " + test.get(22));
        }
        catch (Exception e){
            System.out.println(e);
        }
        }
}



