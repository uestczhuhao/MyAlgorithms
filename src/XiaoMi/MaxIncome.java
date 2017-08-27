package XiaoMi;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by zhuhao on 17-8-27.
 */
public class MaxIncome {
    public static void main(String[] args) {
        MaxIncome t=new MaxIncome ();
        int[] prices = {3,8,5,1,7,8};
        int[] prices1 = {0,1,-3,-4,6,1};
//        System.out.println (t.calculateMax ( prices ));
        System.out.println (t.calculateMax111 ( prices ));
//        System.out.println (t.maxSubArray ( prices1 )[0]);
//        System.out.println (t.maxSubArray ( prices1 )[1]);
    }

    public int calculateMax1(int[] prices) {
        int maxIncome = 0;
        int n = prices.length;
        ArrayList<Integer> dif = new ArrayList<> (  );
        for (int i=1;i<n;i++){
            dif.add ( prices[i] - prices[i-1] );

        }

//        maxIncome = maxSubArray ( dif )[0]+maxSubArray ( dif )[1];

        if (maxIncome <0)
            return 0;
        return maxIncome;
    }

    public int[] maxSubArray(ArrayList<Integer> arr){
        int count[] = new int[3];
        int max = Integer.MIN_VALUE;
        for (int i=1;i<arr.size ();i++){
            count[0]+= arr.get ( i );
            if (count[0] < arr.get ( i )){
                count[0] = arr.get ( i );
            }
            if (count[0] > max){
                max = count[0];
            }
        }

        return count;
    }

    /*
    动态规划的思想。
        首先从左往右扫描，先计算出子序列[0,...,i]中的最大利润，
        用一个left数组保存下来，时间是O(n)。
        第二步是从右往左逆向扫描，计算子序列[i,...,n-1]上的最大利润，
        用right数组保存下来，s时间是O(n)，
        同时结合left和right数组的结果就能计算最终的最大利润了，这一步也是O(n)。 

        所以最后算法的复杂度就是O(n)的。具体代码如下：
     */
    public int calculateMax111(int[] prices) {
        if(prices==null||prices.length<2)
            return 0;
        int len=prices.length;
        int[] left=new int[len];
        left[0]=0;
        int min=prices[0];
        int max=0;
        for(int i=1;i<len;i++){
            if(prices[i]<min)
                min=prices[i];
            if(prices[i]-min>max)
                max=prices[i]-min;
            left[i]=max;
        }
        int[] right=new int[len];
        int high=prices[len-1];
        max=0;
        for(int i=len-2;i>=0;i--){
            if(prices[i]>high)
                high=prices[i];
            if(high-prices[i]>max)
                max=high-prices[i];
            right[i]=max;
        }
        int result=0;
        for(int i=0;i<len;i++){
            if(left[i]+right[i]>result)
                result=left[i]+right[i];
        }
        return result;
    }

}
