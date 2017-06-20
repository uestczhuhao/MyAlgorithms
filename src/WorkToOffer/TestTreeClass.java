package WorkToOffer;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by zhuhao on 17-5-27.
 */
public class TestTreeClass {
    public static void main(String[] args) {
//        testSubTree();
//        testTopToButtom ();
//        testFindPath();
//        testConvert();
//        testTreeDepth();
        testSymmetrical();
    }

    public static void testSubTree(){
        IsSubtree test = new IsSubtree ();
        TreeNode root1 = new TreeNode ( 1 );
        TreeNode node1 = new TreeNode ( 2 );
        TreeNode node2 = new TreeNode ( 3 );
        TreeNode node3 = new TreeNode ( 4 );
        TreeNode node4 = new TreeNode ( 5 );

        root1.left = node1;
        root1.right = node2;
        node2.left = node3;
        node2.right= node4;


        TreeNode root2 = new TreeNode ( 3 );
        TreeNode node5 = new TreeNode ( 4 );
        TreeNode node6 = new TreeNode ( 5 );
        root2.left = node5;
        root2.right = node6;

        TreeNode root3 = null;
        TreeNode root4 = null;


        boolean isOrNot = test.isSubTree ( root1,root2 );
//        boolean isOrNot1 = test.isSubTree ( root1,root3 );
//        boolean isOrNot2 = test.isSubTree ( root4,root2 );
//        boolean isOrNot3 = test.isSubTree ( root4,root3 );
        System.out.println (isOrNot);
//        System.out.println (isOrNot1);
//        System.out.println (isOrNot2);
//        System.out.println (isOrNot3);
    }

    public static void testTopToButtom(){
        PrintFromTopToButtiom test = new PrintFromTopToButtiom ();
        TreeNode root1 = new TreeNode ( 1 );
        TreeNode node1 = new TreeNode ( 2 );
        TreeNode node2 = new TreeNode ( 3 );
        TreeNode node3 = new TreeNode ( 4 );
        TreeNode node4 = new TreeNode ( 5 );

        root1.left = node1;
        root1.right = node2;
        node2.left = node3;
        node2.right= node4;

        ArrayList result = test.PrintFromTopToBottom ( root1 );
        System.out.println (result);
    }

    public static void testFindPath(){
        FindPath test =new FindPath ();
        TreeNode root1 = new TreeNode ( 10 );
        TreeNode node1 = new TreeNode ( 5 );
        TreeNode node2 = new TreeNode ( 12 );
        TreeNode node3 = new TreeNode ( 3 );
        TreeNode node4 = new TreeNode ( 7 );
        TreeNode node5 = new TreeNode ( 2 );
        TreeNode node6 = new TreeNode ( 4 );
        TreeNode node7 = new TreeNode ( 11 );
        TreeNode node8 = new TreeNode ( 13 );

        root1.left = node1;
        root1.right = node2;
        node1.left = node3;
        node1.right= node4;

        node3.left = node5;
        node3.right = node6;
        node2.left = node7;
        node2.right = node8;

        ArrayList<ArrayList<Integer>> result =
                test.FindPath ( root1,22 );
        System.out.println (result);
//        FindPath test1 = new FindPath ();
//        ArrayList<Integer> aaaa = new ArrayList<> (  );
//        aaaa.add ( 1 );
//        aaaa.add ( 2 );
//        aaaa.add ( 3 );
//        aaaa.add ( 4 );
//        System.out.println (test1.result1);
//        test1.result1.add ( aaaa );
//        System.out.println (test1.result1);
//        ArrayList<Integer> bbbb = new ArrayList<> (  );
//        bbbb.add ( 111 );
//        bbbb.add ( 122 );
//        test1.result1.add ( bbbb);
//        System.out.println (test1.result1);



//        for (int i=0;i<result.size ();i++)
//            System.out.println ( result[i]);
    }

    public static void testConvert() {
        TreeNode root = new TreeNode ( 10 );
        TreeNode node1 = new TreeNode (6);
        TreeNode node2 = new TreeNode (14);
        TreeNode node3 = new TreeNode (4);
        TreeNode node4 = new TreeNode (8);
        TreeNode node5 = new TreeNode (12);
        TreeNode node6 = new TreeNode (16);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;

        TreeConvertToLink test = new TreeConvertToLink ();
        TreeNode result = test.Convert ( root );
        System.out.println (result.val);
    }

    public static void testTreeDepth(){
        TreeNode root = new TreeNode ( 10 );
        TreeNode node1 = new TreeNode (6);
        TreeNode node2 = new TreeNode (14);
        TreeNode node3 = new TreeNode (4);
        TreeNode node4 = new TreeNode (8);
        TreeNode node5 = new TreeNode (12);
        TreeNode node6 = new TreeNode (16);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;

        TreeDepth test = new TreeDepth ();
        int result = test.TreeDepth ( root );
        System.out.println (result);
    }

    public static void testSymmetrical(){
        TreeNode root = new TreeNode ( 8 );
        TreeNode node1 = new TreeNode (6);
        TreeNode node2 = new TreeNode (6);
        TreeNode node3 = new TreeNode (5);
        TreeNode node4 = new TreeNode (7);
        TreeNode node5 = new TreeNode (7);
        TreeNode node6 = new TreeNode (5);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;

        Symmetrical test = new Symmetrical ();
        System.out.println (test.isSymmetrical ( root ));

    }
}




