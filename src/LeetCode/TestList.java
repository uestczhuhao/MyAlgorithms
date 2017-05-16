package LeetCode;
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
        n6.next = n1;
//        testDetectCycle ( n1 );
        testWordBreak();
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
}
