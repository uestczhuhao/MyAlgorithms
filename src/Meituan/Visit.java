package Meituan;

/**
 * Created by zhuhao on 17-8-28.
 * 现在有一个城市销售经理，需要从公司出发，去拜访市内的商家，已知他的位置以及商家的位置，但是由于城市道路交通的原因，他只能在左右中选择一个方向，在上下中选择一个方向，现在问他有多少种方案到达商家地址。
 给定一个地图map及它的长宽n和m，其中1代表经理位置，2代表商家位置，-1代表不能经过的地区，0代表可以经过的地区，请返回方案数，保证一定存在合法路径。保证矩阵的长宽都小于等于10。
 测试样例：
 [[0,1,0],[2,0,0]],2,3
 返回：2
 */
public class Visit {
    /**
     * 链接：https://www.nowcoder.com/questionTerminal/12cbdcdf5d1e4059b6ddd420de6342b6
     来源：牛客网

     解题思路：
     1.首先找到1和2的位置，这里要注意一点，从1走到2与从2走到1所得的路径数相同，即以1为起点或以2为起点是等价的。所以我做的处理是，统一从行坐标小的位置走到行坐标大的位置，即向下走。
     2.1和2的相对位置可以归纳如下：
     （1）两者位于主对角线上
     （2）两者位于副对角线上
     （3）两者位置重合或处于同一行或同一列（该特殊情形可以合并到（1）（2）中）
     */
    public static int count = 0;
    public static int x1,y1,x2,y2;
    public int countPath(int[][] map, int n, int m) {
        // write code here
        int[][] visited = new int[n][m];
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if (map[i][j] == 1){
                    x1 = i;
                    y1 = j;
                } else if (map[i][j] ==2){
                    x2 = i;
                    y2 = j;
                }
            }
        }
        if (x1 == x2 && y1 == y2)
            return 1;

        if (x1>x2){
            int tmpX = x2,tmpY = y2;
            x2 = x1; y2 = y1;
            x1 = tmpX; y1 = tmpY;
        }
        int[][] dp = new int[n][m];
        int i,j;
        //y1<y2代表在主对角线上，只能往下和往右走
        //否则只能往下或往左走
        dp[x1][y1] = 1;
        for (i = x1+1; i<=x2; i++) {
            dp[i][y1] = map[i][y1]==-1?0:dp[i-1][y1];
        }
        if (y1<y2){
            for (j = y1+1; j <=y2; j++) {
                 dp[x1][j] = map[x1][j]==-1?0:dp[x1][j-1];
            }
            for (i = x1+1; i <= x2; i++) {
                for (j = y1+1; j <=y2; j++) {
                    dp[i][j] = map[i][j]==-1?0:dp[i-1][j]+dp[i][j-1];
                }
            }
        } else {
            for (j = y1-1; j >=y2; j--) {
                dp[x1][j] = map[x1][j]==-1?0:dp[x1][j+1];
            }
            for (i = x1+1; i <= x2; i++) {
                for (j = y1-1; j >=y2; j--) {
                    dp[i][j] = map[i][j]==-1?0:dp[i-1][j]+dp[i][j+1];
                }
            }
        }


        return dp[x2][y2];
    }

    public static void main(String[] args) {
        Visit v = new Visit ();
        int[][] a = {{0,0,0,0,0},{0,0,0,0,0},{0,0,0,1,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,2}};

        System.out.println (v.countPath ( a,a.length,a[0].length ));


    }
}
