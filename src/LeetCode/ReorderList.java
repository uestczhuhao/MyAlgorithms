package LeetCode;

import java.util.Stack;

/**
 * Created by zhuhao on 17-5-14.
 */
public class ReorderList {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(4);

        ListNode n4 = new ListNode(8);
        ListNode n5 = new ListNode(1);
        ListNode n6 = new ListNode(6);
//        ListNode n7 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
//        n6.next = n7;

//        printList ( n1 );
//        ListNode n = reverseList ( n1);
//        printList ( n );
        reorderList ( n1 );
    }

    public static void reorderList(ListNode head) {
        if(head == null || head.next == null)
            return;
        ListNode midNode = findMidNode ( head );
        //必须要先把中间结点的next保存下来，
        // 否则会被下面的while循环破坏掉
        // 因为有head.next=null;此时的head等于midNode
        ListNode midNext = midNode.next;

        //halfPointer，halfHead为前一半链表的头结点
        ListNode halfHead = head,halfPointer = head;
        while (halfHead != midNode)
            halfHead = halfHead.next;
        halfHead.next=null;

        //后一半链表反转之后的头结点
        ListNode reversePointer = reverseList ( midNext ),reverseHead = reversePointer;
        while (halfPointer != null && reversePointer != null){
            ListNode insertNode = reversePointer;
            reversePointer = reversePointer.next;
            insertNode.next = halfPointer.next;
            halfPointer.next = insertNode;
            halfPointer = insertNode.next;
        }
        if(halfPointer != null)
            halfPointer.next = null;
//        else reversePointer.next =null;
//        printList ( head );
//        printList ( reversePointer );
    }

    public static ListNode findMidNode (ListNode head) {
        while (head == null || head.next == null){
            return head;
        }
        ListNode slow = head,fast = head.next;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;

    }
    public static ListNode reverseList(ListNode head) {
        Stack<ListNode> stack = new Stack<ListNode> ();
        if (head == null)
            return head;
        while(head!=null)
        {
            stack.push ( head );
            head=head.next;
        }
        ListNode pointer = new ListNode(0);
        ListNode next = stack.pop (),newHead=next ;
        while (!stack.isEmpty ()){
            pointer.next = next;
            pointer = next;
            next = stack.pop ();
        }
        next.next=null;
        pointer.next = next;

        return newHead;
    }

    public static void printList(ListNode x) {
        if(x != null){
            System.out.print(x.val + " ");
            while (x.next != null) {
                System.out.print(x.next.val + " ");
                x = x.next;
            }
            System.out.println();
        }

    }
}
