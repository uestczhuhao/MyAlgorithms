package WorkToOffer;

/**
 * Created by zhuhao on 17-5-27.
 * 判断树B是否是A的子树
 */
public class IsSubtree {
    public boolean isSubTree(TreeNode root1,TreeNode root2){
        if (root2 == null)
            return true;
        if (root1 == null)
            return false;

        boolean result = HasSubtree(root1,root2);
        return result;
    }

    public boolean HasSubtree(TreeNode root1,TreeNode root2){
        boolean result =false;

        if(root1 !=null && root2!=null){
            if (root1.val == root2.val)
                result = DoesTree1HasTree2 ( root1,root2 );
            if(!result)
                result = HasSubtree ( root1.left,root2 );
            if(!result)
                result = HasSubtree ( root1.right,root2 );
        }
        return result;

    }

    public boolean DoesTree1HasTree2(TreeNode proot1,TreeNode proot2){
        if (proot1!=null && proot2!=null){

            System.out.println ("Tree 1 is "+proot1.val);
            System.out.println ("Tree 2 is "+proot2.val);
        } else {
            System.out.println ("Tree 1 is "+proot1);
            System.out.println ("Tree 2 is "+proot2);
        }
        if (proot2 == null)
            return true;
        if (proot1 == null)
            return false;
        if (proot1.val != proot2.val)
            return false;

        boolean result = DoesTree1HasTree2 ( proot1.left,proot2.left ) &&
                DoesTree1HasTree2 ( proot1.right,proot2.right );
        return result;
    }
}
