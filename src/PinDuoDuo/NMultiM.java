package PinDuoDuo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by zhuhao on 17-8-8.
 * 有两个用字符串表示的非常大的大整数,算出他们的乘积，也是用字符串表示。不能用系统自带的大整数类型。
 输入描述:
 空格分隔的两个字符串，代表输入的两个大整数

 输出描述:
 输入的乘积，用字符串表示

 输入例子1:
 72106547548473106236 982161082972751393

 输出例子1:
 70820244829634538040848656466105986748
 */
public class NMultiM {
    public static void main(String[] args) {
        Scanner in = new Scanner ( System.in );
        String n = in.next ();
        String m = in.next ();
        String result = multiBigNumber(m,n);
        System.out.println (result);
    }

    public static String multiBigNumber(String n,String m){
        if (n == null || m == null || n.length () == 0 || m.length () == 0)
            throw new Error ( "Invalid Input!!!" );

        char[] strsN = n.toCharArray ();
        char[] strsM = m.toCharArray ();
        int[] num1 = new int[n.length ()];
        int[] num2 = new int[m.length ()];

        for (int i=0;i<n.length ();i++)
            num1[i] = strsN[i]-'0';
        for (int i=0;i<m.length ();i++)
            num2[i] = strsM[i]-'0';

        num1 = reverse ( num1 );
        num2 = reverse ( num2 );
        String result = calCore ( num1,num2 );

        return result;
    }

    public static String calCore(int[] num1,int[] num2){
        int[] result = new int[num1.length + num2.length];
        for (int i=0;i<num1.length;i++){
            for (int j=0;j<num2.length;j++){
                int k=i+j;
                result[k] += num1[i]*num2[j];
                while (result[k] > 9){
                    result[k+1] += result[k]/10;
                    result[k] %= 10;
                    k++;
                }
            }

        }

        int i;
        StringBuilder strBul = new StringBuilder ( "" );
        for (i=result.length-1;i>=0;i--)
            if (result[i] != 0)
                break;
        for (;i>=0;i--)
            strBul.append ( result[i] );
        return strBul.toString ();
    }

    public static int[] reverse(int[] num){
        if (num == null ||num.length == 0)
            return null;

        int len = num.length;
        int[] result = new int[len];
        for (int i=0;i<len;i++)
            result[i] = num[len-1-i];

        return result;
    }
}


