package LeetCode;

import java.util.List;

/**
 * Created by zhuhao on 17-5-11.
 * Sort a linked list in O(n log n) time using constant space complexity.
 * 快排算法实现排序，先找到链表中间的数据
 * 把比其小的数据生成一个链表left，比其大的数据生成一个right
 * 对左右链表分别递归排序，最后合成一个有序列表
 */
public class QuickSort {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(4);

        ListNode n4 = new ListNode(8);
        ListNode n5 = new ListNode(1);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(5);

        n1.next = n2;
//        n2.next = n3;
//        n3.next = n4;
//        n4.next = n5;
//        n5.next = n6;
//        n6.next = n7;

        ListNode n = QuickSort ( n1 );
//        ListNode n = sortList ( n1 );
//        System.out.println (n.next.val);
        printList ( n );
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


    public static ListNode QuickSort(ListNode head){
        if (head == null || head.next == null)
            return head;

        //选取一个比较合适的中间值
        ListNode headTemp = head,middleTemp = findMedian ( head ),tailTemp = findTailNode ( head );
        ListNode nodeSelect = new ListNode ( 0 );

        if (headTemp.val >= middleTemp.val){
            if (tailTemp.val >= headTemp.val)
                nodeSelect = headTemp;
            else if (tailTemp.val >= middleTemp.val)
                nodeSelect = tailTemp;
            else nodeSelect = middleTemp;
        }
        else {
            if (tailTemp.val >=middleTemp.val)
                nodeSelect = middleTemp;
            else if (tailTemp.val >=headTemp.val)
                nodeSelect = tailTemp;
            else nodeSelect = headTemp;
        }
//        System.out.println ("Middle is "+nodeSelect.val);
        int middle = nodeSelect.val;
        ListNode leftPointer = new ListNode(0),leftHeadPre = leftPointer;
        ListNode rightPointer = new ListNode(0),rightHeadPre = rightPointer;
        ListNode equalPointer = new ListNode(0),equalHeadPre = equalPointer;

        while (head!=null){
            if(head.val < middle){
                leftPointer.next = head;
//                leftPointer = head;  //此句和下一句一样，只是更好理解
                leftPointer = leftPointer.next;
            } else if (head.val > middle){
                rightPointer.next = head;
//                rightPointer = head; //此句和下一句一样，只是更好理解
                rightPointer = rightPointer.next;
            } else {
                equalPointer.next = head;
                equalPointer = equalPointer.next;
            }
            head = head.next;
        }
        leftPointer.next = null;
        rightPointer.next = null;
        equalPointer.next = null;
//        System.out.print ("The left link is ");
//        printList ( leftHeadPre.next );
//        System.out.print ("The right link is ");
//        printList ( rightHeadPre.next );
//        System.out.print ("The equal link is ");
//        printList ( equalHeadPre.next );

        //left和right是链表的真正的头结点
        ListNode left = QuickSort ( leftHeadPre.next );
        ListNode right = QuickSort ( rightHeadPre.next );

        ListNode n =merge(left,equalHeadPre.next,right);
//        System.out.print ("After merge, the list is ");
//        printList ( n );
        return n;
    }

    private static ListNode findMedian(ListNode head){
        ListNode fast=head.next,slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static ListNode findTailNode(ListNode head){
        if(head == null)
            return head;
        while (head.next!= null)
            head = head.next;
        return head;
    }

    public static ListNode merge(ListNode leftHead,ListNode midHead,ListNode rightHead){
        ListNode tail = new ListNode ( 0 ),temp = tail;
        tail.next = leftHead; tail = findTailNode ( tail );
        tail.next=midHead; tail = findTailNode ( tail );
        tail.next = rightHead; tail = findTailNode ( tail );
        return temp.next;
    }


    //注释掉的代码为网上代码，上面的为自己编写的快排代码
    //    public static ListNode sortList(ListNode head) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//
//        //找到链表的中间结点
//        ListNode mid = findMedian(head); // O(n)
//
//        ListNode leftDummy = new ListNode(0), leftTail = leftDummy;
//        ListNode rightDummy = new ListNode(0), rightTail = rightDummy;
//        ListNode middleDummy = new ListNode(0), middleTail = middleDummy;
//        while (head != null) {
//            //建立一个比中间结点小的左链表
//            //一个比中间结点大的又链表和与其相等的中间链表
//            if (head.val < mid.val) {
//                leftTail.next = head;
//                leftTail = head;
//            } else if (head.val > mid.val) {
//                rightTail.next = head;
//                rightTail = head;
//            } else {
//                middleTail.next = head;
//                middleTail = head;
//            }
//            head = head.next;
//        }
//
//
//        leftTail.next = null;
//        middleTail.next = null;
//        rightTail.next = null;
//
////        System.out.print ("The leftDummy list are ");
////        printList ( leftDummy.next );
////        System.out.print ("The leftTail list are ");
////        printList ( leftTail.next );
////        System.out.println ();
//        //递归刚刚创建的左右链表，事左右链表都有序化
//
//        ListNode left = sortList(leftDummy.next);
//        ListNode right = sortList(rightDummy.next);
//
//        //链接已经有序化的三个列表
//        return concat(left, middleDummy.next, right);
//    }
//
//    private static ListNode concat(ListNode left, ListNode middle, ListNode right) {
//        ListNode dummy = new ListNode(0), tail = dummy;
//
//        tail.next = left; tail = getTail(tail);
//        tail.next = middle;tail = getTail(tail);
//        tail.next = right; tail = getTail(tail);
//        return dummy.next;
//    }
//
//    private static ListNode getTail(ListNode head) {
//        if (head == null) {
//            return null;
//        }
//
//        while (head.next != null) {
//            head = head.next;
//        }
//        return head;
//    }
//
//    //找到中间结点的位置
//    private static ListNode findMedian(ListNode head){
//        ListNode fast=head.next,slow = head;
//        while (fast != null && fast.next != null){
//            fast = fast.next.next;
//            slow = slow.next;
//        }
//        return slow;
//    }
}

  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }