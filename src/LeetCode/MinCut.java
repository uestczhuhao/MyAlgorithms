package LeetCode;

import java.util.Arrays;

/**
 * Created by zhuhao on 17-5-19.
 *
 * Given a string s, partition s such that
 * every substring of the partition is a palindrome.
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * For example, given s ="aab",
 * Return1since the palindrome partitioning["aa","b"]could be
 * produced using 1 cut.
 */
public class MinCut {
    public int minCut(String s){
        if (s==null || s == "" || s.length ()==1)
            return 0;

        int min =0;
        int len = s.length ();
        char[] chs = s.toCharArray ();
        ////isPalin[i][j]表示字符串从i到j的字串是否是回文
        boolean[][] isPalin = new boolean[len][len];
        ///cuts[i]表示从i开始到最后一个字符，最少的切割次数
        int[] cuts = new int[len+1];
        for(int i=0;i<=len;i++)
            cuts[i] = len-i;

        /**
         * 当字符串[i,j]是回文后，说明从第i个位置到
         * 字符串第len位置的最小cut数可以被更新了，
         * 那么就是从j+1位置开始到第len位置的最小cut数
         * 加上[i,j]|[j+1,len - 1]中间的这一cut。
         * 即，Math.min(cuts[i], cuts[j+1]+1)
         * 最后返回cuts[0]-1。
         * 把多余加的那个对于第len位置的切割去掉，即为最终结果。
         */
        for(int i=len-1;i>=0;i--){
            for (int j=i;j<len;j++){
                char[] temp = new char[j-i+1];
                s.getChars ( i,j+1,temp,0 );
                if(isPalindrome ( temp )){
                    isPalin[i][j] = true;
                    cuts[i] = Math.min ( cuts[i],cuts[j+1]+1 );
                }
            }
            System.out.println ( Arrays.toString (cuts));
        }
        min = cuts[0]-1;

        return min;
    }

    public boolean isPalindrome(char[] s){
        if (s.length == 0) {
            return false;
        }
        if (s.length==1)
            return true;

        int len = s.length;
        for(int i=0;i<len;i++){
            int j = len-1-i;
            if(s[i] != s[j])
                return false;
        }
        return true;
    }
}
