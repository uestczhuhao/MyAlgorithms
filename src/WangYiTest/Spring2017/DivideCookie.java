package WangYiTest.Spring2017;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by zhuhao on 17-8-18.
 */
public class DivideCookie {
    /*

    dp：状态转移方程dp[i][newJ] += dp[i-1][J].
    其中i代表数字串的长度，J代表余数，结果值代表i长度的数字串中求余n余J的所有可能结果总数
    根据以上的说明，显而易见newJ==(J*10+k)%n ，k代表当前数字串中个位的值（也就是数字串的第i位）
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner ( System.in );
        while (sc.hasNext ()){
            String str= sc.next ();
            int n = sc.nextInt ();

            long[][] dp = new long[str.length ()+1][n];
            //优化：由于求dp[i]只需要用到dp[i-1]，因此可以把dp设置成一维数组
            //long[] dp = new long[n];

            //要求最少有一种，即为0时也算平分
            dp[0][0] = 1;
            /*
            dp[i][newJ] = dp[i-1][j], s[i] != 'X', newJ = (j*10+s[i]-'0')%n;
            dp[i-1][j], s[i] == 'X', newJ = (j*10+k)%n, k=0~9
             */
            for(int i = 1;i<=str.length();i++){
                char c = str.charAt(i-1);
                for(int j = 0;j<n;j++){
                    for(int k = 0;k<10;k++){
                        if(c=='X'||c=='0'+k){
                            System.out.println ("c = "+c);
                            dp[i][(j*10+k)%n]+=dp[i-1][j];
                        }
                    }
                }
                System.out.println ( Arrays.deepToString ( dp));
            }
            System.out.println(dp[str.length()][0]);
        }
    }
}
