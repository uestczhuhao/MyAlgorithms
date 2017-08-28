package Qunaer;

import java.util.*;
/**
 * Created by zhuhao on 17-8-28.
 * 对于一个有序数组，我们通常采用二分查找的方式来定位某一元素，请编写二分查找的算法，在数组中查找指定元素。
 给定一个整数数组A及它的大小n，同时给定要查找的元素val，请返回它在数组中的位置(从0开始)，若不存在该元素，返回-1。若该元素出现多次，请返回第一次出现的位置。
 测试样例：
 [1,3,5,7,9],5,3
 返回：1
 */
public class BinaSearch {
    public static void main(String[] args) {
        BinaSearch t =new BinaSearch ();
        int[] ar = {1,2,3,3,3};
        int n = 5,val = 3;
        System.out.println (t.getPos ( ar,n,val ));
    }
    public int getPos(int[] A, int n, int val) {
        // write code here

        int low = 0,high = n-1,middle=(n-1)/2;
        while (low<=high){
            middle = (low+high)>>1;
            if (A[middle] == val){
                break;
            } else if (A[middle]< val){
                low = middle+1;
            } else {
                high = middle-1;
            }
        }
        if (A[middle] ==val){
            int i;
            for (i=middle;i>0;i--){
                if (A[i-1] != val)
                    break;
            }
            return i;
        } else
            return -1;
    }
}
