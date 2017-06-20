package LeetCode;
import WorkToOffer.EntryNodeOfLoop;
import WorkToOffer.PrintReverseList;

import java.util.Arrays;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Set;

/**
 * Created by zhuhao on 17-5-15.
 */
public class TestList {
    public static void main(String[] args) {
        //无环
//        ListNode n1 = new ListNode(2);
//        ListNode n2 = new ListNode(3);
//        ListNode n3 = new ListNode(4);
//
//        ListNode n4 = new ListNode(8);
//        ListNode n5 = new ListNode(1);
//        ListNode n6 = new ListNode(6);
//        ListNode n7 = new ListNode(5);
//
//        n1.next = n2;
//        n2.next = n3;
//        n3.next = n4;
//        n4.next = n5;
//        n5.next = n6;
//        n6.next = n7;

        //有环
//        ListNode n1 = new ListNode(1);
//        ListNode n2 = new ListNode(2);
//        ListNode n3 = new ListNode(3);
//
//        ListNode n4 = new ListNode(4);
//        ListNode n5 = new ListNode(5);
//        ListNode n6 = new ListNode(6);
//
//        n1.next = n2;
//        n2.next = n3;
//        n3.next = n4;
//        n4.next = n5;
//        n5.next = n6;
//        n6.next = n1;
//        testDetectCycle ( n1 );
//        testWordBreak();

        RandomListNode n1 = new RandomListNode(2);
        RandomListNode n2 = new RandomListNode(3);
        RandomListNode n3 = new RandomListNode(4);

        RandomListNode n4 = new RandomListNode(8);
        RandomListNode n5 = new RandomListNode(1);
        RandomListNode n6 = new RandomListNode(6);
        RandomListNode n7 = new RandomListNode(5);

        n1.next = n2;
        n1.random = n3;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
//        testCopyRandomList(n1);
//        testSingleNumber ();
//        testCandy ();
        testCanComplete();
//        testMinCut();
    }

    public static void testDetectCycle(ListNode head){
        DetectCycle test = new DetectCycle ();
        ListNode circleHead = test.detectCycle ( head );
        if (circleHead!=null)
            System.out.println (circleHead.val);
        else System.out.println (circleHead);
    }

    public static void testWordBreak(){
        WordBreak testWord = new WordBreak ();
        String str ="catsanddog";
        Set<String> dic = new HashSet<String> ();
        dic.add ( "cat" );
        dic.add ( "cats" );
        dic.add ( "and" );
        dic.add ( "sand" );
        dic.add ( "dog" );
//        boolean result = testWord.wordBreak ( str,dic );
//        ArrayList<String> result = testWord.wordBreakTwo ( str,dic );
        ArrayList<String> result = testWord.wordBreak2 ( str,dic );
        System.out.println (result.size ());
        for (String tem:result)
            System.out.println (tem);
    }

    public static void testCopyRandomList(RandomListNode head){
        CopyRandomList testRandom = new CopyRandomList ();
        RandomListNode head1 = testRandom.copyRandomList ( head );
//        testRandom.printList ( head );
        System.out.println ("Old Head's Random "+head.random.label);
        System.out.println ("New Head's Random "+head1.random.label);
        head1.random.label=3223;

        testRandom.printList ( head );
        testRandom.printList ( head1 );
//        testRandom.getElement (head,head);
    }

    public static void testSingleNumber(){
        int[] A = {2,2,2,3,3,3,4};
        SingleNumber testSingle = new SingleNumber ();
        int result = testSingle.singleNumber2 ( A );
        System.out.println (result);
    }
    public static void testCandy(){
        int[] rating = {2,3,2};
        Candy candy= new Candy ();
        int count = candy.candy ( rating );
        System.out.println (count);
    }
    public static void testCanComplete(){
//        int[] gas = {1,2,6,4,5};
//        int[] cost = {2,3,3,4,3};
        int[] gas = {2,3,1};
        int[] cost = {3,1,2};
        CanCompleteCircuit testCanCom = new CanCompleteCircuit ();
        int result = testCanCom.canCompleteCircuit ( gas,cost );
        System.out.println (result);
    }

    public static void testMinCut(){
        MinCut testMinCut = new MinCut ();
        String s = "aabbaa";
        char[] chs = s.toCharArray ();
        boolean isOrNot = testMinCut.isPalindrome ( chs );
        int result = testMinCut.minCut ( s );
        System.out.println (result);
    }



}
