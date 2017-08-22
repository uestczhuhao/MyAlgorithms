package WangyiGame2017;

import java.util.Scanner;

/**
 * Created by zhuhao on 17-8-20.
 * 在一个N*N的数组中寻找所有横，竖，左上到右下，右上到左下，四种方向的直线连续D个数字的和里面最大的值
 输入描述:
 每个测试输入包含1个测试用例，第一行包括两个整数 N 和 D :
 3 <= N <= 100
 1 <= D <= N
 接下来有N行，每行N个数字d:
 0 <= d <= 100


 输出描述:
 输出一个整数，表示找到的和的最大值

 输入例子1:
 4 2
 87 98 79 61
 10 27 95 70
 20 64 73 29
 71 65 15 0

 输出例子1:
 193
 */
public class MaxSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner ( System.in );
        while (sc.hasNext ()){
            int n = sc.nextInt ();
            int d = sc.nextInt ();
            int[][] input = new int[n][n];
            for (int i=0;i<n;i++){
                for (int j=0;j<n;j++){
                    input[i][j] = sc.nextInt ();
                }
            }

            int sum = 0;
            for (int i=0;i<n;i++){
                for (int j=0;j<n;j++){
                    int sumRow=0,sumCol=0,sumDia=0,sumDia1=0;
                    for (int k=0;k<d;k++){
                        if (i+d<=n){
                            sumRow += input[i+k][j];
                            sum = Math.max ( sum,sumRow );
                        }
                        if (j+d<=n){
                            sumCol += input[i][j+k];
                            sum = Math.max ( sum,sumCol );
                        }
                        if (i+d<=n && j+d<=n){
                            sumDia += input[i+k][j+k];
                            sumDia1 +=  input[i+d-k-1][j+k];
                            sum = Math.max ( sum,sumDia );
                            sum = Math.max ( sum,sumDia1 );
                        }
                    }
                }
            }

            System.out.println (sum);
        }
    }
}
