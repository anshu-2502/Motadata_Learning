package Advance_dsa_IMPLEMENTATION.Trees;
public class maxDepth {

    public static int maxDepth(SymmetricNode root){
        if(root ==null){
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return  Math.max(left, right)+1;

    }

    public static void main(String[]args){

        SymmetricNode root = new SymmetricNode(1);
        root.left = new SymmetricNode(2);
        root.right = new SymmetricNode(3);
        root.left.right = new SymmetricNode(4);
        root.right.left = new SymmetricNode(5);


        System.out.println(maxDepth(root));

    }
}
