package Didi;

import java.util.Scanner;

/**
 * Created by zhuhao on 17-8-24.
 *
 给定一个十进制数M，以及需要转换的进制数N。将十进制数M转化为N进制数
 输入描述:
 输入为一行，M(32位整数)、N(2 ≤ N ≤ 16)，以空格隔开。
 输出描述:
 为每个测试实例输出转换后的数，每个输出占一行。如果N大于9，则对应的数字规则参考16进制（比如，10用A表示，等等）
 示例1
 输入

 7 2
 输出

 111
 */
public class DecToN {
    public static void main(String[] args) {
        Scanner sc = new Scanner ( System.in );
        while(sc.hasNext ()){
            int m = sc.nextInt ();
            int n = sc.nextInt ();
            boolean isPositive = true;
            if (m<0){
                isPositive = false;
                m = -m;
            }
            String str = "0123456789ABCDEF";
            char[] table = str.toCharArray ();
            StringBuffer changeTo = new StringBuffer (  );
            while (m>0){
                int index= m%n;
                changeTo.append ( table[index] );
                m = m/n;
            }
            if (isPositive)
                System.out.println (changeTo.reverse ().toString ());
            else
                System.out.println ("-"+changeTo.reverse ().toString ());
        }
    }
}
