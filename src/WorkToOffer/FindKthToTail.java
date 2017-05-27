package WorkToOffer;

/**
 * Created by zhuhao on 17-5-27.
 */
public class FindKthToTail {
    public ListNode FindKthToTail(ListNode head,int k) {

        if (head == null || k==0)
            return null;

        ListNode pointer1=head,pointer2=head;
        for (int i=0;i<k;i++){
            if (pointer2 == null)
                return null;
            pointer2 = pointer2.next;
        }

        while (pointer2 != null){
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }
        return pointer1;
    }
}
