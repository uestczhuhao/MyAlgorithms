package LeetCode;

import java.util.Arrays;
import java.util.HashMap;

public class _5LongestPalinSubstr {
    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];

        for (int i=0;i<dp.length;i++){
            dp[i][i]=true;
        }

        int x=0,y=0;
        int max = 0;
        //i要从后往前扫描，j从前往后扫描，dp[i][j] = true代表从i到j为回文
        //因为i,j处的数据要用到 i+1,j-1处的数据
        //因此二维矩阵要从下往上，从左往右建立
        for (int i=s.length()-1;i>=0;i--){
            for (int j=i;j<s.length();j++){
                if (s.charAt(j) == s.charAt(i) && (j-i<=2 || dp[i+1][j-1])) {
                    dp[i][j] = true;
                    if (max < j-i+1 ){
                        x = i;
                        y = j;
                        max = j-i+1;
                    }
                }

            }
        }


        for (int k=0;k<dp.length;k++)
            System.out.println(Arrays.toString(dp[k]));
        return s.substring(x,y+1);
//        return "";
    }


}
