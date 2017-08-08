package PinDuoDuo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by zhuhao on 17-8-1.
 * 六一儿童节，老师带了很多好吃的巧克力到幼儿园。每块巧克力j的重量为w[j]，对于每个小朋友i，当他分到的巧克力大小达到h[i] (即w[j]>=h[i])，他才会上去表演节目。老师的目标是将巧克力分发给孩子们，使得最多的小孩上台表演。可以保证每个w[i]> 0且不能将多块巧克力分给一个孩子或将一块分给多个孩子。
 输入描述:

 第一行：n，表示h数组元素个数
 第二行：n个h数组元素
 第三行：m，表示w数组元素个数
 第四行：m个w数组元素


 输出描述:

 上台表演学生人数
 示例1
 输入

 3
 2 2 3
 2
 3 1
 输出

 1
 */
public class MaxPerform {
    public static void main(String[] args) {
        Scanner in = new Scanner ( System.in );
        String nStr = in.nextLine ();
        String narrStr = in.nextLine ();
        String mStr = in.nextLine ();
        String marrStr = in.nextLine ();

        int n = Integer.parseInt ( nStr );
        int m = Integer.parseInt ( mStr );
        String[] nstrs = narrStr.split ( " " );
        String[] mstrs = marrStr.split ( " " );
        if (m<0 || n<0)
            return;
        if (nstrs.length != n || mstrs.length!=m)
            return;

        int[] narr = new int[n];
        int[] marr = new int[m];
        for (int i=0;i<n;i++)
            narr[i] = Integer.parseInt ( nstrs[i] );
        for (int i=0;i<m;i++)
            marr[i] = Integer.parseInt ( mstrs[i] );

        int result = findCore(marr,narr,m,n);
        System.out.println (result);
    }

    public static int findCore(int[] marr,int[] narr,int m,int n){
        if (marr == null || narr==null || marr.length==0 || narr.length==0)
            return 0;
        sort ( marr,0,marr.length-1 );
        sort ( narr,0,narr.length-1 );

        int count = 0,p1=0,p2=0;
        while (p1<m && p2<n){
            if (marr[p1] >= narr[p2]){
                count++;
                p1++;
                p2++;
                continue;
            }
            p1++;
        }
//        System.out.println ( Arrays.toString (marr));
//        System.out.println ( Arrays.toString (narr));

        return count;
    }

    public static void sort(int[] arr,int low,int high){
        int index;

        if (low<high){
            index = partition(arr,low,high);

            sort ( arr,low,index-1 );
            sort ( arr,index+1,high );
        }
    }

    public static int partition(int[] source,int low,int high){
        int pivotkey = source[low];
        while (low<high){
            while (low<high && source[high]>=pivotkey)
                high--;
            swapArr ( source,low,high );
            while (low<high && source[low] <= pivotkey)
                low++;
            swapArr ( source,low,high );
        }
        return low;
    }

    public static void swapArr(int[] arr, int a,int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
