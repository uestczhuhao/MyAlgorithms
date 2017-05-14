package LeetCode;

import java.util.ArrayList;
import java.util.Stack;


/**
 * Created by zhuhao on 17-5-13.
 * 利用循环实现树的前序遍历
 */
public class PreorderTraversal extends ArrayList{
    public static void main(String[] args) {

    }

    public static ArrayList<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        ArrayList<Integer> preorder = new ArrayList<Integer>();

        if (root == null) {
            return preorder;
        }

        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            preorder.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return preorder;
    }
}
