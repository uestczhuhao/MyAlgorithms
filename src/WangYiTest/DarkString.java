package WangYiTest;

import java.util.Scanner;

/**
 * Created by zhuhao on 17-8-11.
 * 一个只包含'A'、'B'和'C'的字符串，如果存在某一段长度为3的连续子串中恰好'A'、'B'和'C'各有一个，那么这个字符串就是纯净的，否则这个字符串就是暗黑的。例如：
 BAACAACCBAAA 连续子串"CBA"中包含了'A','B','C'各一个，所以是纯净的字符串
 AABBCCAABB 不存在一个长度为3的连续子串包含'A','B','C',所以是暗黑的字符串
 你的任务就是计算出长度为n的字符串(只包含'A'、'B'和'C')，有多少个是暗黑的字符串。
 输入描述:

 输入一个整数n，表示字符串长度(1 ≤ n ≤ 30)


 输出描述:

 输出一个整数表示有多少个暗黑字符串
 示例1
 输入

 2
 3
 输出

 9
 21
 */
public class DarkString {
    /**
     * 利用f(n)和之前的状态的关系，假设f(n)=a*S(n-1)+b*D(n-1),a和b是常系数
     * 1.S(n-1)代表当字符串为n-1长度时最后两个字符串相同
     * 此时第n个字符加ABC都可以，共有3*S(n-1)
     *
     * 2.S(n-1)代表当字符串为n-1长度时最后两个字符串不相同
     * 此时比如有AB则只能加ABA，或者ABB，共有2*D(n-1)
     *
     * 则f(n)=3*S(n-1)+2*D(n-1)=2f(n-1) +S(n-2)
     *
     * 考虑S(n)，即为当字符串最后两位相同，此时一定为暗黑字符串，
     * 因此S(n)的数量一定等于当字符串为n-1时的暗黑串的数量，则S(n)=f(n-1)
     *
     * 所以最后 f(n) = 2*f(n-1) + f(n-2);
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner ( System.in );
        while (in.hasNextLine ()){
            int n = in.nextInt ();
            if (n<=0)
                return;
            long dp[] = new long[31];
            dp[1] = 3;
            dp[2] = 9;
            for (int i=3;i<=n;i++)
                dp[i] = 2*dp[i-1]+dp[i-2];
            System.out.println (dp[n]);
        }

        in.close ();
    }


}
