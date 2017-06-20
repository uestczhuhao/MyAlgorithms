package WorkToOffer;

/**
 * Created by zhuhao on 17-6-20.
 */
public class deleteDuplication {
    ///只能删除重复两次的节点
    public ListNode deleteDuplication(ListNode pHead) {
        if(pHead == null)
            return null;
        if (pHead.next == null)
            return pHead;

        ListNode result = pHead;
        //如果在头节点处发生重复，则替换头节点为第一个非重复的节点
        while (pHead.next!=null && pHead.val ==  pHead.next.val  ){
            pHead = pHead.next.next;
            if (pHead == null)
                break;
        }
        System.out.println ("comming");
        if (pHead == null)
            return null;
        if (pHead.next == null)
            return pHead;
        //pHead为第一个非重复节点且非空,且列表至少有两个节点
        ListNode pPre = pHead,pCurr = pHead.next;
        while (pCurr != null && pCurr.next !=null){
            System.out.print ("Prev is "+pPre.val+" ");
            System.out.println ("Curr is "+pCurr.val);
            while (pCurr !=null && pCurr.next!=null &&(pCurr.val == pCurr.next.val)){
                if (pCurr.next.next !=  null){
                    pCurr = pCurr.next.next;
                    pPre.next = pCurr;
                } else {
                    pCurr = null;
                    pPre.next = pCurr;
                    break;
                }
            }
            if (pCurr == null)
                break;
            pPre = pCurr;
            pCurr = pCurr.next;
        }

        return pHead;
    }


    //能删除n个重复的值
    //先处理头节点，再处理其他节点
    public ListNode deleteDuplication1(ListNode pHead){
        if (pHead==null)
            return null;

        int flag =0;
        while (pHead.next != null && pHead.val == pHead.next.val){
            pHead = pHead.next;
            flag = 1;
        }
        if (flag ==1)
            pHead = pHead.next;
        if (pHead == null)
            return null;
        printList ( pHead );
        ListNode pPre = new ListNode ( 0 ),preHead = pPre;

        pPre.next = pHead;
        ListNode pCurr = pHead;
        while (pCurr != null){
            ListNode pNext = pCurr.next;
            if (pNext!=null){
                if (pCurr.val == pNext.val){
                    while (pNext != null && pCurr.val == pNext.val)
                        pNext = pNext.next;
                    pPre.next = pNext;
                    pCurr = pNext;
                } else {
                    pPre = pCurr;
                    pCurr = pNext;
                }
            } else
                break;
        }


        return preHead.next;
    }

    public ListNode deleteDuplication_Net(ListNode pHead)
    {

        if (pHead == null) return null;
        ListNode p = pHead;
        ListNode n = new ListNode(0);
        ListNode pre = n;
        n.next = pHead;
        boolean flag = false;
        while (p != null) {
            ListNode q = p.next;
            if (q == null) break;
            if (q.val == p.val) {
                while (q != null && q.val == p.val) {
                    q = q.next;
                }
                pre.next = q;
                p = q;
            } else {
                if (!flag) {
                    n.next = p;
                    flag = true;
                }
                pre = p;
                p = q;
            }
        }
        return n.next;
    }

    public void printList(ListNode head){
        if (head == null)
            return;
        ListNode pointer = head;
        while (pointer !=null ){
            if (pointer.next == null){
                System.out.println (pointer.val);
            } else {
                System.out.print (pointer.val+" ");
            }
            pointer = pointer.next;
        }
    }
}
