package WangYiTest.Spring2017;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by zhuhao on 17-8-17.
 * 小易拥有一个拥有魔力的手环上面有n个数字(构成一个环),当这个魔力手环每次使用魔力的时候就会发生一种奇特的变化：每个数字会变成自己跟后面一个数字的和(最后一个数字的后面一个数字是第一个),一旦某个位置的数字大于等于100就马上对100取模(比如某个位置变为103,就会自动变为3).现在给出这个魔力手环的构成，请你计算出使用k次魔力之后魔力手环的状态。
 输入描述:

 输入数据包括两行：
 第一行为两个整数n(2 ≤ n ≤ 50)和k(1 ≤ k ≤ 2000000000),以空格分隔
 第二行为魔力手环初始的n个数，以空格分隔。范围都在0至99.


 输出描述:

 输出魔力手环使用k次之后的状态，以空格分隔，行末无空格。
 示例1
 输入

 3 2
 1 2 3
 输出

 8 9 7
 */
public class MagicRoll {
    /**
     * 利用矩阵快速幂
     如输入A = [[1, 2, 3]], k = 2。
     我们可以构造一个这样的矩阵B（代码中的mul矩阵）[[1, 0, 1], [1, 1, 0], [0, 1,
     1]]，使得A*Bk相当于A转换k次后的样子。
     于是原问题就变成求矩阵快速幂。快速幂取余中，a
     k

     % c =  (a % c)k % c。
     类似问题：O(log(n))复杂度的Fibonacci数列，
     http://blog.csdn.net/dadoneo/article/details/6776272
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        //用一个二维数组存储
        int[][] arr= new int[1][n];
        for (int i = 0; i < n; i ++) {
            arr[0][i] = sc.nextInt();
        }
        //初始化单元矩阵
        int[][] mul = new int[n][n];
        for (int i = 0; i < n; i ++) {
            if (i < n - 1) {
                mul[i][i] = 1;
                mul[i + 1][i] = 1;
            } else {
                mul[i][i] = 1;
                mul[0][i] = 1;
            }
        }

        /**
         * 矩阵快速幂的核心部分
         * 二分搜索 与之本质 类似
         *
         * 即二分法求mul，如果是求4次的话，即为求2×2次
         */
        for (; k > 0; k >>= 1) {
            System.out.println (k);
            if ((k & 1) == 1) {
                arr = Core(arr, mul);
            }
            mul = Core(mul, mul);
        }

        /**
         * 输出结果
         */
        int i;
        for (i = 0; i < n - 1; i ++) {
            System.out.print(arr[0][i] + " ");
        }
        System.out.println(arr[0][i]);
    }

    /**
     * 矩阵相乘
     *  1. 矩阵a与b相乘， a的列数等于b的行数
     *  2. 结果矩阵的行等于a 的行数
     *  3.  结果矩阵的列等于b 的列数
     *
     * @param a 矩阵a
     * @param b 矩阵b
     * @return 返回结果矩阵
     */
    private static int[][] Core(int[][] a, int[][] b) {
        int rowRes = a.length;
        int columnRes = b[0].length;
        int columnA = a[0].length; // a[0].length == b.length; 即a的列数等于b的行数，矩阵相乘的条件

        int[][] c = new int[rowRes][columnRes];
        for (int i =0; i < rowRes; i ++) {
            for (int j = 0; j < columnRes; j ++) {

                for (int k = 0; k < columnA; k ++) {
                    if (a[i][k] == 0 || b[k][j] == 0) {
                        continue;          //剪枝
                    }

                    c[i][j] += a[i][k] * b[k][j];
                }
                //100取余运算
                if (c[i][j] >= 100) {
                    c[i][j] %= 100;
                }
            }
        }
        return c;
    }

}
