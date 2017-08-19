package BaiDu;

import java.util.Scanner;

/**
 * Created by zhuhao on 17-8-19.
 * 一个数轴上共有N个点，第一个点的坐标是度度熊现在位置，第N-1个点是度度熊的家。现在他需要依次的从0号坐标走到N-1号坐标。
 但是除了0号坐标和N-1号坐标，他可以在其余的N-2个坐标中选出一个点，并直接将这个点忽略掉，问度度熊回家至少走多少距离？
 输入描述:
 输入一个正整数N, N <= 50。

 接下来N个整数表示坐标，正数表示X轴的正方向，负数表示X轴的负方向。绝对值小于等于100


 输出描述:
 输出一个整数表示度度熊最少需要走的距离。

 输入例子1:
 4
 1 4 -1 3

 输出例子1:
 4
 */
public class MinDistance {
    public static void main(String[] args) {
        Scanner sc = new Scanner ( System.in );
        while (sc.hasNext ()){
            int n = sc.nextInt ();
            int[] locate = new int[n];
            int sum = 0;
            for (int i=0;i<n;i++){
                locate[i] = sc.nextInt ();
                if (i>0)
                    sum += Math.abs ( locate[i]-locate[i-1] );
            }
//            System.out.println (sum);
            if (n == 2)
                System.out.println (sum);
            int min = Integer.MAX_VALUE;
            for (int i=1;i<n-1;i++){
                int old1 = Math.abs ( locate[i]-locate[i-1] );
                int old2 = Math.abs ( locate[i+1]-locate[i] );
                int new1 = Math.abs ( locate[i+1]-locate[i-1] );
                int tmp = sum -old1 - old2 +new1;
                if (tmp < min)
                    min = tmp;
            }
            System.out.println (min);
        }
    }
}
