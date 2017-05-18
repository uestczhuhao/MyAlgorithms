package LeetCode;

import java.util.HashMap;

/**
 * Created by zhuhao on 17-5-18.
 * A linked list is given such that
 * each node contains an additional random pointer
 * which could point to any node in the list or null.
 * Return a deep copy of the list.
 *
 * 建立一个HashMap，建立<Old,New>结点的一一对应关系
 * 在新链表中使用这个关系，如果旧链表中某结点n有random，且n.random=m
 * 则在新链表中对应的n‘结点对应的n‘.random=m'
 */
public class CopyRandomList {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null)
            return head;

        RandomListNode pointer = head;
        RandomListNode newHead = new RandomListNode ( 0 );
        ////在HashMap中建立<Old,New>结点的一一对应关系
        HashMap<RandomListNode,RandomListNode> map1 = new HashMap<RandomListNode,RandomListNode> (  );
        newHead.label = head.label;
        newHead.random = head.random;
        map1.put ( head,newHead );
        RandomListNode newPointer = newHead;

        while (pointer.next != null){
            RandomListNode temp = new RandomListNode ( 0 );
            temp.label = pointer.next.label;
            temp.random = pointer.next.random;
            map1.put ( pointer.next,temp );
            newPointer.next = temp;
            newPointer = newPointer.next;
            pointer = pointer.next;
        }

        pointer = head;
        newPointer = newHead;
        while (newPointer != null){
            if(newPointer.random!=null){
                newPointer.random=map1.get ( pointer.random );
            }
            newPointer = newPointer.next;
            pointer = pointer.next;
        }

        return newHead;
    }

    public static void printList(RandomListNode x) {
        if(x != null){
            System.out.print(x.label + " ");
            while (x.next != null) {
                System.out.print(x.next.label + " ");
                x = x.next;
            }
            System.out.println();
        }

    }
}

  class RandomListNode {
      int label;
      RandomListNode next, random;
      RandomListNode(int x) { this.label = x; }
  };
