package PinDuoDuo;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by zhuhao on 17-8-1.
 */
public class MaxMulti {
    public static void main(String[] args) {
        Scanner in = new Scanner ( System.in );
        String nStr = in.nextLine ();
        String arrStr = in.nextLine ();

        int n = Integer.parseInt ( nStr );
        String[] strs = arrStr.split ( " " );
        if (strs.length != n || n<3 || strs.length<3 || strs == null || strs.length == 0)
            return ;
        int[] arr = new int[n];
        for (int i=0;i<n;i++)
            arr[i] = Integer.parseInt ( strs[i] );

        long result = findMax(arr);
        System.out.println (result);
    }

    public static long findMax(int[] arr){
        if (arr == null || arr.length < 3 )
            return 0;

        long maxMul = Integer.MIN_VALUE;

        int length = arr.length;
        int max1=length-1,max2=length-2,max3=length-3,min1=0,min2=1;
        max1= findIndex ( arr,max1,0,length-1 );
        max2= findIndex ( arr,max2,0,length-1 );
        max3= findIndex ( arr,max3,0,length-1 );
        min1= findIndex ( arr,min1,0,length-1 );
        min2= findIndex ( arr,min2,0,length-1 );
//        System.out.println (max1);
//        System.out.println (max2);
//        System.out.println (max3);
//        System.out.println (min1);
//        System.out.println (min2);
        long sum1 = (long) max1*(long) max2*(long) max3;
        long sum2 = (long) min1*(long) min2*(long) max1;
//        System.out.println (sum1);
//        System.out.println (sum2);
        if (sum1 > sum2)
            maxMul = sum1;
        else maxMul = sum2;
        return maxMul;
    }

    public static int findIndex(int[] arr,int number,int low,int high){
        int index = partition ( arr,0,arr.length-1 );
//        System.out.println ("Index = "+index);
        while (number != index){
            if (index < number){
                low = index+1;
                index = partition ( arr,low,high );
            }
            else if (index > number){
                high = index-1;
                index = partition ( arr,low,index-1);
            }
            else
                return arr[index];
        }
        return arr[index];
    }
    public static int partition(int[] arr,int low,int high){
        if (low>=high)
            return low;

        Random ran = new Random ( );
        int index = ran.nextInt (high-low+1 )+low;
        swap ( arr,low,index );
        int temp = arr[low];
        while (low < high){
            while (low < high && arr[high] >= temp)
                high--;
            arr[low] = arr[high];
            while (low < high && arr[low] <= temp)
                low ++;
            arr[high] = arr[low];
        }
        arr[low] = temp;
        return low;
    }

    public static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
