package WangYiTest.Fall2016;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by zhuhao on 17-8-18.
 * 在N*M的草地上,提莫种了K个蘑菇,蘑菇爆炸的威力极大,兰博不想贸然去闯,而且蘑菇是隐形的.只 有一种叫做扫描透镜的物品可以扫描出隐形的蘑菇,于是他回了一趟战争学院,买了2个扫描透镜,一个 扫描透镜可以扫描出(3*3)方格中所有的蘑菇,然后兰博就可以清理掉一些隐形的蘑菇. 问:兰博最多可以清理多少个蘑菇?
 注意：每个方格被扫描一次只能清除掉一个蘑菇。
 输入描述:
 第一行三个整数:N,M,K,(1≤N,M≤20,K≤100),N,M代表了草地的大小;
 接下来K行,每行两个整数x,y(1≤x≤N,1≤y≤M).代表(x,y)处提莫种了一个蘑菇.
 一个方格可以种无穷个蘑菇.


 输出描述:
 输出一行,在这一行输出一个整数,代表兰博最多可以清理多少个蘑菇.
 */
public class CleanMushroom {
    public static void main(String[] args) {
        Scanner sc = new Scanner ( System.in );
        while (sc.hasNext ()) {
            int n = sc.nextInt ();
            int m = sc.nextInt ();
            int k = sc.nextInt ();
            int[][] grass = new int[n+1][m+1];
            for (int i=0;i<k;i++){
                int x= sc.nextInt ();
                int y= sc.nextInt ();
                grass[x][y] += 1;
            }

            int result=0;
            int max = 0,maxX=0,maxY=0;
            for (int i=1;i<=n;i++){
                for (int j=1;j<=m;j++){
                    int sum = 0;
                    if (i+2 <= n && j+2<=m){
                        for (int a=i;a<i+3;a++){
                            for (int b=j;b<j+3;b++){
                                if (grass[a][b]>0)
                                    sum++;
                            }
                        }
                    }
                    if (sum > max){
                        max = sum;
                        maxX = i;
                        maxY = j;
                    }
                }
            }

            result += max;
            for (int i=maxX;i<maxX+3;i++){
                for (int j=maxY;j<maxY+3;j++){
                    if (grass[i][j]>=1)
                        grass[i][j]--;
                }
            }

            max = 0;
            for (int i=1;i<=n;i++){
                for (int j=1;j<=m;j++){
                    int sum = 0;
                    if (i+2 <= n && j+2<=m){
                        for (int a=i;a<i+3;a++){
                            for (int b=j;b<j+3;b++){
                                if (grass[a][b]>0)
                                    sum++;
                            }
                        }
                    }
                    if (sum > max){
                        max = sum;
                    }
                }
            }
            result+=max;
            System.out.println (result);

        }
    }
}
