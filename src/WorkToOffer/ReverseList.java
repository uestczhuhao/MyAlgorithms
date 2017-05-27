package WorkToOffer;

/**
 * Created by zhuhao on 17-5-27.
 */
public class ReverseList {
    public ListNode ReverseList(ListNode head) {

        if (head == null || head.next==null)
            return head;

        ListNode newHead = new ListNode ( 0 );
        if (head.next.next == null){
            newHead = head.next;
            head.next = null;
            newHead.next = head;
            return newHead;
        }

        ListNode pre=head,cur=head.next,nex=head.next.next;
        pre.next = null;
        while (nex != null){
            cur.next = pre;
            if (nex.next != null){
                pre = cur;
                cur = nex;
                nex = nex.next;
            } else {
                newHead = nex;
                newHead.next =cur;
                break;
            }
        }

        return newHead;
    }
    public void printList(ListNode node){
        if (node == null){
            System.out.println ("null");
            return;
        }
        if (node.next == null){
            System.out.println (node.val);
            return;
        }
        while (node != null){
            System.out.print (node.val + " ");
            node = node.next;
        }
        System.out.println ();

    }
}


