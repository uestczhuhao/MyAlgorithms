package WorkToOffer;

import java.util.Arrays;

/**
 * Created by zhuhao on 17-8-29.
 * 对一个字符串，切割几次就能保证切割出来的字符串都是回文串
 */
public class MinCut {
    public static void main(String[] args) {
        String str = "abcde";
        System.out.println (minCut ( str ));
        System.out.println (minCut1 ( str ));
    }


        /**
          * 回文的最小分割数
          * 1.dp[i]表示当前i到len-1这段的最小分割数
          * 2.dp[i]=min{dp[i],dp[j+1]+1}（i=<j<len）其中str[i..j]必须是回文、
          * 3.p[i][j]=true表示str[i..j]是回文
          * 4.p[i][j]=s.charAt(i)==s.charAt(j) && (j-i<2||p[i+1][j-1])
          */
    public static int minCut(String str){
        int[] dp = new int[str.length ()+1];
        boolean[][] p = new boolean[str.length ()][str.length ()];
        dp[str.length()]=-1;//确保dp[s.length()-1]=0
        for(int i=str.length()-1;i>=0;i--){
            dp[i]=Integer.MAX_VALUE;
            for(int j=i;j<str.length();j++){
                if(str.charAt(i)==str.charAt(j) && (j-i<2||p[i+1][j-1])){
                    p[i][j]=true;
                    dp[i]=Math.min(dp[i],dp[j+1]+1);
                }
            }
//            System.out.println ("dp = "+Arrays.toString ( dp ));
//
//            for (int k=0;k<str.length ();k++)
//                System.out.println ( Arrays.toString (p[k]));
//
//            System.out.println ();
//            System.out.println ();
        }
        return dp[0];
    }


    //dp[i]代表从i到n-1要切割的最小次数
    //isPar[i][j] 表示从i到j是否为回文序列，i<=j<n
    public static int minCut1(String str){
        int n = str.length ();
        int dp[] = new int[n+1];
        boolean isPar[][] = new boolean[n][n];
        dp[n] = -1;

        //i倒序，因为初始状态为dp[n-1]=0，依次从后往前计算
        for (int i=n-1;i>=0;i--){
            dp[i] = Integer.MAX_VALUE;
            for (int j=i;j<n;j++){
                if ((str.charAt ( i ) == str.charAt ( j )) && (j-i<2 || isPar[i+1][j-1])){
                    isPar[i][j] = true;
                    dp[i] = Math.min ( dp[i],dp[j+1]+1);
                }
            }
        }


        return dp[0];
    }
}
