package ZhongGuoDianxin;

import java.util.Scanner;

/**

 数组中的数分为两组，给出一个算法，使得两个组的和的差的绝对值最小。

 数组中的数的取值范围是0<x<100，元素个数也是大于0，小于100
 比如a[]={2,4,5,6,7},得出的两组数{2，4,6}和{5，7}，
 abs(sum(a1)-sum(a2))=0;

 比如{2，5，6，10}，abs(sum(2,10)-sum(5,6))=1,
 所以得出的两组数分别为{2，10}和{5,，6}。
 */
public class DivideMid {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i=0;i<n;i++)
                arr[i] = sc.nextInt();
            System.out.println(getMaxDif(arr));

        }
    }

    public static int getMaxDif(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        int length = array.length;
        /*dp[i][j]表示前i件物品中，总和最接近j的所有物品的总和，其中包括两种情况：

        1. 如果第i件物品没有包括在其中，则dp[i][j] = dp[i-1][j]
        2. 如果第i件物品包括在其中，则dp[i][j] = dp[i-1][j-array[i]]+array[i]
        */
        int[][] f = new int[length + 1][sum / 2 + 1];
        for (int i = 0; i < length; i++) {
            for (int j = 1; j <= sum / 2; j++) {
                f[i + 1][j] = f[i][j];
                if (array[i] <= j && f[i][j - array[i]] + array[i] > f[i][j]) {
                    f[i + 1][j] = f[i][j - array[i]] + array[i];
                }
            }
        }
        return sum - 2 * f[length][sum / 2];
    }

}