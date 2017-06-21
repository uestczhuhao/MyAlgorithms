package WorkToOffer;

import java.util.ArrayList;

/**
 * Created by zhuhao on 17-6-21.
 */
public class KThNode {
    ArrayList<TreeNode> nodes = new ArrayList<> (  );
    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k<=0) {
            return null;
        }
        getSortedNodes ( pRoot );
        if (k>nodes.size ())
            return null;
        TreeNode kthNode = nodes.get ( k-1 );

        return kthNode;
    }

    public void getSortedNodes(TreeNode root){
         if (root == null)
             return ;
         getSortedNodes ( root.left );
         nodes.add ( root );
         getSortedNodes ( root.right );
    }
}
