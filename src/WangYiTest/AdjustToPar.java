package WangYiTest;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by zhuhao on 17-8-11.
 * 如果一个数字序列逆置之后跟原序列是一样的就称这样的数字序列为回文序列。例如：
 {1, 2, 1}, {15, 78, 78, 15} , {112} 是回文序列,
 {1, 2, 2}, {15, 78, 87, 51} ,{112, 2, 11} 不是回文序列。
 现在给出一个数字序列，允许使用一种转换操作：
 选择任意两个相邻的数，然后从序列移除这两个数，并用这两个数字的和插入到这两个数之前的位置(只插入一个和)。
 现在对于所给序列要求出最少需要多少次操作可以将其变成回文序列。

 输入描述:

 输入为两行，第一行为序列长度n ( 1 ≤ n ≤ 50)
 第二行为序列中的n个整数item[i]  (1 ≤ iteam[i] ≤ 1000)，以空格分隔。


 输出描述:

 输出一个数，表示最少需要的转换次数
 示例1
 输入

 4
 1 1 1 3
 输出

 2
 */
public class AdjustToPar {
    public static void main(String[] args) {
        Scanner in = new Scanner ( System.in );
        while (in.hasNextLine ()){
            int n = in.nextInt ();
            in.nextLine ();
            String str = in.nextLine ();
            String[] strs = str.split ( " " );

            if (n != strs.length)
                return;

            int[] ints = new int[n];
            for (int i=0;i<n;i++)
                ints[i] = Integer.parseInt ( strs[i] );

            int result = countCore ( n,ints );
            System.out.println ( result);
        }
//        int[] arr = {1,2};
//        System.out.println (isPar ( arr ));
    }

    private static int countCore(int n,int[] arr){
        int result = 0;
        if (isPar ( arr ))
            return 0;

        int head = 0,tail = arr.length-1;
        while (head < tail){
            if (arr[head] > arr[tail]){
                tail--;
                arr[tail] += arr[tail+1];
                result++;
            } else if (arr[head] < arr[tail]){
                head++;
                arr[head] += arr[head-1];
                result++;
            } else {
                head++;
                tail--;
            }

        }

        return result;
    }

    private static boolean isPar(int[] arr){
        if (arr == null || arr.length == 0)
            return false;
        for (int i=0;i<arr.length/2;i++){
            if (arr[i] != arr[arr.length-1-i]){
                return false;
            }
        }

        return true;
    }
}
