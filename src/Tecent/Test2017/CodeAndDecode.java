package Tecent.Test2017;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by zhuhao on 17-8-30.
 * 假定一种编码的编码范围是a ~ y的25个字母，从1位到4位的编码，如果我们把该编码按字典序排序，形成一个数组如下： a, aa, aaa, aaaa, aaab, aaac, … …, b, ba, baa, baaa, baab, baac … …, yyyw, yyyx, yyyy 其中a的Index为0，aa的Index为1，aaa的Index为2，以此类推。 编写一个函数，输入是任意一个编码，输出这个编码对应的Index.
 输入描述:
 输入一个待编码的字符串,字符串长度小于等于100.
 输出描述:
 输出这个编码的index
 示例1
 输入

 baca
 输出

 16331
 */
public class CodeAndDecode {
    public static void main(String[] args) {
        Scanner sc = new Scanner ( System.in );
        while (sc.hasNext ()){
            String str = sc.nextLine ();
            char[] chs = str.toCharArray ();
            long result =0;
            for (int i=0;i<4 && i<chs.length;i++){
                for (int j=0;j< 4-i;j++){
                    if (chs[i] != 'a'){
                        result += (chs[i]-'a')*(long)Math.pow ( 25,j );
                    }

                }
            }
            result +=3;
            if (allEqual(chs))
                result -= (4-chs.length);
            System.out.println (result);
        }
    }
    private static boolean allEqual(char[] chs){
        char tmp = chs[0];
        for (int i=1;i<chs.length;i++){
            if (chs[i] != tmp)
                return false;
        }

        return true;
    }

}
