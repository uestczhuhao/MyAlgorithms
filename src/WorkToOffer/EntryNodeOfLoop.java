package WorkToOffer;

/**
 * Created by zhuhao on 17-6-20.
 */
public class EntryNodeOfLoop {
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if (pHead == null || pHead.next == null)
            return null;

        ListNode loopHead = new ListNode ( 0 );
        ListNode nodeTemp = meetNode ( pHead );
        if (nodeTemp == null)
            return null;
        int num = numOfLoop ( nodeTemp );
        loopHead = findHead ( pHead,num );
        return loopHead;
    }

    public ListNode meetNode(ListNode head){
        ListNode pFast=head.next,pSlow = head;
        while (pFast.next!= null && pFast.next.next!=null && pFast!=pSlow){
            pSlow = pSlow.next;
            pFast = pFast.next.next;
        }
        if (pFast == pSlow)
            return pFast;
        return null;
    }

    //输入的参数为P1和P2相遇的节点，从此节点出发计算出环的节点个数
    public int numOfLoop(ListNode node) {
        ListNode pointer = node.next;
        int count = 1;
        while (!pointer.equals ( node )){
            pointer=pointer.next;
            count++;
        }
        return count;
    }

    public ListNode findHead(ListNode head,int n){
        ListNode p1 = head,p2 = head;
        for (int i=0;i<n;i++)
            p2 = p2.next;
        while (!p1.equals ( p2 )){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
}
