package WorkToOffer;

import java.util.Arrays;

/**
 * Created by zhuhao on 17-5-24.
 */
public class ReConstructBinaryTree {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre.length == 0 || in.length == 0 || pre.length!=in.length)
            return null;
        TreeNode root = new TreeNode ( pre[0] );
        TreeNode newRoot = reConstructer(pre,in,0,pre.length-1,0,in.length-1);
        return newRoot;
    }

    public TreeNode reConstructer(int[] pre,int[] in,int preStart,int preEnd,int inStart,int inEnd){
//        int preStartPointer,preEndPointer;
//        int inStartPointer ,inEndPointer;
        TreeNode root = new TreeNode ( pre[preStart] );

        if(preStart == preEnd){
            if(inStart == inEnd && pre[preStart] == in[inStart])
                return root;
            else
                throw new Error ( "Invalid input." );
        }
        int rootPointer=inStart;
        while (rootPointer <= inEnd && in[rootPointer] != root.val)
            ++rootPointer;

        if(rootPointer == inEnd && in[rootPointer] != root.val)
            throw new Error ( "Invalid input." );
        int leftLength = rootPointer - inStart;
        int leftPreEnd = preStart + leftLength;
        if(leftLength >0)
            root.left = reConstructer ( pre,in,preStart+1,leftPreEnd ,inStart,rootPointer-1 );
        if(leftLength < preEnd-preStart)
            root.right = reConstructer ( pre,in,leftPreEnd+1,preEnd,rootPointer+1,inEnd );
        return root;
    }

    public void preOrderPrintTree(TreeNode head){
        if (head == null){
            return;
        }
        System.out.print (head.val+" ");
        preOrderPrintTree ( head.left );
        preOrderPrintTree ( head.right );
    }

    public void inOrderPrintTree(TreeNode head){
        if (head == null){
            return;
        }
        inOrderPrintTree ( head.left );
        System.out.print (head.val+" ");
        inOrderPrintTree ( head.right );
    }

    public void postOrderPrintTree(TreeNode head) {
        if (head == null){
            return;
        }
        postOrderPrintTree ( head.left );
        postOrderPrintTree ( head.right );
        System.out.print (head.val + " ");
    }

}

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
