package WorkToOffer;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by zhuhao on 17-6-18.
 */
public class LastRemaining {
//    public static void main(String[] args) {
//        LinkedList<Integer> a = new LinkedList<> (  );
//        a.add ( 1 );
//        a.add ( 2 );
//        a.add ( 3 );
//        System.out.println (a.get ( 3 ));
//    }

    /**
     * 重复的遍历，每删除一个数字需要一个m步运算
     * 总共有n个数字，因此时间复杂度为O(mn)
     * 而且还需要一个辅助链表模拟圆圈，空间复杂度为O(n)
     */
    public int LastRemaining_Solution(int n, int m) {
        if (n<1 || m<1)
            return -1;
        //LinkedList中index范围的值为0～n-1
        LinkedList<Integer> list = new LinkedList<> (  );
        for (int i=0;i<n;i++)
            list.add ( i );
        int curr=0,next=0;
        while (list.size ()>1){
            for (int i=0;i<m-1;i++){
                curr++;
                if (curr == list.size ()){
                    curr=0;
                }
            }
            next = curr;
            list.remove ( curr );
            if (next == list.size ()) {
                next=0;
            }

            curr = next;
        }

        return list.get ( 0 );
    }
}
