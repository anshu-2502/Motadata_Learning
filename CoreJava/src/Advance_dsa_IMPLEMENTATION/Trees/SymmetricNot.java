package Advance_dsa_IMPLEMENTATION.Trees;


class SymmetricNode{

    int data;
      SymmetricNode left = null, right =null;

    SymmetricNode(int data){
        this.data = data;

    }
}
public class SymmetricNot {

    public static boolean isSymmetric(SymmetricNode root1, SymmetricNode root2){

        if(root1==null || root2==null){
            return root1==root2;
        }

        return (root1==root2) && isSymmetric(root1.left, root2.right) && isSymmetric(root1.right, root2.left);

    }
    public static boolean Symmeteric(SymmetricNode root){

        if(root==null){

            return true;

        }

        return isSymmetric(root.left , root.right);
    }



    public static void main(String[]args){

        SymmetricNode root = new SymmetricNode(1);
        root.left = new SymmetricNode(2);
        root.right = new SymmetricNode(3);
        root.left.right = new SymmetricNode(4);
        root.right.left = new SymmetricNode(5);

        if (Symmeteric(root)) {
            System.out.print("The binary tree is symmetric");
        }
        else {
            System.out.print("The binary tree is not symmetric");
        }
    }
}
