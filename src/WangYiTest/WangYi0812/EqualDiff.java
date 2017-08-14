package WangYiTest.WangYi0812;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by zhuhao on 17-8-14.
 * 如果一个数列S满足对于所有的合法的i,都有S[i + 1] = S[i] + d, 这里的d也可以是负数和零,我们就称数列S为等差数列。
 小易现在有一个长度为n的数列x,小易想把x变为一个等差数列。
 小易允许在数列上做交换任意两个位置的数值的操作,并且交换操作允许交换多次。但是有些数列通过交换还是不能变成等差数列,小易需要判别一个数列是否能通过交换操作变成等差数列
 输入描述:
 输入包括两行,第一行包含整数n(2 ≤ n ≤ 50),即数列的长度。
 第二行n个元素x[i](0 ≤ x[i] ≤ 1000),即数列中的每个整数。


 输出描述:
 如果可以变成等差数列输出"Possible",否则输出"Impossible"。

 输入例子1:
 3
 3 1 2

 输出例子1:
 Possible
 */
public class EqualDiff {
    public static void main(String[] args) {
        Scanner in = new Scanner ( System.in );
        while (in.hasNext ()){
            int n = in.nextInt ();
            if (n<2)
                return;
            int[] arr = new int[n];
            for (int i=0;i<n;i++){
                arr[i] = in.nextInt ();
            }
            quickSort (arr,0,arr.length-1);
//            System.out.println ( Arrays.toString ( arr ));
            int d = arr[1]-arr[0];
            for (int i=2;i<n;i++){
                if (arr[i]-arr[i-1] != d){
                    System.out.println ("Impossible");
                    return;
                }
            }
            System.out.println ("Possible");
        }
    }

    private static void quickSort(int[] arr,int low,int high){
        int index;
        if (low<high){
            index = partition ( arr,low,high );
            quickSort ( arr,low,index-1 );
            quickSort ( arr,index+1,high );
        }
    }

    private static int partition(int[] arr,int low,int high){
        if (low>=high)
            return low;
        Random ran = new Random (  );
        int tmp = ran.nextInt (high-low+1 )+low;
        swap ( arr,low,tmp );
        tmp = arr[low];
        while (low<high){
            while (low<high && arr[high]>= tmp)
                high--;
            arr[low] = arr[high];
            while (low<high && arr[low]<=tmp)
                low++;
            arr[high] = arr[low];
        }
        arr[low] = tmp;
        return low;
    }

    private static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
