public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String str1 = "1A2C3D4B56";
//        String str2 = "B1D23CA45B6A";
        String str2 = "333333D4";
        int n = str1.length();
        int m = str2.length();
        System.out.println(countLength(str1,str2,n,m));
    }

    //求str1和str2的公共子序列，并不一定要连续，如A1BC2和AB34C的最长公共子序列为ABC，长度为3。
    public static int countLength(String str1,String str2,int n,int m){
        //dp[i][j]代表str1[0...i]与str2[0...j]的最长公共子序列的长度
        int[] dp[] = new int[n][m];
        char[] chs1 = str1.toCharArray();
        char[] chs2 = str2.toCharArray();
        //初始化，如果str1的第i个字符和str2的第一个字符相等，则dp[i][0]=1
        //如果dp[i-1][0]=1，则dp[i][0]=1，如str1="ABCDE",str2="B"，
        // 则从dp[1][0]开始，两个字符串的最长公共子序列都为1
        dp[0][0] = chs1[0]==chs2[0]? 1:0;
        for (int i=1;i<n;i++){
            dp[i][0] = Math.max(dp[i-1][0],chs1[i]==chs2[0]? 1:0);
        }
        for (int j=1;j<m;j++)
            dp[0][j] = Math.max(dp[0][j-1],chs1[0]==chs2[j]? 1:0);

        /*
        其余位置的dp[i][j]，有三种情况：
        1.dp[i-1][j]，代表str1[0...i-1]和str2[0...j]的最长公共子序列，如A1BC2和AB34C。
          dp[3][4]位3，此时二者的公共子序列为ABC，而dp[4][4]也是3,
        2.可能是dp[i][j-1]，道理同上，str1和str2反一下
        3.如果str1[i]==str2[j]，还有可能是dp[i-1][j-1]+1，如ABCD和ABCD，当str1[3]==str2[3]
          此时dp[3][3]=dp[2][2]+1.
         */
        for (int i=1;i<n;i++){
            for (int j=1;j<m;j++){
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                if (chs1[i] == chs2[j]){
                    dp[i][j] = Math.max(dp[i][j],dp[i-1][j-1]+1);
                }
            }
        }

        return dp[n-1][m-1];
    }
}
