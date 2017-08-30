package Meituan;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by zhuhao on 17-8-30.
 * 求字典序在s1和s2之间的，长度在len1到len2的字符串的个数，结果mod 1000007。
 输入描述:
 每组数据包涵s1（长度小于100），s2（长度小于100），len1（小于100000），len2（大于len1，小于100000）
 输出描述:
 输出答案。
 示例1
 输入

 ab ce 1 2
 输出

 56
 */
public class CountString {
    //mabfbemlnffphefbbcahkfknlroaprchrnosaqankcnmi mabfbemlnffphefbbcahkfknlroaprchrnosaqanlgtqj 45 45
    public static void main(String[] args) {
        Scanner sc = new Scanner ( System.in );
        while (sc.hasNext ()){
            //只包含小写字母的字符串可以看成26进制的数制
            //将s1和s2补长到len2长度
            String s1 = sc.next ();
            String s2 = sc.next ();
            int len1 = sc.nextInt ();
            int len2 = sc.nextInt ();
            long result = 0;
            char[] chs1 = s1.toCharArray ();
            char[] chs2 = s2.toCharArray ();

            for (int i=len1;i<=len2;i++){
                long sum1 = 0;
                long sum2 = 0;
                for (int j=0;j<s1.length ();j++){
                    sum1 += (chs1[j]-'a')*(long)Math.pow ( 26,i-j-1 );
                }
                for (int j=0;j<s2.length ();j++){
                    sum2 += (chs2[j]-'a')*(long)Math.pow ( 26,i-j-1 );
                }

                result += sum2-sum1;
                if (result >=1000007)
                    result %= 1000007;
            }
            System.out.println (result-1);
        }
    }

//    public static void main(String[] args) {
//        System.out.println (Math.pow ( 26,45 ));
//        System.out.println ((long) Math.pow ( 26,45 ));
//    }


}
