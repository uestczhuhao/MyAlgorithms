package WangYiTest.Test0909;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 有一个数组，如[1,5,6,2,1]，要把它拆成[5,6]和[1,2,1]
 * 这样才能保证两个数组的差值的绝对值之和最小，上诉例子为3
 */
public class TwoSing {
    static int maxn = 2000 + 5;
    static int[] v = new int[maxn];
    static int[][] dp = new int[maxn][maxn];
    static int n;

    public static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    public static int min(int a, int b) {
        return (a < b) ? a : b;
    }

    /**
     * dp[i][j]表示小Q上一个演唱的音符是v[i],牛博士上一个演唱的音符是v[j]的最小难度和。
     * 记忆化搜索一下就好了。
     * @return
     */
    public static int solve(int la,int lb){

        int now = max(la, lb) + 1;
        if(now == n + 1) return 0;
        if(dp[la][lb] != -1) return dp[la][lb];
        return dp[la][lb] = min(solve(now, lb) + (la>0 ? Math.abs(v[now] - v[la]) : 0), solve(la, now) + (lb>0 ? Math.abs(v[now] - v[lb]) : 0));
    }

        public static void main(String[] args) {

            Scanner cin = new Scanner(System.in);
            n = cin.nextInt();
            v[0] = -1;
            for(int i = 1; i <= n; i++) v[i] = cin.nextInt();

            for (int i = 0; i < maxn; i ++)
                for (int j = 0; j < maxn; j ++)
                    dp[i][j] = -1;

            System.out.println(solve(0,0));
            for (int i=0;i<5;i++){

                for (int j=0;j<5;j++){
                    System.out.print(dp[i][j]+" ");
                }
                System.out.println();
            }
        }

}
