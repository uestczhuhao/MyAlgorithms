package LeetCode;

/**
 * Created by zhuhao on 17-5-7.
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes
 * along the shortest path from the root node down to the nearest leaf node.
 */
public class MinimumBiTree {
    public static void main(String[] args) {
        MinimumBiTree tree = new MinimumBiTree();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);

        System.out.println("The minimum depth of "+
                "binary tree is : " + tree.minimumDepth ());
    }


    int minimumDepth()
    {
        return MinimumDepth(root);
    }
    private TreeNode root;


    int MinimumDepth(TreeNode root){
        if (root == null)
            return 0;
        if (root.left == null && root.right ==null)
            return 1;
        if (root.left == null)
            return MinimumDepth(root.right)+1;
        if (root.right == null)
            return MinimumDepth(root.left)+1;

        return Math.min(MinimumDepth ( root.left ),MinimumDepth ( root.right ))+1;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int x) {
        val = x;
        left = right = null;
    }
}
