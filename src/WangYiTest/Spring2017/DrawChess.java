package WangYiTest.Spring2017;

import java.util.Scanner;

/**
 * Created by zhuhao on 17-8-17.
 * 小易有一块n*n的棋盘，棋盘的每一个格子都为黑色或者白色，小易现在要用他喜欢的红色去涂画棋盘。小易会找出棋盘中某一列中拥有相同颜色的最大的区域去涂画，帮助小易算算他会涂画多少个棋格。
 输入描述:
 输入数据包括n+1行：

 第一行为一个整数n(1 ≤ n ≤ 50),即棋盘的大小

 接下来的n行每行一个字符串表示第i行棋盘的颜色，'W'表示白色，'B'表示黑色


 输出描述:
 输出小易会涂画的区域大小

 输入例子1:
 3
 BWW
 BBB
 BWB

 输出例子1:
 3
 */
public class DrawChess {
    public static void main(String[] args) {
        Scanner sc= new Scanner ( System.in );
        while (sc.hasNext ()){
            int n = sc.nextInt ();
            sc.nextLine ();
            String[] init = new String[n];
            for (int i=0;i<n;i++)
                init[i] = sc.nextLine ();

            int max = 0;
            int maxB = 0,maxW = 0;
            char[][] chs = new char[n][n];
            for (int i=0;i<n;i++){
                chs[i] = init[i].toCharArray ();
            }

            for (int i=0;i<n;i++){
                int j=0;
                while (j<n){
                    maxB = maxW = 0;
                    while (j<n && chs[i][j] == 'B'){
                        maxB++;
                        j++;
                    }
                    while (j<n && chs[i][j] == 'W'){
                        maxW++;
                        j++;
                    }
                    int tmp = maxB > maxW?maxB:maxW;
                    if (tmp > max)
                        max = tmp;
                }

            }

            System.out.println (max);
        }
    }
}
