package WangYiTest.AutumnOf2017;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 给定一个 n 行 m 列的地牢，其中 '.' 表示可以通行的位置，
 * 'X' 表示不可通行的障碍，牛牛从 (x0 , y0 ) 位置出发，遍历这个地牢，
 * 和一般的游戏所不同的是，他每一步只能按照一些指定的步长遍历地牢，
 * 要求每一步都不可以超过地牢的边界，也不能到达障碍上。
 *
 * 地牢的出口可能在任意某个可以通行的位置上。牛牛想知道最坏情况下，他需要多少步才可以离开这个地牢。


 输入描述:
 每个输入包含 1 个测试用例。每个测试用例的第一行包含
 两个整数 n 和 m（1 <= n, m <= 50），表示地牢的长和宽。

 接下来的 n 行，每行 m 个字符，描述地牢，地牢将至少包含两个 '.'。

 接下来的一行，包含两个整数 x0, y0，表示牛牛的出发位置（0 <= x0 < n, 0 <= y0 < m，
 左上角的坐标为 （0, 0），出发位置一定是 '.'）。
 之后的一行包含一个整数 k（0 < k <= 50）表示牛牛合法的步长数，

 接下来的 k 行，每行两个整数 dx, dy 表示每次可选择移动的行和列步长（-50 <= dx, dy <= 50）


 输出描述:
 输出一行一个数字表示最坏情况下需要多少次移动可以离开地牢，如果永远无法离开，输出 -1。

 以下测试用例中，牛牛可以上下左右移动，在所有可通行的位置上，地牢出口如果被设置在右下角，
 牛牛想离开需要移动的次数最多，为3次。
 示例1
 输入

 3 3
 ...
 ...
 ...
 0 1
 4
 1 0
 0 1
 -1 0
 0 -1
 输出

 3
 */
public class Escape {
    //A了90%，最后超时了。。。。
    public static int pathLength =0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            sc.nextLine();
            char[][] map = new char[n][m];

            int[][] countPath = new int[n][m];
            for (int i=0;i< n;i++){
                String st = sc.nextLine();
                map[i] = st.toCharArray();
            }
            int startX = sc.nextInt();
            int startY = sc.nextInt();

            int k = sc.nextInt();
            int[][] move = new int[k][2];
            for (int i=0;i<k;i++){
                move[i][0] = sc.nextInt();
                move[i][1] = sc.nextInt();
            }

            for (int i=0;i<n;i++){
                for (int j=0;j<m;j++){
                    if (!(i==startX && j==startY) && (map[i][j] == '.')){
                        int[][] visit = new int[n][m];
                        visit[startX][startY] = 1;
                        pathLength = Integer.MAX_VALUE;
                        findMaxPath(map,visit,move,startX,startY,i,j,0);
                        if (pathLength == Integer.MAX_VALUE){
                            countPath[i][j] = -1;
                        } else {

                            countPath[i][j] = pathLength;
                        }
                    }
                }
            }

            int max =0;
            for (int i=0;i<n;i++){
                for (int j=0;j<m;j++){
                    //按照题意 ，如果有位置不能离开，则判定不能离开
                    if (countPath[i][j] == -1){
                        System.out.println(-1);
                        return;
                    }
                    if (countPath[i][j] > max)
                        max = countPath[i][j];
                }
            }
            if (max <= 0){
                System.out.println(-1);
                return;
            }
            System.out.println(max);
//            System.out.println(Arrays.deepToString(map));
//            System.out.println(startX + " "+startY);
//            System.out.println(Arrays.deepToString(move));
        }
    }

    public static void findMaxPath(char[][] map,int[][] visit,int[][] move,int x,int y,int endX,int endY,int count){
        if (x == endX && y ==endY){
            if (count < pathLength)
                pathLength = count;
            return;
        }
        for (int i=0;i<move.length;i++){
            int moveToX = x + move[i][0];
            int moveToY = y + move[i][1];
            if (check(moveToX,moveToY,visit.length,visit[0].length) &&
                    map[moveToX][moveToY] == '.' && visit[moveToX][moveToY] == 0){
                count ++;
                visit[moveToX][moveToY] = 1;
                findMaxPath(map,visit,move,moveToX,moveToY,endX,endY,count);
                visit[moveToX][moveToY] = 0;
                count --;
            }
        }
    }

    public static boolean check(int x,int y,int n,int m){
        if (x >= 0 && x<n && y>=0 && y<m){
            return true;
        }
        return false;
    }
}
