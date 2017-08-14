package WangYiTest.WangYi0812;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by zhuhao on 17-8-14.
 * 小易有一个长度为n的整数序列,a_1,...,a_n。然后考虑在一个空序列b上进行n次以下操作:
 1、将a_i放入b序列的末尾
 2、逆置b序列
 小易需要你计算输出操作n次之后的b序列。
 输入描述:
 输入包括两行,第一行包括一个整数n(2 ≤ n ≤ 2*10^5),即序列的长度。
 第二行包括n个整数a_i(1 ≤ a_i ≤ 10^9),即序列a中的每个整数,以空格分割。


 输出描述:
 在一行中输出操作n次之后的b序列,以空格分割,行末无空格。

 输入例子1:
 4
 1 2 3 4

 输出例子1:
 4 2 1 3
 */
public class InsertAndReverse {
    public static void main(String[] args) {
        Scanner in = new Scanner ( System.in );
        int n = in.nextInt ();
        int[] arr1 = new int[n];
        for (int i=0;i<n;i++){

            int tmp;
            ///根据公式推断出经过n次变动后的每个数最后的位置
            if ((n-i)%2 !=0){
                tmp = (n-i)/2;
            }
            else{
                tmp = i+(n-i)/2;
            }
            arr1[tmp] = in.nextInt ();
        }
        System.out.print (arr1[0]);
        for (int i=1;i<arr1.length;i++)
            System.out.print (" "+arr1[i]);
    }

}
