package Advance_dsa_IMPLEMENTATION;


import java.util.ArrayList;
import java.util.Stack;

public class postOrderStack {
    TreeNode root;
    ArrayList<Integer> list = new ArrayList<Integer>();

    ArrayList<Integer> postOrder(TreeNode node){

        Stack<TreeNode> stackPostorder = new Stack<TreeNode>();

        if(node == null){
            return list;
        }

        stackPostorder.push(node);
        TreeNode previous = null;

        while(!stackPostorder.isEmpty()){

            TreeNode current = stackPostorder.peek();





        }




    }



}
