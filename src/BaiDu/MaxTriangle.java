package BaiDu;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by zhuhao on 17-8-19.
 * 三维空间中有N个点，每个点可能是三种颜色的其中之一，三种颜色分别是红绿蓝，分别用'R', 'G', 'B'表示。
 现在要找出三个点，并组成一个三角形，使得这个三角形的面积最大。
 但是三角形必须满足：三个点的颜色要么全部相同，要么全部不同。
 输入描述:

 首先输入一个正整数N三维坐标系内的点的个数.(N <= 50)

 接下来N行，每一行输入 c x y z，c为'R', 'G', 'B' 的其中一个。x，y，z是该点的坐标。(坐标均是0到999之间的整数)


 输出描述:

 输出一个数表示最大的三角形面积，保留5位小数。
 示例1
 输入

 5
 R 0 0 0
 R 0 4 0
 R 0 0 3
 G 92 14 7
 G 12 16 8
 输出

 6.00000
 */
public class MaxTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner ( System.in );
        while (sc.hasNext ()){
            int n = sc.nextInt ();
            String[] input = new String[n];
            char[] c = new char[n];
            int[] x = new int[n];
            int[] y = new int[n];
            int[] z = new int[n];
            sc.nextLine ();
            for (int i=0;i<n;i++){
                String tmp =sc.nextLine ();
                input[i] = tmp;
                String[] strs = tmp.split ( " " );
                c[i] = strs[0].charAt ( 0 );
                x[i] = Integer.parseInt ( strs[1] );
                y[i] = Integer.parseInt ( strs[2] );
                z[i] = Integer.parseInt ( strs[3] );
            }
            double maxArea = 0;
            for (int i=0;i<n;i++){
                for (int j=0;j<n;j++){
                    for (int k=0;k<n;k++){
                        if ((c[i] == c[j] && c[i] == c[k]) ||
                                (c[i]!=c[j] && c[i]!=c[k] && c[j]!=c[k])){
                            double area = countArea(x[i],y[i],z[i],x[j],y[j],z[j],x[k],y[k],z[k]);
                            if (area > maxArea)
                                maxArea = area;
                        }
                    }
                }
            }
//            DecimalFormat df = new DecimalFormat ( "#.00000" );
//            System.out.println (df.format ( maxArea ));
            System.out.format ( "%.5f",maxArea );
        }
    }

    public static double countArea(int x2,int y2,int z2,int x1,int y1,int z1,int x3,int y3,int z3){
        double a = distance ( x1,y1,z1,x2,y2,z2 );
        double b = distance ( x1,y1,z1,x3,y3,z3 );
        double c = distance ( x3,y3,z3,x2,y2,z2 );
        double s = (a+b+c)/2;
        return Math.sqrt ( s*(s-a)*(s-b)*(s-c) );
    }

    public static double distance(int x2,int y2,int z2,int x1,int y1,int z1){
        return Math.sqrt ( (x1-x2)*(x1-x2) + (y1-y2)*(y1-y2) + (z1-z2)*(z1-z2) );
    }
}
