package TouTiao;

import java.util.Scanner;

/**
 * Created by zhuhao on 17-8-22.
 * 我们规定对一个字符串的shift操作如下:

 shift("ABCD",0)="ABCD"
 shift("ABCD",1)="BCDA"
 shift("ABCD",2)="CDAB"
 换言之, 我们把最左侧的N个字符剪切下来, 按序附加到右侧.

 给定一个长度为n的字符串, 规定最多可以进行n次循环shift操作。
 如果shift(string, x) = string(0 <= x < n). 我们称其为一次匹配(match), 求shift过程中匹配的次数…

 输入描述
 输入仅包括一个输入的字符串, 字符串中仅有大小写字母

 输出描述
 输出仅包括一行, 即匹配的次数

 样例输入:

 byebyebye
 样例输出:

 3
 hint:
 30%的样例中输入字符串的长度<100,
 100%的样例中输入字符串的长度<10^6
 */
public class ShiftMatch {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        int n =str.length();

        int result=1;
        //String str1=str;
        int shift = 0;
        boolean t = false;
        for(int i=1;i<=n/2;i++){
            /*
            为何只有在n%i时才对其做比较？
            原因在于，字符串移动i位之后与原字符串相等，
            则再移动i（共移动2i）也相等，再移动i（共移动3i）也相等....
            直到移动n位，因为移动n位等效与移动0位，一定与原字符串相等，
            因此i一定是n的约数，一共移动了n/i次
             */
            if(n%i==0){
                String temp = shift(str,i);
                if(str.equals(temp)){
                    shift=i;
                    t= true;
                    break;
                }
            }
        }
        if(t){
            result=n/shift;
        }
        if(n==0)
            result=0;
        System.out.println(result);
    }


    private static String shift(String str ,int n){
        String str1 = str.substring(n)+str.substring(0,n);
        return str1;

    }
}
