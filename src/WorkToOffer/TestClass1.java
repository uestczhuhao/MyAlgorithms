package WorkToOffer;

import java.util.ArrayList;

/**
 * Created by zhuhao on 17-6-17.
 */
public class TestClass1 {
    public static void main(String[] args) {
//        testReverseString ();
//        testLeftRotate();
//        testIsContinus();
//        testLastRemaing();
//        testStrToInt();
//        testIsNumeric ();
//        testEntryNodeOfLoop();
        testDelete ();
        testMaxInWindows();
    }

    public static void testReverseString(){
        ReverseString test = new ReverseString ();
        String str1 = "I am a student.";
        String str = "   ";
        String re = test.ReverseSentence ( str );
        System.out.println ("Result ="+re);
    }

    public static void testLeftRotate(){
        LeftRotateString test = new LeftRotateString ();
        String str = "abcdefg";
        String re = test.LeftRotateString1 ( str,2 );
        System.out.println (re);
    }

    public static void testIsContinus(){
        IsContinous test = new IsContinous ();
        int[] arr= {1,2,4,6,0};
        boolean re = test.isContinuous ( arr );
        System.out.println (re);
    }

    public static void testLastRemaing(){
        LastRemaining test = new LastRemaining ();
        int re = test.LastRemaining_Solution ( 5,3 );
        System.out.println (re);
    }

    public static void testStrToInt(){
        StrToInt test = new StrToInt ();
        String str = "112a23";
        int re = test.StrToInt ( str );
        System.out.println (re);
    }

    public static void testIsNumeric(){
        IsNumeric test = new IsNumeric ();
        String str= "5e2.21";
        char[] chs = str.toCharArray ();
        boolean re =test.isNumeric ( chs );
        System.out.println (re);
    }

    public static void testEntryNodeOfLoop(){
        EntryNodeOfLoop test = new EntryNodeOfLoop ();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);

        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n3;

        ListNode re = test.EntryNodeOfLoop ( n2 );
        if (re == null)
            System.out.println (re);
        else
            System.out.println (re.val);
    }

    public static void testDelete(){
        deleteDuplication test = new deleteDuplication ();
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(2);

        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(2);
        ListNode n6 = new ListNode(2);
        ListNode n7 = new ListNode(2);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;

        ListNode result =test.deleteDuplication1 ( n1 );
//        System.out.println (result);
        test.printList ( result );
    }

    public static void testMaxInWindows(){
        MaxInWindows test = new MaxInWindows ();
        int[] ints = {2,3,4,2,6,2,5,1};
        ArrayList<Integer> re = test.maxInWindows ( ints,0 );
        System.out.println (re);
    }
}
