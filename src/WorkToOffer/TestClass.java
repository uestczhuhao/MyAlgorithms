package WorkToOffer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by zhuhao on 17-5-22.
 */
public class TestClass {
    public static void main(String[] args) {
//        testReplaceSpace ();
//        testPrintList();
//        testReconstruct();
//        testStackQueue();
//        testMinNumber();
//        testFibonacci();
        testPower ();
//        System.out.println (Math.pow ( 0,-21 ));
    }

    public static void testReplaceSpace(){
        String str1 = "hello world";
        ReplaceSpace test = new ReplaceSpace ();

        StringBuffer str = new StringBuffer ( str1 );
        String result = test.replaceSpace ( str );
        System.out.println (result);
    }

    public static void testPrintList() {
        ListNode n1 = new ListNode ( 1 );
        ListNode n2 = new ListNode ( 2 );
        ListNode n3 = new ListNode ( 3 );
        ListNode n4 = new ListNode ( 4 );
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        PrintReverseList testPrint = new PrintReverseList ();
        ArrayList<Integer> tmp = new ArrayList<> (  );
        ArrayList result = testPrint.printListRecursion ( tmp,n1 );
        ArrayList r1 = testPrint.printListFromTailToHead ( n1 );
        System.out.println ( result);
        System.out.println ( r1);
    }

    public static void testReconstruct(){
        ReConstructBinaryTree test = new ReConstructBinaryTree ();
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,6,8};
        TreeNode root =test.reConstructBinaryTree ( pre,in );
        test.preOrderPrintTree ( root );
        System.out.println ();
        test.inOrderPrintTree ( root );
        System.out.println ();
        test.postOrderPrintTree ( root );
    }

    public static void testStackQueue(){
        StackQueue testStack = new StackQueue ();
        testStack.push (1);
    }

    public static void testMinNumber(){
        MinNumberInRotateArray test = new MinNumberInRotateArray();
//        int[] arr = {4,5,1,2,3};
        int[] arr = {1,1,0,1,1};
        int result = test.minNumberInRotateArray ( arr );
        System.out.println (result);
    }

    public static void testFibonacci(){
        int n=20;
        Fibonacci test = new Fibonacci ();
        int result =test.fibonacci ( n );
        System.out.println (result);
        Math.pow ( 2,n-1 );
    }

    public static void testPower(){
        Power test = new Power ();
        double result = test.power ( 0,-12 );
        System.out.println (result);
    }

}

class A {
    public void test(){
        System.out.println ("A's Test!");
    }
}

class B extends A{
    public void test1(){
        System.out.println ("B's Test!");
    }
}
