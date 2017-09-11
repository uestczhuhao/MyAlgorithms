import java.util.Arrays;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
//        String str1 = "1A2C3D4B56";
////        String str2 = "B1D23CA45B6A";
//        String str2 = "333333D4";
//        int n = str1.length();
//        int m = str2.length();
//        System.out.println(countLength(str1,str2,n,m));

        String str1 = "abcde";
        String str2 = "bcdea";
        System.out.println(longestCommonSubString1(str1,str2));
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

    public static String longestCommonSubString(String str1,String str2){
        int[][] dp = getDpArray(str1,str2);
//        System.out.println(Arrays.deepToString(dp));
        int n = dp.length;
        int m = dp[0].length;
        int x=0,max=0;
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if (dp[i][j] > max){
                    max = dp[i][j];
                    x = i+1;
                }
            }
        }
        if (max ==0)
            return "";
        String result = str1.substring(x-max,x);
        return result;
    }

    /**
     * dp[i][j]的意思是，在必须把str1[i]和str2[j]当做最后公共子串的最后一个字符的情况下，
     * 公共子串能达到的最大长度有多长，例如str1="A1234B"，str2="CD1234"，
     * dp[3][4]的含义是必须把str1[3](3)和str2[4](3)作为公共子串的最后一个字符的情况下，公共子串的最长长度有多少。
     * 此时公共子串为"123"，所以dp[3][4]=3。
     * 由此可知，如果str1[i] != str2[j]时，dp[i][j]=0
     */
    public static int[][] getDpArray(String str1,String str2){
        int n= str1.length();
        int m= str2.length();
        int[][] dp = new int[n][m];
        char[] chs1 = str1.toCharArray();
        char[] chs2 = str2.toCharArray();

        //初始化dp第一列
        for (int i=0;i<n;i++){
            if (chs1[i] == chs2[0]){
                dp[i][0] = 1;
            } else
                dp[i][0] = 0;
        }

        //初始化第一行
        for (int j=0;j<m;j++){
            if (chs2[j] == chs1[0])
                dp[0][j] = 1;
            else
                dp[0][j] = 0;
        }

        //其他位置从左到右，从上到下计算，dp[i][j]的值只可能有下面两种情况
        //1. 若str1[i] != str1[j]，证明把str1[i]和str2[j]当做公共子串的最后一个字符串是行不通的，dp[i][j]=0
        //2. 若str1[i] != str1[j]，则其值跟dp[i-1][j-1]有关，为dp[i][j]=dp[i-1][j-1]+1
        for (int i=1;i<n;i++){
            for (int j=1;j<m;j++){
                if (chs1[i] == chs2[j])
                    dp[i][j] = dp[i-1][j-1]+1;
            }
        }
        return dp;
    }

    //把空间复杂度优化到O(1)，因为dp[i][j]只和dp[i-1][j-1]有关，因此可以按照对角线求值，找出最长子串
    /*
      1  2  3  4
      5  6  7  8
      a  b  c  d
      e  f  g  h
      如上面的矩阵，先从最左下角的矩阵，即e
      然后往上走，a-f   之后是5-b-g   之后是1-6-c-h
      然后是2-7-d   3-8   4
      遍历的过程中记录最大值max和此时的下标i值end，
      所求的最大子串即为str1[end-max,end]
     */
    public static String longestCommonSubString1(String str1,String str2){
        char[] chs1 = str1.toCharArray();
        char[] chs2 = str2.toCharArray();
        int max = 0,end = 0;
        int row = str1.length()-1,col = 0;
        while (col < str2.length()){
            int i=row,j=col;
            int len = 0;
            //从i,j开始向下遍历
            while (i<chs1.length && j< chs2.length){
                if (chs1[i] == chs2[j])
                    len++;
                else
                    len = 0;
                if (len >max){
                    max = len;
                    end = i+1;
                }
                i++;j++;
            }
            if (row>0){
                row --;
            } else {
                col ++;
            }
        }
        return str1.substring(end-max,end);
    }
}
