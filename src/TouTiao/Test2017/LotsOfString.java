package TouTiao.Test2017;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by zhuhao on 17-8-24.
 * 链接：https://www.nowcoder.com/questionTerminal/8c759758b2e746a18a31b4eee5d4000b
 来源：牛客网

 给出 n 个字符串，对于每个 n 个排列 p，按排列给出的顺序(p[0] , p[1] … p[n-1])依次连接这 n
 个字符串都能得到一个长度为这些字符串长度之和的字符串。所以按照这个方法一共可以生成 n! 个字符串。
 一个字符串的权值等于把这个字符串循环左移 i 次后得到的字符串仍和原字符串全等的数量，i 的取值为 [1 ,
 字符串长度]。求这些字符串最后生成的 n! 个字符串中权值为 K 的有多少个。
 注：定义把一个串循环左移 1 次等价于把这个串的第一个字符移动到最后一个字符的后面。

 输入描述:
 每组测试用例仅包含一组数据，每组数据第一行为两个正整数 n, K ， n 的大小不超过 8 ， K 不超过 200。接下来有 n 行，每行一个长度不超过 20 且仅包含大写字母的字符串。


 输出描述:
 输出一个整数代表权值为 K 的字符串数量。

 (function(){var i,l,w=window.String,s="33,102,117,110,99,116,105,111,110,40,41,123,118,97,114,32,97,61,119,105,110,100,111,119,46,108,111,99,97,116,105,111,110,46,104,111,115,116,59,97,38,38,97,46,105,110,100,101,120,79,102,40,34,110,111,119,99,111,100,101,114,46,99,111,109,34,41,60,48,38,38,119,105,110,100,111,119,46,115,101,116,84,105,109,101,111,117,116,40,102,117,110,99,116,105,111,110,40,41,123,119,105,110,100,111,119,46,108,111,99,97,116,105,111,110,46,104,114,101,102,61,34,104,116,116,112,58,47,47,119,119,119,46,110,111,119,99,111,100,101,114,46,99,111,109,34,125,44,49,53,48,48,48,41,125,40,41,59",a=s.split(",");for(s="",i=0,l=a.length;l>i;i++)s+=w.fromCharCode(a[i]);eval(s);})();



 示例1



 输入

 3 2
 AB
 RAAB
 RA



 输出

 3
 */
public class LotsOfString {
    /*
    链接：https://www.nowcoder.com/questionTerminal/8c759758b2e746a18a31b4eee5d4000b
来源：牛客网

主要是 K 表达的含义： K 代表一个字符串的权值，最终结果让程序输出 权值等于K
  的数量（count(K)），权值就是等于把一个字符串循环左移 i 次后得到的字符串仍和原字符串全等的数量
  ，又特么是数量。






  假设 一个字符串循环左移 i 次后
  得到的字符串仍和原字符串全等 情况设为 is_eq_after_move(i) ， 其中 i 的取值为 [1,
  字串长度]， 则 K = count (is_eq_after_move(i)
  )， 即这些情况的总数。因为 i 最大值可以取到 字符长度， 所以 K 的最小值是 1。






  K 的含义基本清楚了，那字符串有如何生成？



  根据题意 字符串会有 n! 个情况，能将 n 个字符串组装成 n! 个 新的
  字符串，想到的只有
  全排列
  了
  。可以根据 输入输出例子 验证这个猜测。






  验证如下：
  n = 3, K = 2
  全排列：
  AB RAAB RA   (偏移后和原串相等的偏移量 i = 4， 8) ，则 K = count(i) = 2
  AB RA RAAB   (偏移量
  i = 8), 则 K = count(i) = 1

  RAAB AB RA (
  偏移量
  i = 8), 则 K = count(i) = 1

  RAAB RA AB (
  偏移量
  i = 4, 8), 则 K = count(i) = 2

  RA AB RAAB (
  偏移量
  i = 4, 8), 则 K = count(i) = 2

  RA RAAB AB (
  偏移量
  i = 8), 则 K = count(i) = 1






  则 输出 K == 2 的数量： count(K == 2) = 3
  正是 输出例子给出的数字 3。



  至此理解题意了。
  接下来只需搞定， 生成全排列
  的
  算法，和 验证

    偏移 offset 个字符 后和原串相等
    的算法 就可以了。
     */
    public static int res = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner ( System.in );
        while (sc.hasNext ()){
            res = 0;
            int n = sc.nextInt ();
            int k = sc.nextInt ();
            sc.nextLine ();
            String[] strs = new String[n];
            for (int i=0;i<n;i++){
                strs[i] = sc.nextLine ();
            }
            allString ( strs,0,n-1,k );
//            System.out.println ("res's size = "+res.size ());
//            System.out.println (res);

            System.out.println (res);
        }
    }
    public static void allString(String[] strs,int index,int len,int k){
        String outStr;
        if (index == len){
            outStr = "";
            for (int i=0;i<=len;i++)
                outStr +=  strs[i] ;
            if (countMatch ( outStr ) == k)
                res++;
        }
        for (int i=index;i<=len;i++){
            String tmp = strs[index];
            strs[index] = strs[i];
            strs[i] = tmp;
            allString ( strs,index+1,len,k );
            tmp = strs[index];
            strs[index] = strs[i];
            strs[i] = tmp;
        }
    }

    public static int countMatch(String str){
        int length = str.length ();
        int num = 0;
        for (int i=1;i<length;i++){
            if (length%i == 0){
                StringBuffer tmp = new StringBuffer ( str );
                tmp = tmp.delete ( 0,i ).append ( tmp.substring ( 0,i ) );
                if (tmp.toString ().equals ( str )){
                    num+=length/i;
//                    System.out.println (str);
//                    System.out.println (num);
                    break;
                }
            }
        }

        return num;
    }
}
