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
    public static void main(String[] args) {
        Visit v = new Visit ();
//        int[][] a = {{0,1,0},{2,0,0}};
        int[][] a = {{0,0,0,0,0},{0,0,0,0,0},{0,0,0,1,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,2}};

        System.out.println (v.countPath ( a,a.length,a[0].length ));

        System.out.println ("递归 "+aaaa);
//        boolean flag = false;
//        for (int i=0;i<4;i++){
//            for (int j=0;j<4;j++){
//                if (i == 2 && j==2){
//                    flag = true;
//                    break;
//                }
//                System.out.println (i+" "+j);
//            }
//            if (flag)
//                break;
//        }

    }

    public static int count = 0;
    public static int x=0,y=0;
    public static boolean Down=false,Up = false,Left =false,Right = false;

    public static int aaaa=0;
    public int countPath(int[][] map, int n, int m) {
        // write code here
        int[][] visited = new int[n][m];
        boolean flag = false;
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if (map[i][j] == 1){
                    x = i;
                    y = j;
                    flag = true;
                    break;
                }
            }
            if (flag)
                break;
        }
        Up = Left = true;
        countCore ( map,n,m,visited,x,y);
        Up = Left = false;
        Up = Right = true;
        countCore ( map,n,m,visited,x,y);
        Up = Right = false;
        Down = Left = true;
        countCore ( map,n,m,visited,x,y);
        Down = Left = false;
        Down = Right = true;
        countCore ( map,n,m,visited,x,y);
        return count;
    }

    public void countCore(int[][] map, int n, int m,int[][] visited,int currX,int currY) {
        if (currX >=n || currY >=m || currX<0 || currY<0)
            return;
        aaaa++;
        if (map[currX][currY] == 2){
            count++;
            return;
        }
        visited[currX][currY] = 1;
        if (currX+1 < n && visited[currX+1][currY]==0 && Down){
//            System.out.println ("Down");
            countCore ( map,n,m,visited,currX+1,currY ); //向下
        }

        if (currY+1 < m && visited[currX][currY+1]==0 && Right){
//            System.out.println ("Right");
            countCore ( map,n,m,visited,currX,currY+1 ); //向右
        }

        if (currX-1 >= 0 && visited[currX-1][currY]==0 && Up){
//            System.out.println ("Up");
            countCore ( map,n,m,visited,currX-1,currY ); //向上
        }

        if (currY-1 >= 0 && visited[currX][currY-1]==0 && Left){
//            System.out.println ("Left");
            countCore ( map,n,m,visited,currX,currY-1 ); //向左
        }
        visited[currX][currY] = 0;
    }
}
