package Qunaer;

import java.util.HashMap;

/**
 * Created by zhuhao on 17-8-28.
 *
 对于一个字符串，请设计一个高效算法，找到第一次重复出现的字符。
 给定一个字符串(不一定全为字母)A及它的长度n。请返回第一个重复出现的字符。保证字符串中有重复字符，字符串的长度小于等于500。

 */
public class FirstRepeat {
    public static void main(String[] args) {
        FirstRepeat t = new FirstRepeat ();
        String s = "qywyer23tdd";
//        String s = "kdbaaak";

        System.out.println (t.findFirstRepeat ( s,11 ));
    }
    public char findFirstRepeat(String A, int n) {
        // write code here
        HashMap<Character,Integer> map = new HashMap<> (  );
        char[] chs = A.toCharArray ();
        char res = 0;

        for (int i=0;i<n;i++){
            if (map.get ( chs[i] )==null){
                map.put ( chs[i],1 );
            } else {
                map.put ( chs[i],2 );
                res = chs[i];
                break;
            }
        }

        return res;
    }
}
