package LeetCode;

import java.util.Arrays;

public class TestFrom1 {
    public static void main(String[] args) {
        test02();
    }

    public static void test01(){
        _1SUm t = new _1SUm();
//        int[] arr = {2,7,11,19};
        int[] arr = {-1,-2,-3,-4,-5};
        int target = -8;
        int[] res = t.twoSum(arr,target);
        System.out.println(Arrays.toString(res));
    }

    public static void test02(){
        _2AddTwoNums t = new _2AddTwoNums();
        _2AddTwoNums.ListNode root1 = t.new ListNode(3);
        _2AddTwoNums.ListNode node1 = t.new ListNode(9);
        _2AddTwoNums.ListNode node2 = t.new ListNode(9);
        _2AddTwoNums.ListNode node11 = t.new ListNode(9);
        _2AddTwoNums.ListNode node12 = t.new ListNode(9);
        _2AddTwoNums.ListNode node13 = t.new ListNode(9);
        _2AddTwoNums.ListNode node14 = t.new ListNode(9);
        _2AddTwoNums.ListNode node15 = t.new ListNode(9);
        _2AddTwoNums.ListNode node16 = t.new ListNode(9);
        _2AddTwoNums.ListNode node17 = t.new ListNode(9);
        _2AddTwoNums.ListNode root2 = t.new ListNode(7);
        _2AddTwoNums.ListNode node3 = t.new ListNode(5);
        _2AddTwoNums.ListNode node4 = t.new ListNode(6);
        root1.next = node1;
        node1.next = node2;
        node2.next = node11;
        node11.next = node12;
        node12.next = node13;
        node13.next = node14;
        node14.next = node15;
        node15.next = node16;
        node16.next = node17;
//        node15.next = node16;

        _2AddTwoNums.ListNode res = t.addTwoNumbers(root1,root2);
        while (res != null){
            System.out.print(res.val);
            res = res.next;
        }
    }
}
