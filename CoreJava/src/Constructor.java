public class Constructor {
        String name;
        int id;
        Constructor(String name, int id)
        {
            this.name = name;
            this.id = id;
        }

        Constructor(){
                    System.out.println("np parameter");
    }

        public static void main(String[] args)
        {
            Constructor c1 = new Constructor();
//            parameterized constructor
            Constructor c = new Constructor("anshu", 68);
            System.out.println("Name :" + c.name + " and Id :" + c.id);
        }
    }


