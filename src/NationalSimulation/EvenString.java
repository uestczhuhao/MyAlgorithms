package NationalSimulation;

import java.util.Scanner;

/**
 * Created by zhuhao on 17-8-19.
 * 如果一个字符串由两个相同字符串连接而成,就称这个字符串是偶串。例如"xyzxyz"和"aaaaaa"是偶串,但是"ababab"和"xyzxy"却不是。
 牛牛现在给你一个只包含小写字母的偶串s,你可以从字符串s的末尾删除1和或者多个字符,保证删除之后的字符串还是一个偶串,牛牛想知道删除之后得到最长偶串长度是多少。
 输入描述:
 输入包括一个字符串s,字符串长度length(2 ≤ length ≤ 200),保证s是一个偶串且由小写字母构成


 输出描述:
 输出一个整数,表示删除之后能得到的最长偶串长度是多少。保证测试数据有非零解

 输入例子1:
 abaababaab

 输出例子1:
 6
 */
public class EvenString {
    public static void main(String[] args) {
        Scanner sc = new Scanner ( System.in );
        while (sc.hasNext ()) {
            String s = sc.next ();
            char[] chs = s.toCharArray ();
            int i;
            for (i=chs.length-3;i>=1;i-=2){
                if (isEvevString ( chs,0,i )){
                    break;
                }
            }
            System.out.println (i+1);
//            System.out.println (isEvevString ( chs,0,5 ));
        }
    }

    public static boolean isEvevString(char[] chs,int start,int end){
        if (start >= end || (chs.length%2)!=0)
            return false;
        int mid = (start+end)/2+1;
        for (int i=0;i<mid;i++){
            if (chs[i] != chs[i+mid])
                return false;
        }
        return true;
    }
}
