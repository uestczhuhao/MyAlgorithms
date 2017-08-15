package Tecent;

import java.util.Random;

/**
 * Created by zhuhao on 17-8-16.
 */
public class Gifts {
    public int getValue(int[] gifts, int n) {
        // write code here
        quickSort ( gifts,0,n-1 );
        int index = gifts[n/2];
        if (!isMoreThanHalf ( gifts,index ))
            return 0;
        return index;
    }

    private void quickSort(int[] num,int low,int high){
        int index;
        if (low<high){
            index = partition ( num,low,high );
            quickSort ( num,low,index-1 );
            quickSort ( num,index+1,high );
        }
    }

    private int partition(int[] num,int low,int high){
        if (low>=high)
            return low;
        Random ran = new Random (  );
        int index = ran.nextInt (high+1-low)+low;
//        System.out.println ("Indes = "+index);
        int temp = num[low];
        num[low] = num[index];
        num[index] = temp;
        temp = num[low];
        while (low<high){
            while (low<high && num[high]>=temp)
                high--;
            num[low] = num[high];
            while (low<high && num[low]<=temp)
                low++;
            num[high]=num[low];
        }
        num[low]=temp;
        return low;
    }

    private boolean isMoreThanHalf(int[] num,int m){
        int count = 0,len=num.length;
        for (int i=0;i<len;i++)
            if (m == num[i])
                count++;
        if (count>len/2)
            return true;
        return false;
    }
}
