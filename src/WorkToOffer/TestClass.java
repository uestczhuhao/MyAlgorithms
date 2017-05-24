package WorkToOffer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by zhuhao on 17-5-22.
 */
public class TestClass {
    public static void main(String[] args) {
//        testReplaceSpace ();
        testPrintList();
    }

    public static void testReplaceSpace(){
        String str1 = "hello world";
        ReplaceSpace test = new ReplaceSpace ();

        StringBuffer str = new StringBuffer ( str1 );
        String result = test.replaceSpace ( str );
        System.out.println (result);
    }

    public static void testPrintList() {
        ListNode n1 = new ListNode ( 1 );
        ListNode n2 = new ListNode ( 2 );
        ListNode n3 = new ListNode ( 3 );
        ListNode n4 = new ListNode ( 4 );
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        PrintReverseList testPrint = new PrintReverseList ();
        ArrayList<Integer> tmp = new ArrayList<> (  );
        ArrayList result = testPrint.printListRecursion ( tmp,n1 );
        ArrayList r1 = testPrint.printListFromTailToHead ( n1 );
        System.out.println ( result);
        System.out.println ( r1);
    }
}
