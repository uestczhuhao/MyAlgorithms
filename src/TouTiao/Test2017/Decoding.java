package TouTiao.Test2017;

import java.util.Scanner;

/**
 * Created by zhuhao on 17-8-23.
 * 链接：https://www.nowcoder.com/questionTerminal/17517002460f453eb97a73439fc10ec8
 来源：牛客网

 现在有一个字符串，你要对这个字符串进行 n 次操作，每次操作给出两个数字：(p, l) 表示当前字符串中从下标为 p
 的字符开始的长度为   l 的一个子串。你要将这个子串左右翻转后插在这个子串原来位置的正后方，求最后得到的字符串是什么。字符串的下标是从 0
 开始的，你可以从样例中得到更多信息。

 输入描述:
 每组测试用例仅包含一组数据，每组数据第一行为原字符串，长度不超过 10 ，仅包含大小写字符与数字。接下来会有一个数字 n 表示有 n 个操作，再接下来有 n 行，每行两个整数，表示每次操作的(p , l)。

 保证输入的操作一定合法，最后得到的字符串长度不超过 1000。


 输出描述:
 输出一个字符串代表最后得到的字符串。

 (function(){var i,l,w=window.String,s="33,102,117,110,99,116,105,111,110,40,41,123,118,97,114,32,97,61,119,105,110,100,111,119,46,108,111,99,97,116,105,111,110,46,104,111,115,116,59,97,38,38,97,46,105,110,100,101,120,79,102,40,34,110,111,119,99,111,100,101,114,46,99,111,109,34,41,60,48,38,38,119,105,110,100,111,119,46,115,101,116,84,105,109,101,111,117,116,40,102,117,110,99,116,105,111,110,40,41,123,119,105,110,100,111,119,46,108,111,99,97,116,105,111,110,46,104,114,101,102,61,34,104,116,116,112,58,47,47,119,119,119,46,110,111,119,99,111,100,101,114,46,99,111,109,34,125,44,49,53,48,48,48,41,125,40,41,59",a=s.split(",");for(s="",i=0,l=a.length;l>i;i++)s+=w.fromCharCode(a[i]);eval(s);})();



 示例1



 输入

 ab
 2
 0 2
 1 3



 输出

 abbaabb
 */
public class Decoding {
    public static void main(String[] args) {
        Scanner sc = new Scanner ( System.in );
        while (sc.hasNext ()){
            String str = sc.nextLine ();
            int n = sc.nextInt ();
            int[] p =new int[n];
            int[] l =new int[n];
            for (int i=0;i<n;i++){
                p[i] = sc.nextInt ();
                l[i] = sc.nextInt ();
            }
            String re = reverseAppend ( str,p,l );
            System.out.println (re);
        }
    }

    public static String reverseAppend(String str,int[] p,int[] l){
        StringBuffer result = new StringBuffer ( str );
        for (int i=0;i<p.length;i++){
            StringBuffer tmp = new StringBuffer ( result.substring ( p[i],p[i]+l[i] ) );
            tmp = tmp.reverse ();
            result.insert ( p[i]+l[i],tmp.toString () );
        }

        return result.toString ();
    }
}
