package Advance_dsa_IMPLEMENTATION.MisclleniousQuestions_7mar;

public class designHashmap {

    Integer[][] map;

    int numOfBuckets =1500;

    int bucketSize =1500;

    public designHashmap(){
        map = new Integer[numOfBuckets][bucketSize];
    }

    private Integer[] getBucket(int key){
        int bucketIndex = key/bucketSize;

        return map[bucketIndex];
    }

    private Integer getKeyHash(int key){

        return key%bucketSize;
    }

    public void put(int key , int value){

        Integer[] bucket = getBucket(key);
        int keyHash = getKeyHash(key);
        bucket[keyHash] = value;
    }

    public int get(int key) {

        Integer[] bucket = getBucket(key);

        int keyHash = getKeyHash(key);

        if (bucket[keyHash] == null) {

            return -1;
        } else {

            return bucket[keyHash];
        }
    }

    public void remove(int key) {

        Integer[] bucket = getBucket(key);

        int keyHash = getKeyHash(key);

        bucket[keyHash] = null;

    }

        public static void main(String[]args){


        designHashmap designHashmap = new designHashmap();

        try {

            designHashmap.put(1, 1);
            designHashmap.put(4, 5);
            designHashmap.put(8, 0);

            designHashmap.remove(1);

            int getValue = designHashmap.get(4);


            System.out.println(getValue);
        }

        catch (Exception e){
            System.out.println(e);
        }



    }



    }
