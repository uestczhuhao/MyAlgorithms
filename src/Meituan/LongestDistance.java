package Meituan;

/**
 * Created by zhuhao on 17-8-28.
 * 有一个长为n的数组A，求满足0≤a≤b<n的A[b]-A[a]的最大值。
 给定数组A及它的大小n，请返回最大差值。
 测试样例：
 [10,5],2
 返回：0
 */
public class LongestDistance {
    public static void main(String[] args) {
        int[] t = {5477,12458,4200,10290,7790,11432,10743};
        LongestDistance test= new LongestDistance ();
        System.out.println ( test.getDis (t,t.length));
    }

    public int getDis(int[] A, int n) {
        // write code here
        int[] dis = new int[n];
        int min = A[0];
        for (int i=1;i<n;i++){
            dis[i] = Math.max ( A[i]-min,dis[i-1] );
            min = Math.min ( min,A[i] );
        }

        return dis[n-1];
    }
}
