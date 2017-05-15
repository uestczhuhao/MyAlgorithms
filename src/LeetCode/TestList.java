package LeetCode;

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
        testDetectCycle ( n1 );
    }

    public static void testDetectCycle(ListNode head){
        DetectCycle test = new DetectCycle ();
        ListNode circleHead = test.detectCycle ( head );
        if (circleHead!=null)
            System.out.println (circleHead.val);
        else System.out.println (circleHead);
    }
}
