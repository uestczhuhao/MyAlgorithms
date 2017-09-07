package WangYiTest.AutumnOf2017;
import java.util.*;
/**
 * 牛牛和 15 个朋友来玩打土豪分田地的游戏，牛牛决定让你来分田地，地主的田地可以看成是一个矩形，每个位置有一个价值。分割田地的方法是横竖各切三刀，分成 16 份，作为领导干部，牛牛总是会选择其中总价值最小的一份田地， 作为牛牛最好的朋友，你希望牛牛取得的田地的价值和尽可能大，你知道这个值最大可以是多少吗？
 输入描述:
 每个输入包含 1 个测试用例。每个测试用例的第一行包含两个整数 n 和 m（1 <= n, m <= 75），表示田地的大小，接下来的 n 行，每行包含 m 个 0-9 之间的数字，表示每块位置的价值。
 输出描述:
 输出一行表示牛牛所能取得的最大的价值。
 示例1
 输入

 4 4
 3332
 3233
 3332
 2323
 输出

 2
 */
public class Divide {
    //二分答案，判断可行性时暴力枚举三列的情况，然后横着贪心地扫一遍
//每当四列都满足的时候就砍一刀，满足四次即可，复杂度O(N^4logN)
//计算matrix矩阵中左上顶点(i,j)到右下顶点(x-1,y-1)确定的田地的价值和
    public static int cal(int x,int y,int i,int j,int[][] sum)
    {
        return sum[x][y]-sum[x][j]-sum[i][y]+sum[i][j];
    }
    //判断x是否小于等于小于田地中最小一块的值
    public static boolean judge(int x,int n,int m,int[][] sum)
    {
        for (int i=1;i<=m-3 ;i++ )
        {
            for (int j=i+1;j<=m-2 ;j++ )
            {
                for (int k=j+1;k<=m-1 ;k++ )
                {
                    int last=0,cnt=0;
                    for (int r=1;r<=n ;r++ )
                    {
                        int s1=cal(r,i,last,0,sum);
                        int s2=cal(r,j,last,i,sum);
                        int s3=cal(r,k,last,j,sum);
                        int s4=cal(r,m,last,k,sum);
                        //当前横切一刀条件满足
                        if (s1>=x&&s2>=x&&s3>=x&&s4>=x)
                        {
                            last=r;
                            cnt++;
                        }
                    }
                    //表明x小于等于16块田地中的最小值，返回true
                    if (cnt>=4)
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext())
        {
            int n=sc.nextInt();
            int m=sc.nextInt();
            int[][] matrix=new int[n][m];
            for (int i=0;i<n ;i++ )
            {
                String str=sc.next();
                for (int j=0;j<m ;j++ )
                {
                    matrix[i][j]=str.charAt(j)-'0';
                }
            }
            //sum[i][j]表示
            //左上顶点matrix[0][0]到右下顶点matrix[i-1][j-1]
            //确定的的矩阵元素的和
            //例如sum[1][1]就表示matrix[0][0];
            int[][] sum=new int[n+1][m+1];
            for (int i=1;i<=n ;i++ )
            {
                for (int j=1;j<=m ;j++ )
                {
                    sum[i][j]=sum[i-1][j]+
                            sum[i][j-1]-sum[i-1][j-1]+matrix[i-1][j-1];
                }
            }
            int left=0,right=sum[n][m],res=0;
            while (left<=right)
            {
                int mid=(left+right)/2;
            /*对于题目输入示例中的情况
            输入示例
                4 4
                3332
                3233
                3332
                2323
                输出
                2
            sum矩阵为
            0 0  0  0  0
            0 3  6  9  11
            0 6  11 17 22
            0 9  17 26 33
            0 11 22 33 43
            mid依次为21->10->4->1->2
                            */
                if (judge(mid,n,m,sum))
                {
                    left=mid+1;
                    res=mid;
                }
                else
                {
                    right=mid-1;
                }
            }
            System.out.println(res);
        }
        sc.close();
    }
}
