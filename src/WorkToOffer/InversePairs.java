package WorkToOffer;

import java.util.Arrays;

/**
 * Created by zhuhao on 17-6-16.
 */
public class InversePairs {
    public int InversePairs(int [] array) {
        if(array == null || array.length == 0)
            return 0;
        int[] copy = new int[array.length];
        System.arraycopy ( array,0,copy, 0,array.length);
        int result  = inverseCore ( array,copy,0,array.length-1 )%1000000007;
        return result;
    }

    public int inverseCore(int[] array, int[] copy,int start,int end){
        if (start == end){
            copy[start] = array[start];
            return 0;
        }

        int middle = (start+end)/2;
        int left = inverseCore ( copy,array,start,middle )%1000000007;
        int right = inverseCore ( copy,array,middle+1,end )%1000000007;

        //i指向前半段的最后一个数字下标
        int i=middle;
        //j指向后半段的最后一个下标
        int j = end,indexCopy = end;
        int count =0;
        while (i>=start && j>=middle+1){
            if (array[i]>array[j]){
                copy[indexCopy--] = array[i--];
                count += j-middle;
                count = count %1000000007;
            } else {
                copy[indexCopy--] = array[j--];
            }
        }
        for (; i>=start; i--)
            copy[indexCopy--] = array[i];
        for (; j>=middle+1; j--)
            copy[indexCopy--] = array[j];

        return (left+right+count)%1000000007;
    }

    public static int InversePairs_Internet(int [] array) {
        if(array==null||array.length==0)
        {
            return 0;
        }
        int[] copy = new int[array.length];
        for(int i=0;i<array.length;i++)
        {
            copy[i] = array[i];
        }
        int count = InversePairsCore(array,copy,0,array.length-1);//数值过大求余
        return count;

    }
    private  static int InversePairsCore(int[] array,int[] copy,int low,int high)
    {
        if(low==high)
        {
            return 0;
        }

        int mid = (low+high)>>1;
        int leftCount = InversePairsCore(array,copy,low,mid)%1000000007;
        int rightCount = InversePairsCore(array,copy,mid+1,high)%1000000007;
        int count = 0;
        int i=mid;
        int j=high;
        int locCopy = high;
        while(i>=low&&j>mid)
        {
            if(array[i]>array[j])
            {
                count += j-mid;
                copy[locCopy--] = array[i--];
                if(count>=1000000007)//数值过大求余
                {
                    count%=1000000007;
                }
            }
            else
            {
                copy[locCopy--] = array[j--];
            }
        }
        for(;i>=low;i--)
        {
            copy[locCopy--]=array[i];
        }
        for(;j>mid;j--)
        {
            copy[locCopy--]=array[j];
        }
        for(int s=low;s<=high;s++)
        {
            array[s] = copy[s];
        }
        return (leftCount+rightCount+count)%1000000007;
    }
}
