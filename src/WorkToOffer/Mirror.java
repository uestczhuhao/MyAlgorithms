package WorkToOffer;

/**
 * Created by zhuhao on 17-5-27.
 * 二叉树的镜像
 * 简化为前序遍历算法的变种
 * 遍历到叶节点为止（不包括），交换左孩子和右孩子
 */
public class Mirror {
    public void Mirror(TreeNode root) {

        if(root == null)
            return;
        if (root.left == null && root.right ==null)
            return;

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        Mirror ( root.left );
        Mirror ( root.right );

    }
}
