package LeetCode;

import java.util.ArrayList;
import java.util.Set;
import java.util.Arrays;

/**
 * Created by zhuhao on 17-5-15.
 * WordBreak
 * Given a string s and a dictionary of words dict,
 * determine if s can be segmented into a
 * space-separated sequence of one or more dictionary words.
 *  For example, given
 *  s ="leetcode",
 *  dict =["leet", "code"].
 *  Return true because"leetcode"can be segmented as"leet code".
 *
 */
public class WordBreak{

    public boolean wordBreak(String s, Set<String> dict) {
        ArrayList<String> result = new ArrayList<String>();
        if (s == null || dict.size() <= 0) {
            return false;
        }
        int length = s.length();
        // seg(i, j) means substring t start from i
        // and length is j can be segmented into dictionary words
        boolean[][] seg = new boolean[length][length + 1];
        for (int len = 1; len <= length; len++) {
            for (int i = 0; i < length - len + 1; i++) {
                //判断字符串从i开始，i+len结束的字串是否在dict中
                //若是，令seg[i][len] = true
                //否则，seg[i][j]=seg[i][k] && seg[i + k][len - k]
                String t = s.substring(i, i + len);
                if (dict.contains(t)) {
                    seg[i][len] = true;
                    continue;
                }
                //这个for循环完成的是拼接功能
                //例如：从i开始的3个字符的s的子串在dict中
                //同时从i+3开始的7个字符的s的子串也在dict中
                //那么就可以说从i开始的10个字符的子串在dict中
                for (int k = 1; k < len; k++) {
                    if (seg[i][k] && seg[i + k][len - k]) {
                        seg[i][len] = true;
                        break;
                    }
                }
            }
        }
        //下面的判断意味着dict中的组合要拼成原先的字符串，否则返回空
        if (!seg[0][length]) {
            return false;
        } else {
            return true;
        }
    }

    public ArrayList<String> wordBreakTwo(String s, Set<String> dict) {
        //dp[len]代表从字符串s的len-i到len的字符在dict中
        ArrayList<String>[] dp = new ArrayList[s.length() + 1];
        dp[0] = new ArrayList<String>();
        System.out.println (dp[0] == null);
        for (int i = 0; i < s.length(); i++) {
            if (dp[i] == null) continue;//必须保证前面已经匹配过了
            for (String word : dict) {
                int len = word.length();
                int end = i + len;
                //保证字串在字符串s的范围之内
                if (end > s.length()) continue;
                if (s.substring(i, end).equals(word)) {
                    if (dp[end] == null) {
                        dp[end] = new ArrayList<String>();
                    }
                    dp[end].add(word);
                }
            }
        }
        System.out.println (Arrays.toString ( dp ));
        ArrayList<String> ans = new ArrayList<String>();
        //最后还是要拼成原字符串,如果dp[s.length()] == null，
        // 则表面字符串s的最后没有与之匹配的dict
        if (dp[s.length()] == null) return ans;
        ArrayList<String> tmp = new ArrayList<String>();
        dfsSearch(dp, s.length(), ans, tmp);
        return ans;
    }

    private void dfsSearch(ArrayList<String>[] dp, int end, ArrayList<String> result, ArrayList<String> tmp) {
//        System.out.println ("The end now is "+end);
        if (end<=0){
            String ans=tmp.get(tmp.size()-1);
            for (int i = tmp.size()-2; i >=0 ; i--) {
                ans=ans+(" "+tmp.get(i));
            }
            result.add(ans);
            return;
        }
//        System.out.println ("The result now is "+result);
//        System.out.println ("The temp is "+tmp);
        for (String str:dp[end]){
            tmp.add(str);
            //为什么每次回退str.length()?
            //因为dp[end]位置上的单词只可能与dp[end-str.length()]
            //处的单词组成句子，例如dog只有和and或sand
            //因为在字符串s中它们是挨着的
            dfsSearch(dp,end-str.length(),result,tmp);
            tmp.remove(tmp.size()-1);
        }
    }

    public ArrayList<String> wordBreak2(String s, Set<String> dict) {
        //dp[len]代表从字符串s的len-i到len的字符在dict中
        ArrayList<String>[] dp = new ArrayList[s.length ()+1];
        dp[0] = new ArrayList<> (  );

        for(int i=0;i<s.length ();i++){
            //此处判断的理由是跳过中间状态，只关注需要的
            //例如有了cat，即dp[3]=cat，则只需关注i=3之后的即可
            if(dp[i] == null) {
                continue;//不是很懂这句
            }
            for(String word:dict){
                int len = word.length ();
                if (i+len >s.length ()) continue;
                if (s.substring ( i,i+len ).equals ( word )){
                    if(dp[i+len] == null)
                        dp[i+len] = new ArrayList<String> (  );
                    dp[i+len].add ( word );
                }
            }
        }
        System.out.println (Arrays.toString ( dp ));
        ArrayList<String> result = new ArrayList();
        if(dp[s.length ()] ==null) return result;

        ArrayList<String> tmp = new ArrayList(  );
        dfs(dp,s.length (),result,tmp);
        return  result;
    }

    private void dfs(ArrayList<String>[] dp, int end, ArrayList<String> result,ArrayList<String> tmp){
        if(end <=0 ){
            String res = tmp.get ( tmp.size ()-1 );
            for (int i = tmp.size()-2; i >=0 ; i--){
                res = res+" "+tmp.get ( i );
            }
            result.add ( res );
            return;
        }

        for(String word:dp[end]){
            tmp.add ( word );
            dfs ( dp,end-word.length (),result,tmp );
            tmp.remove ( tmp.size ()-1);
        }
    }
}
