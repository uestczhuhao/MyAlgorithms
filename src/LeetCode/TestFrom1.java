package LeetCode;

import java.util.Arrays;

public class TestFrom1 {
    public static void main(String[] args) {
        test01();
    }

    public static void test01(){
        _1SUm t = new _1SUm();
//        int[] arr = {2,7,11,19};
        int[] arr = {-1,-2,-3,-4,-5};
        int target = -8;
        int[] res = t.twoSum(arr,target);
        System.out.println(Arrays.toString(res));
    }
}
