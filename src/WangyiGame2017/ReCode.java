package WangyiGame2017;

import java.util.Scanner;

/**
 * Created by zhuhao on 17-8-20.
 * 给定一个字符串，请你将字符串重新编码，将连续的字符替换成“连续出现的个数+字符”。比如字符串AAAABCCDAA会被编码成4A1B2C1D2A。
 输入描述:
 每个测试输入包含1个测试用例
 每个测试用例输入只有一行字符串，字符串只包括大写英文字母，长度不超过10000。


 输出描述:
 输出编码后的字符串

 输入例子1:
 AAAABCCDAA

 输出例子1:
 4A1B2C1D2A
 */
public class ReCode {
    public static void main(String[] args) {
        Scanner sc = new Scanner ( System.in );
            String str = sc.nextLine ();
            char[] chs = str.toCharArray ();
            int count = 1,i;
            StringBuilder strBul = new StringBuilder (  );
            for (i=1;i<chs.length;i++){
                if (chs[i] == chs[i-1])
                    count++;
                else {
                    strBul.append ( count );
                    strBul.append ( chs[i-1] );
                    count = 1;
                }
            }
            strBul.append ( count );
            strBul.append ( chs[i-1] );
            System.out.print (strBul.toString ());
    }
}
