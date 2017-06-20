package WorkToOffer;

/**
 * Created by zhuhao on 17-6-20.
 */
public class GetNext {
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if (pNode == null)
            return null;

        if (pNode.right != null){
            TreeLinkNode pRight= pNode.right;
            while (pRight.left != null)
                pRight = pRight.left;
            return pRight;
        }
        //节点没有右子树的情况
        // 若父节点不为空，则分两种情况：
        //1 如果节点是它父节点的左子节点，那么返回其父节点
        //2 如果节点是父节点的右子节点，向上一直遍历，
        // 直到找到一个满足1的节点并返回，若直到根节点还未找到，返回null
        while(pNode.next!=null)
        {
            if(pNode.next.left==pNode)return pNode.next;
            pNode=pNode.next;
        }
        return null;
    }
}

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    //next是父节点
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
