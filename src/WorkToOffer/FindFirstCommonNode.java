package WorkToOffer;

/**
 * Created by zhuhao on 17-6-17.
 */
public class FindFirstCommonNode {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null)
            return null;

        ListNode result = new ListNode ( 0 );
        int len1=0,len2=0;
        int diff = 0;
        ListNode point1=pHead1,point2=pHead2;
        while (point1 != null){
            len1++;
            point1 = point1.next;
        }
        while (point2 != null){
            len2++;
            point2 = point2.next;
        }
        point1 = pHead1;
        point2 = pHead2;
        if (len1 > len2){
            diff = len1-len2;
            for (int i=0;i<diff;i++)
                point1 = point1.next;
            for (int i=0;i<len2;i++){
                if (point1 == point2){
                    result = point1;
                    return result;
                }
                point1 = point1.next;
                point2 = point2.next;
            }
        } else {
            diff = len2-len1;
            for (int i=0;i<diff;i++)
                point2 = point2.next;
            for (int i=0;i<len1;i++){
                if (point1 == point2){
                    result = point1;
                    return result;
                }
                point1 = point1.next;
                point2 = point2.next;
            }
        }

    return null;
    }
}
