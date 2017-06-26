package WorkToOfferAttach;

import java.util.LinkedList;

/**
 * Created by zhuhao on 17-6-24.
 */
public class TestClass {
    public static void main(String[] args) {
//        testMGroup ();
//        testIsAnagram();
//        testDelete();
//        testPrint ();
//        testLowest ();
        String str1 = "Hello";
        String str2 = "Hello";
        System.out.println (str1 == str2);
        System.out.println (str1 .equals ( str2 ) );
    }


    public static void testMGroup(){
        MGroupOfNlengthString test = new MGroupOfNlengthString ();
        String str = "abcd";
        test.mGroupOfNlengthString ( str );
    }

    public static void testIsAnagram(){
        IsAnagramString test = new IsAnagramString ();
        String s1 = "livee";
        String s2 = "evill";
        boolean isOrNot=test.isAnagram ( s1,s2 );
        System.out.println (isOrNot);
    }

    public static void testDelete(){
        DeleteRepeate test =new DeleteRepeate ();
        String str = "google";
        String str1=test.deleteRepeat ( str );
        System.out.println (str1);
    }

    public static void testPrint(){
        PrintProbility test = new PrintProbility ();
        test.PrintProbility ( 3 );
    }
    public static void testLowest() {
        LowestAncestorMyself test = new LowestAncestorMyself();
        TreeNode node1 = new TreeNode ( 1 );
        TreeNode node2 = new TreeNode ( 2 );
        TreeNode node3 = new TreeNode ( 3 );
        TreeNode node4 = new TreeNode ( 4 );
        TreeNode node5 = new TreeNode ( 5 );
        TreeNode node6 = new TreeNode ( 6 );
        TreeNode node7 = new TreeNode ( 7 );
        TreeNode node8 = new TreeNode ( 8 );
        TreeNode node9 = new TreeNode ( 9 );

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node4.left = node6;
        node4.right = node7;
        node5.left = node8;
        node5.right = node9;

        test.LowestAncestor ( node7,node1,node1 );
    }
}
