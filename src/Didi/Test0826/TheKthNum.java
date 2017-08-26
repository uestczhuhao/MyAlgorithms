package Didi.Test0826;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by zhuhao on 17-8-26.
 */
public class TheKthNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner ( System.in );
        String[] strs = sc.nextLine ().split ( " " );
        int[] nums = new int[strs.length];
        int k = sc.nextInt ();
        for (int i=0;i<strs.length;i++){
            nums[i] = Integer.parseInt ( strs[i] );
        }
        int key = strs.length-k,index;
        int low =0,high = nums.length-1;
        index = partition ( nums,low,high );
        while (index != key){
            if (index > key){
                high = index-1;
                index = partition ( nums,low,high );
            } else {
                low = index+1;
                index = partition ( nums,low,high );
            }
        }

        System.out.println ( nums[key] );
    }


    private static int partition(int[] arr,int low,int high){
        if (low>=high)
            return low;
        ///制作一个在[low,high]中的随机数，每次调用返回一个随机值
        Random ran = new Random (  );
        int index = low+ran.nextInt (high-low+1);
        swap(arr,low,index);
        int temp = arr[low];
        while (low<high){
            while (low<high && arr[high]>= temp)
                high--;
            arr[low] = arr[high];
            while (low<high && arr[low] <= temp)
                low++;
            arr[high] = arr[low];
        }
        arr[low] = temp;
        return low;
    }

    private static void swap(int[] arr,int a,int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
