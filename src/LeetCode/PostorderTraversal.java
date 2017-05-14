package LeetCode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by zhuhao on 17-5-13.
 * 用循环的方法实现二叉树的后续遍历算法
 */
public class PostorderTraversal extends ArrayList{

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode ( 1 );
        TreeNode node2 = new TreeNode ( 2 );
        TreeNode node3 = new TreeNode ( 3 );
        TreeNode node4 = new TreeNode ( 4 );
        TreeNode node5 = new TreeNode ( 5 );
        TreeNode node6 = new TreeNode ( 6 );
        TreeNode node7 = new TreeNode ( 7 );
        TreeNode node8 = new TreeNode ( 8 );
        TreeNode node9 = new TreeNode ( 9 );
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node4.right = node7;
        node7.left = node8;
        node7.right = node9;

        System.out.println (postorderTraversal ( node1 ));
    }

    public static ArrayList<Integer> postorderTraversal(TreeNode root) {

        ArrayList<Integer> postOrder = new ArrayList<Integer>(  );
        if(root == null) {
            return postOrder;
        }

        TreeNode prev = null;
        TreeNode curr = root;
        //辅助栈，等到栈顶元素的左右子树全部处理完成后，栈顶元素出栈
        Stack<TreeNode> stack = new Stack<TreeNode> ();
        stack.push ( root );
        while (!stack.isEmpty ()){
            curr = stack.peek ();

            if (prev != null){
                System.out.println ("The prev now is "+prev.val);

            }else System.out.println ("The prev now is null!");

            System.out.println ("The curr now is "+curr.val);
            if(prev == null || prev.left == curr || prev.right == curr){
                System.out.println ("The Tree is traversed ");
                if (curr.left != null){
                    stack.push ( curr.left );
                    System.out.println (curr.left.val);
                } else if (curr.right != null){
                    stack.push ( curr.right );
                    System.out.println (curr.right.val);
                }
            } else if (curr.left == prev) {
                System.out.println ("Current left child equal previous ");
                if(curr.right != null){
                    stack.push ( curr.right );
                    System.out.println (curr.right.val);
                }
            } else{
                ////else的情况有curr.right == prev和curr == prev
                ////二者情况不同，但处理方法相同，都是弹出栈顶元素并将其输出
                System.out.println ("Other situations ");
                postOrder.add(curr.val);
                stack.pop ();
                System.out.println ("The Output is "+postOrder);
            }
            prev = curr;
        }

        return postOrder;
    }

    public ArrayList<Integer> postorderInternet(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode prev = null;
        TreeNode curr = root;

        if (root == null) {
            return result;
        }

        stack.push(root);
        while (!stack.empty()) {
            curr = stack.peek();
            if (prev == null || prev.left == curr || prev.right == curr) { // traverse down the tree
                if (curr.left != null) {
                    stack.push(curr.left);
                } else if (curr.right != null) {
                    stack.push(curr.right);
                }
            } else if (curr.left == prev) {
                if (curr.right != null) {
                    stack.push(curr.right);
                }
            } else {
                result.add(curr.val);
                stack.pop();
            }
            prev = curr;
        }

        return result;
    }
}

