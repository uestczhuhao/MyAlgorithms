package WorkToOffer;

/**
 * Created by zhuhao on 17-6-1.
 */
public class TreeConvertToLink {
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null)
            return pRootOfTree;

        TreeNode[] pLastList = new TreeNode[1];
        convertNode(pRootOfTree,pLastList);

        TreeNode pFirstList = pLastList[0];
        while (pFirstList!=null && pFirstList.left != null)
            pFirstList = pFirstList.left;

        return pFirstList;
    }

    /**
     * 其中pRoot为此时结点，pLastList为上次循环结束时链表的最后一个结点
     * 位于pRoot之前
     *
     * 之所以pLastList用数组，是因为其在递归调用时的原理所决定
     * 如果不是数组，相当于直接调用引用，返回时值为空
     */
    public void convertNode(TreeNode pRoot,TreeNode[] pLastList){
        if (pRoot == null)
            return;

        if (pRoot.left != null)
            convertNode ( pRoot.left,pLastList );

        pRoot.left = pLastList[0];
        if (pLastList[0] !=null) {
            pLastList[0].right = pRoot;
        }
        pLastList[0] = pRoot;


//        System.out.println (pRoot.val);
//        if (pLastList[0]!=null){
//            if (pLastList[0].left != null)
//                System.out.println ("Left is "+pLastList[0].left.val);
//            else
//                System.out.println ("Left is null");
//            System.out.println ("The list's last "+pLastList[0].val);
//            if (pLastList[0].right != null)
//                System.out.println ("Right is "+pLastList[0].right.val);
//            else
//                System.out.println ("Right is null");
//        }
//        else System.out.println ("The list's last is null");

        if (pRoot.right!=null)
            convertNode ( pRoot.right,pLastList );

    }
}
