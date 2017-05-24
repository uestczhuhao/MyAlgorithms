package WorkToOffer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by zhuhao on 17-5-24.
 */
public class PrintReverseList {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        Stack<Integer> stack = new Stack<> ();
        ArrayList<Integer> result = new ArrayList<> (  );
        if(listNode == null)
            return result;

        while (listNode != null){
            stack.push ( listNode.val );
            listNode= listNode.next;
        }

        while (!stack.isEmpty ()){
            int tmp = stack.pop ();
            result.add ( tmp );
        }
        return result;
    }

    public ArrayList<Integer> printListRecursion(ArrayList<Integer> result, ListNode listNode) {

        if(listNode == null)
            return result;

        if(listNode != null)
            printListRecursion ( result,listNode.next );

//        System.out.println (listNode.val);
//        System.out.println ("result is "+result);
        result.add ( listNode.val );
        return result;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}