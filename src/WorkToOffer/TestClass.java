package WorkToOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

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
//        testPower ();
//        testReorder();
//        testFindKth ();
//        testReverse();
//        testMerge ();
//        testPrint();
//        testPopOrder ();
//        testVerifySequence();
//        testRandomClone ();
//        testMoreThanHalf();
//        testSwapString();
//        testGetLeastNumber();
//        testPrintNumber ();
//        testIsUgly();
//        testFirstNotRepeat();
//        testInversePairs();
//        testFirstCommon ();
//        testGetNumberOfK();
        testFindNumberAppearOnce();
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

    public static void testReorder(){
        ReOrderArray test = new ReOrderArray();
        int[] arr = {1,2,3,4,5};
        test.reOrderArray ( arr );
        System.out.println (Arrays.toString ( arr ));
    }

    public static void testFindKth(){
        FindKthToTail test = new FindKthToTail ();
        ListNode n1 = new ListNode ( 1 );
        ListNode n2 = new ListNode ( 2 );
        ListNode n3 = new ListNode ( 3 );
        ListNode n4 = new ListNode ( 4 );
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        ListNode result = test.FindKthToTail ( n1,4 );
        if (result!=null)
            System.out.println (result.val);
        else System.out.println (result);
    }

    public static void testReverse(){
        ReverseList test = new ReverseList ();
        ListNode n1 = new ListNode ( 1 );
        ListNode n2 = new ListNode ( 2 );
        ListNode n3 = new ListNode ( 3 );
        ListNode n4 = new ListNode ( 4 );
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        ListNode n5 =null;

        ListNode n6 = new ListNode ( 7 );

        ListNode n7 = new ListNode ( 8 );
        ListNode n8 = new ListNode ( 9 );
        n7.next = n8;

        ListNode normal = test.ReverseList ( n1 );
        ListNode nil = test.ReverseList ( n5 );
        ListNode single = test.ReverseList ( n6 );
        ListNode two = test.ReverseList ( n7 );
        printList(normal);
        printList(nil);
        printList(single);
        printList(two);
    }
    public static void printList(ListNode node){
        if (node == null){
            System.out.println ("null");
            return;
        }
        if (node.next == null){
            System.out.println (node.val);
            return;
        }
        while (node != null){
            System.out.print (node.val + " ");
            node = node.next;
        }
        System.out.println ();

    }

    public static void testMerge() {
        Merge test = new Merge ();
        ListNode n1 = new ListNode ( 1 );
        ListNode n2 = new ListNode ( 2 );
        ListNode n3 = new ListNode ( 3 );
        ListNode n4 = new ListNode ( 4 );
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        ListNode n11 = new ListNode ( 1 );
        ListNode n12 = new ListNode ( 12 );
        ListNode n13 = new ListNode ( 13 );
        ListNode n14 = new ListNode ( 14 );
        n11.next = n12;
        n12.next = n13;
        n13.next = n14;

        ListNode n = null;
//        ListNode result = test.Merge ( n,n1 );
//        printList ( result );
        ListNode result1 = test.Merge ( n1,n11 );
        printList ( result1 );
    }

    public static void testPrint(){
        PrintMatrix test = new PrintMatrix ();
        int[][] ma = {{0,1,2,3},{4,5,6,7},{8,9,10,11},{12,13,14,15}};
        int[][] ma1 = {{0,1,2,3,4,},{5,6,7,8,9},{10,11,12,13,14},{15,16,17,18,19},{20,21,22,23,24}};
        int[][] ma3 = {{1,2},{3,4},{5,6},{7,8},{9,10}};
        ArrayList result = test.printMatrix ( ma3 );
//        System.out.println (result);
    }

    public static void testPopOrder(){
        IsPopOrder test = new IsPopOrder ();
        int[] push ={1,2,3,4,5},pop={4,3,5,1,2};
        boolean result = test.IsPopOrder ( push,pop );
//        System.out.println (result);
    }

    public static void testVerifySequence(){
        VerifySquenceOfBST test = new VerifySquenceOfBST ();
        int[] seq = {5,7,6,9,11,10};

        System.out.println (test.VerifySquenceOfBST ( seq ));
    }

    public static void testRandomClone(){
        RandomClone test = new RandomClone ();
        RandomListNode n1 = new RandomListNode ( 1 );
        RandomListNode n2 = new RandomListNode ( 2 );
        RandomListNode n3 = new RandomListNode ( 3 );
        RandomListNode n4 = new RandomListNode ( 4 );

        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n1.random = n4;
        n2.random=n1;
        n3.random=n2;

        RandomListNode result = test.Clone ( n1 );
//        System.out.println (result.label+" "+result.next.label+" "+result.next.next.label);
//        System.out.println (result.random.label+" "+result.next.random.label);
    }

    public static void testSwapString(){
        SwapString test = new SwapString ();
        String str = "abcd";
        test.Permutation ( str );
    }

    public static void testMoreThanHalf(){
        MoreThanHalfNumber test = new MoreThanHalfNumber ();
//        int[] arr = {1,2,3,2,2,2,5,4,2};
        int[] arr = {4,2,1,4,4,4};
        int result = test.MoreThanHalfSimple ( arr );
        System.out.println (result);
    }

    public static void testGetLeastNumber(){
        GetLeastNumbers test = new GetLeastNumbers ();
//        int[] num = {5,8,9,6,2,3};
        int[] num = {50,10,90,30,70,40,80,60,20};
        ArrayList<Integer> re = test.GetLeastNumbers2 ( num,0 );
//        System.out.println (re);
        ArrayList<Integer> r1 = test.GetLeastNumbers1 ( num,0 );
        System.out.println (r1);

        ArrayList<Integer> r2 = test.GetLeastNumbers_Solution ( num,0 );
//        System.out.println (r2);
    }

    public static void testPrintNumber(){
        int[] numbers = {3,32,321};
        PrintMinNumber test = new PrintMinNumber ();
        String result = test.PrintMinNumber2 ( numbers );
        System.out.println (result);
    }

    public static void testIsUgly(){
        IsUglyNumber test = new IsUglyNumber ();
        int result = test.GetUglyNumber_Solution ( 20 );
        System.out.println (result);
    }
    public static void testFirstNotRepeat(){
        FirstNotRepeatingChar test = new FirstNotRepeatingChar ();
        int index = test.FirstNotRepeatingChar ( "googlr" );
        System.out.println (index);
    }

    public static void testInversePairs(){
        InversePairs test = new InversePairs ();
        int[] source = {10,3,3,54,45,6,17,8,9};
        int[] arr1 = {7,5,6,4};
        int[] arr = {1,2,3,4,5,6,7,0};
        int result = test.InversePairs_Internet ( arr );
        System.out.println (result);
    }

    public static void testFirstCommon(){
        ListNode n1 = new ListNode ( 1 );
        ListNode n2 = new ListNode ( 2 );
        ListNode n3 = new ListNode ( 3 );
        ListNode n4 = new ListNode ( 4 );
        ListNode n5 = new ListNode ( 5 );
        ListNode n6 = new ListNode ( 6 );
        ListNode n7 = new ListNode ( 7 );

//        ListNode n = null;
        n1.next = n2;
        n2.next = n3;
        n3.next = n6;
        n6.next = n7;
        n4.next = n5;
        n5.next = n6;


        FindFirstCommonNode test = new FindFirstCommonNode ();
        ListNode result = test.FindFirstCommonNode ( n1,n4 );
        System.out.println (result.val);

    }

    public static void testGetNumberOfK(){
        int[] arr1 = {0,1,2,3,3,3,3,4,5};
        int[] arr = {};
        GetNumberOfK test = new GetNumberOfK ();
        int result =test.GetNumberOfK ( arr,0 );
        System.out.println (result);
    }

    public static void testFindNumberAppearOnce(){
        int[] arr ={2,4,3,6,3,2,5,5};
        FindNumberAppearOnce test = new FindNumberAppearOnce ();
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        test.FindNumsAppearOnce ( arr,num1,num2 );
        System.out.println (num1[0]);
        System.out.println (num2[0]);
    }
}



class A {
    A(){
        System.out.println ("A's Constructor!");
    }
    static {
        System.out.println ("A's init!");
    }
    public static final int value =1;
    public void test(){
        System.out.println ("A's Test!");
    }
}

class B extends A{
    B(){
        System.out.println ("B's Constructor!");
    }
    static {
        System.out.println ("B's init!");
    }
    public void test1(){
        System.out.println ("B's Test!");
    }
}

class C extends A{
    public void test2(){
        System.out.println ("C's Test!");
    }
}

class D{
    public <T extends A> void someTest(B one, C two){

        System.out.println ("aefaef");
    }
}
