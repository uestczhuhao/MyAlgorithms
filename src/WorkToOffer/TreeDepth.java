package WorkToOffer;

/**
 * Created by zhuhao on 17-6-17.
 */
public class TreeDepth {
    public int TreeDepth(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;

        int leftDepth=0,rightDepth=0;
        if (root.left != null)
            leftDepth = TreeDepth ( root.left );
        if (root.right != null)
            rightDepth = TreeDepth ( root.right );

        return (leftDepth>rightDepth)? (leftDepth+1):(rightDepth+1);
    }
}
