package Didi;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by zhuhao on 17-8-24.
 */
public class Escape {
    public static ArrayList<Point> path = new ArrayList<> (  );
    public static ArrayList<Point> pathMin = new ArrayList<> (  );
    public static int minCost = Integer.MAX_VALUE,P;
    public static void main(String[] args) {
        Scanner sc = new Scanner ( System.in );
        while (sc.hasNext ()){
            int n = sc.nextInt ();
            int m = sc.nextInt ();
            int p = sc.nextInt ();
            P = p;
            int[][] maze = new int[n][m];
            for (int i=0;i<n;i++){
                for (int j=0;j<m;j++)
                    maze[i][j] = sc.nextInt ();
            }

            findPath ( maze,0,0,0 );

            if (minCost == Integer.MAX_VALUE)
                System.out.println ("Can not escape!");
            else{
                System.out.print ("[0,0]");
                for (int i=1;i<pathMin.size ();i++){
                    System.out.print (",["+pathMin.get ( i ).x+","+pathMin.get ( i ).y+"]");
                }
            }
        }
    }

    public static void findPath(int[][] maze,int x,int y,int cost){
        int n = maze.length;
        int m = maze[0].length;
        if (cost > P) return;
        maze[x][y] = 2;
        path.add ( new Point ( x,y ) );
        if (x == 0 && y == m-1){
            if (cost<minCost){
                minCost = cost;
                pathMin.clear ();
                pathMin.addAll ( path );
            }
            path.remove ( path.size ()-1 );
            maze[x][y] = 1;
            return;
        }

        if (x<n-1 && maze[x+1][y] == 1){  //下
            findPath ( maze,x+1,y,cost );
        }
        if (x>0 && maze[x-1][y] == 1){ //上
            findPath ( maze,x-1,y,cost+3 );
        }
        if (y<m-1 && maze[x][y+1] == 1){ //右
            findPath ( maze,x,y+1,cost+1 );
        }
        if (y>0 && maze[x][y-1] == 1) { //左
            findPath ( maze,x,y-1,cost+1 );
        }
        path.remove (  path.size ()-1  );
        maze[x][y] = 1;
    }

    public static class Point{
        int x;
        int y;
        public Point(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
}
