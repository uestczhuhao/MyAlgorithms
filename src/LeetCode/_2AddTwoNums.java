package LeetCode;

import java.util.ArrayList;
import java.util.Stack;

public class _2AddTwoNums {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        //新建一个链表，preHead的next指向新链表的头结点
        ListNode preHead = new ListNode(0);
        ListNode index = preHead;
        int sum = 0;
        while (l1 != null || l2 !=null){
            sum /= 10;
            if (l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }

            index.next = new ListNode(sum%10);
            index = index.next;
        }
        if (sum /10 ==1)
            index.next = new ListNode(1);

        return preHead.next;
    }


}


