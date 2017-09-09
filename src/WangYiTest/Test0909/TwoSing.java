package WangYiTest.Test0909;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class TwoSing {
    static int maxn = 2000+5;
    static int[] v = new int[maxn];
    static int[][] dp = new int[maxn][maxn];
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            v[0] =-1;
            for (int i=0;i<n;i++)
                v[i] = sc.nextInt();

            for (int i=0;i<maxn;i++){
                for (int j=0;j<maxn;j++){
                    dp[i][j] = -1;
                }
            }
            solve(0,0);
        }
    }


   public static int solve(int la,int lb){
        int now = Math.max(la,lb)+1;
        if (now == n+1) return 0;
        if (dp[la][lb] != -1)
            return dp[la][lb];

        return dp[la][lb] = Math.min(solve(now,lb)+(la>0 ? Math.abs(v[now]-v[la]):0),
                solve(la,now)+(lb>0 ? Math.abs(v[now]-v[lb]):0));
   }

}
