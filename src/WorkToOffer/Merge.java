package WorkToOffer;

/**
 * Created by zhuhao on 17-5-27.
 */
public class Merge {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;

        ListNode newHead;
        if(list1.val <= list2.val){
            newHead = list1;
            list1 = list1.next;
        }
        else {
            newHead = list2;
            list2 = list2.next;
        }
        condMerge(newHead,list1,list2);
        return newHead;
    }

    public void condMerge(ListNode head,ListNode list1,ListNode list2){
        if(list1 == null){
            head.next = list2;
            return;
        }
        if (list2 == null){
            head.next = list1;
            return;
        }

        if(list1.val <= list2.val){
            head.next = list1;
            list1 = list1.next;
            head = head.next;
            condMerge ( head,list1,list2 );
        } else {
            head.next = list2;
            list2 = list2.next;
            head = head.next;
            condMerge ( head,list1,list2 );
        }
    }
}
