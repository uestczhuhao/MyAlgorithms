package LeetCode;

import java.util.List;

/**
 * Created by zhuhao on 17-5-7.
 * Sort a linked list using insertion sort.
 * 即利用插入排序重排一个无序的链表
 * 思路是新建一个新序列，把旧的无序序列一个个插入新序列，直到旧序列为空
 */
public class InsertLinkedSort {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(4);

        ListNode n4 = new ListNode(8);
        ListNode n5 = new ListNode(1);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;

        ListNode n = insertionSortList(n1);

        printList ( n );
    }
//    public static ListNode insertionSortList(ListNode head) {
//
//        //链表长度为1或0,直接返回头结点
//        if(head == null || head.next == null)
//            return head;
//
//        ListNode newHead = new ListNode(head.val);
//        ListNode pointer = head.next;
//
//        // loop through each element in the list
//        while (pointer != null) {
//            // insert this element to the new list
//
//            ListNode innerPointer = newHead;
//            ListNode next = pointer.next;
//
//            if (pointer.val <= newHead.val) {
//                //保证newHead的值小于pointer的值
//                //如果后者值比较小，则调换二者
//                ListNode oldHead = newHead;
//                newHead = pointer;
//                newHead.next = oldHead;
//                printList ( newHead );
//            } else {
//                while (innerPointer.next != null) {
//
//                    if (pointer.val > innerPointer.val && pointer.val <= innerPointer.next.val) {
//                        ListNode oldNext = innerPointer.next;
//                        innerPointer.next = pointer;
//                        pointer.next = oldNext;
//                    }
//
//                    innerPointer = innerPointer.next;
//                }
//
//                if (innerPointer.next == null && pointer.val > innerPointer.val) {
//                    innerPointer.next = pointer;
//                    pointer.next = null;
//                }
//                printList ( newHead );
//            }
//
//            // finally
//            pointer = next;
//        }
//
//        return newHead;
//    }

    public static ListNode insertionSortList(ListNode head) {
        if(head == null || head.next ==null)
            return head;

        ListNode newHead = new ListNode ( head.val );
        ListNode pointer = head.next;
        while (pointer!=null){
            ListNode newPointer = newHead;
            ListNode next = pointer.next;

            //如果此时无序列表的某一个结点的值比有序列表的头结点值还小
            //则令这个结点为有序结点的头结点
            /**
             * 处理无序列表和有序列表的头结点的关系
             */
            if (pointer.val <= newHead.val){
                ListNode oldHead = newHead;
                newHead = pointer;
                newHead.next = oldHead;

            } else {
                /**
                 * 处理无序列表和有序列表的中间结点的关系
                 */
                while (newPointer.next != null){
                   if(pointer.val > newPointer.val && pointer.val <= newPointer.next.val){
                        pointer.next = newPointer.next;
                        newPointer.next = pointer;
                   }
                   newPointer = newPointer.next;
                }

                //此时newPointer已经指向有序列表的最后一个
                //若此时要插入的值依然比有序列表的最后一个大，则把其加入到有序列表的最后
                /**
                 * 处理无序列表和有序列表的尾结点的关系
                 */
                if(pointer.val > newPointer.val){
                    pointer.next = null;
                    newPointer.next = pointer;
                }

            }
            pointer = next;
        }

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
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}



