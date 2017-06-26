package WorkToOfferAttach;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;

/**
 * Created by zhuhao on 17-6-26.
 */
public class LowestAncestorMyself {
    boolean isPath = false;
    public TreeNode LowestAncestor(TreeNode node1,TreeNode node2,TreeNode root){
        if (root == null || node1 == null || node2 == null)
            return null;

        LinkedList<TreeNode> path1 = new LinkedList<> (  );
        LinkedList<TreeNode> path2 = new LinkedList<> (  );
        TreeNode pointer = root;
        path1.add ( pointer );
        path2.add ( pointer );
        getPath ( pointer,node1,path1 );
        isPath =false;
        getPath ( pointer,node2,path2 );
        for (int i=0;i<path1.size ();i++)
            System.out.print (path1.get ( i ).val+" ");
        System.out.println ();
        for (int i=0;i<path2.size ();i++)
            System.out.print (path2.get ( i ).val+" ");
        System.out.println ();

        System.out.println (getCommonNode ( path1,path2 ).val);
        return getCommonNode ( path1,path2 );
    }

    public void getPath(TreeNode root,TreeNode node,LinkedList<TreeNode> path){
        if (path.getLast ().equals ( node )){
            isPath = true;
            return;
        }
        if (root.left == null || root.right == null){
            return;
        }

        if (root.left != null){
            path.add ( root.left );
            getPath ( root.left,node,path );
            if (isPath)
                return;
            path.removeLast ();
        }

        if (root.right != null){
            path.add ( root.right );
            getPath ( root.right,node,path );
            if (isPath)
                return;
            path.removeLast ();

            root=root.right;
        }


    }

    public TreeNode getCommonNode(LinkedList<TreeNode> path1,LinkedList<TreeNode> path2){
        int i=0;
        TreeNode node1 = path1.get (i);
        TreeNode node2 = path2.get (i++);
        TreeNode node = node1.equals ( node2 )? node1:null;
        while (node1!= null && node2!=null && i<path1.size () && i<path2.size ()){
            if (node1.equals ( node2 ))
                node = node1;
            node1 = path1.get ( i );
            node2 = path2.get ( i++ );
        }
        return node;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}