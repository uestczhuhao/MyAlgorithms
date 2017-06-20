package WorkToOffer;

import java.util.ArrayList;

/**
 * Created by zhuhao on 17-6-20.
 */
public class Symmetrical {
    private final int EMPTY = Integer.MAX_VALUE;
    ArrayList<Integer> preOrder = new ArrayList<> (  );
    ArrayList<Integer> symPreOrder = new ArrayList<> (  );
    boolean isSymmetrical(TreeNode pRoot)
    {
        if (pRoot == null || (pRoot.right==null && pRoot.left==null))
            return true;

        preOrder(pRoot);
        symPreOrder ( pRoot );
        int i=0;
        for (i=0;i<preOrder.size ();i++){
            if (!preOrder.get ( i ).equals ( symPreOrder.get ( i ) )){
                break;
            }
        }
//        System.out.println (preOrder);
//        System.out.println (symPreOrder);
        if (i == preOrder.size ())
            return true;
        return false;
    }

    public void preOrder(TreeNode root){
        if (root == null){
            preOrder.add ( EMPTY );
            return ;
        }
        preOrder.add ( root.val );
        preOrder(root.left);
        preOrder(root.right);
    }

    public void symPreOrder(TreeNode root){
        if (root == null){
            symPreOrder.add ( EMPTY );
            return ;
        }
        symPreOrder.add ( root.val );
        symPreOrder(root.right);
        symPreOrder(root.left);
    }
}

