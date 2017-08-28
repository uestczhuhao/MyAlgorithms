package Meituan;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by zhuhao on 17-8-28.
 * 在4x4的棋盘上摆满了黑白棋子，黑白两色的位置和数目随机其中左上角坐标为(1,1),右下角坐标为(4,4),现在依次有一些翻转操作，要对一些给定支点坐标为中心的上下左右四个棋子的颜色进行翻转，请计算出翻转后的棋盘颜色。
 给定两个数组A和f,分别为初始棋盘和翻转位置。其中翻转位置共有3个。请返回翻转后的棋盘。
 测试样例：
 [[0,0,1,1],[1,0,1,0],[0,1,1,0],[0,0,1,0]],[[2,2],[3,3],[4,4]]
 返回：[[0,1,1,1],[0,0,1,0],[0,1,1,0],[0,0,1,0]]
 */
public class Flip {
    public static void main(String[] args) {
        Flip f = new Flip ();
        int[][] a = {{0,1,0,0},{1,0,1,0},{1,1,0,0},{1,0,0,1}};
        int[][] b = {{2,3},{4,2},{2,3}};

        System.out.println ( Arrays.deepToString (f.flipChess ( a,b )));

    }

    public int[][] flipChess(int[][] A, int[][] f) {
        // write code here
        for (int i=0;i<3;i++) {
            int[] pos = f[i];
            int x = pos[0];
            int y = pos[1];
            if ( y>1 ){
                A[x - 1][y - 2] = 1 - A[x - 1][y - 2];  //左
            }
            if (y<4){
                A[x - 1][y] = 1 - A[x - 1][y];    //右
            }
            if(x>1){
                A[x - 2][y - 1] = 1 - A[x - 2][y - 1];    //上
            }
            if(x<4){
                A[x][y - 1] = 1 - A[x][y - 1];    //下
            }
        }
        return A;
    }
}
