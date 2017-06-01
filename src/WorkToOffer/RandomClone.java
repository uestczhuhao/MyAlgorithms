package WorkToOffer;

/**
 * Created by zhuhao on 17-5-31.
 */
public class RandomClone {
    public RandomListNode Clone(RandomListNode pHead){
        if (pHead == null)
            return null;
        RandomListNode pointer = pHead;
        while (pointer!=null){
            RandomListNode newNode = new RandomListNode ( 0 );
            newNode.label = pointer.label;
            newNode.random = pointer.random;
            newNode.next = pointer.next;
            pointer.next = newNode;
            pointer=pointer.next.next;
        }
        pointer = pHead;
        while (pointer!=null){
            if (pointer.random!=null){
                pointer.next.random = pointer.random.next;
            }

            pointer = pointer.next.next;
        }
        pointer=pHead.next;
        RandomListNode temp = new RandomListNode ( 0 );
        temp.label = pHead.next.label;
        temp.random = pHead.next.random;
        RandomListNode newHead = temp,pointer1=newHead;
        while (pointer.next!=null){
            RandomListNode tmp = new RandomListNode ( 0 );
            tmp.label = pointer.next.next.label;
            tmp.random = pointer.next.next.random;
            pointer1.next = tmp;
            pointer1 = pointer1.next;
            pointer = pointer.next.next;
//            System.out.println (pointer.label);
        }
//        print(pHead);
//        print(newHead);
        return newHead;
    }

    public void print(RandomListNode head){
        if (head == null)
            System.out.println ();
        while (head!=null){
            System.out.print (head.label+" ");
            head = head.next;
        }
        System.out.println ();
    }
}

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
