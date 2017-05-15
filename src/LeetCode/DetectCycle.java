package LeetCode;

/**
 * Created by zhuhao on 17-5-14.
 * 这题不光要求出是否有环，而且还需要得到这个环开始的节点。譬如下面这个，起点就是n2。
 *
 * n6-----------n5
 * |            |
 * n1--- n2---n3--- n4|
 * 我们仍然可以使用两个指针fast和slow，fast走两步，slow走一步，
 * 判断是否有环，当有环重合之后，譬如上面在n5重合了，那么如何得到n2呢？
 *
 * 首先我们知道，fast每次比slow多走一步，所以重合的时候，
 * fast移动的距离是slot的两倍，我们假设n1到n2距离为a，
 * n2到n5距离为b，n5到n2距离为c，fast走动距离为a + b + c + b，
 * 而slow为a + b，有方程a + b + c + b = 2 x (a + b)，可以知道a = c，
 * 所以我们只需要在重合之后，一个指针从n1，而另一个指针从n5，都每次走一步，那么就可以在n2重合了。
 */
public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null)
            return null;
        //slow,fast都从链表的头开始
        ListNode slow = head,fast = head;
        //如果无环，则fast终会指向空
        while (fast.next != null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            //在fast和slow相遇时处理，此时fast领先了slow一圈
            if(fast == slow){
                //指针1从链表头开始，指针2从相遇处开始
                ListNode pointer1 = head,pointer2 = fast;
                while (pointer1 != pointer2){
                    pointer1 = pointer1.next;
                    pointer2 = pointer2.next;
                }
                return pointer1;
            }

        }

        return null;
    }
}
