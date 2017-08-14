package WangYiTest.WangYi0812;

import java.util.Arrays;
import java.util.Random;
import java.util.*;

/**
 * Created by zhuhao on 17-8-12.
 * 小易将n个棋子摆放在一张无限大的棋盘上。第i个棋子放在第x[i]行y[i]列。同一个格子允许放置多个棋子。每一次操作小易可以把一个棋子拿起并将其移动到原格子的上、下、左、右的任意一个格子中。小易想知道要让棋盘上出现有一个格子中至少有i(1 ≤ i ≤ n)个棋子所需要的最少操作次数.

 输入描述:
 输入包括三行,第一行一个整数n(1 ≤ n ≤ 50),表示棋子的个数
 第二行为n个棋子的横坐标x[i](1 ≤ x[i] ≤ 10^9)
 第三行为n个棋子的纵坐标y[i](1 ≤ y[i] ≤ 10^9)


 输出描述:
 输出n个整数,第i个表示棋盘上有一个格子至少有i个棋子所需要的操作数,以空格分割。行末无空格

 如样例所示:
 对于1个棋子: 不需要操作
 对于2个棋子: 将前两个棋子放在(1, 1)中
 对于3个棋子: 将前三个棋子放在(2, 1)中
 对于4个棋子: 将所有棋子都放在(3, 1)中

 输入例子1:
 4
 1 2 4 9
 1 1 1 1

 输出例子1:
 0 1 3 10
 */
public class MoveChess {
    /*
    * 暴力解法 该解法为 @蟹粉馅大糖包 首创
    * 思路：最后关键的棋子的横坐标和纵坐标肯定是出现过的横坐标和纵坐标
    * 举个栗子：输入为
    *  4
    *  1 2 4 9
    *  1 1 1 1
    *
    * 那么最后关键棋子的横坐标必然是1,2,4,9中的一个，纵坐标必然是1
    *
    *
    * 证明可以参考@蟹粉馅大糖包 的反证法，如下：
    *  xy轴其实是独立的，先只考虑x坐标，假设把k个棋子堆到x0格子所用的步骤最少，
    * a个棋子初始在x0的左边，b个棋子初始在x0的右边，且a>b,那么必然存在横坐标为x0-1的格子，
    * 这k个棋子到x0-1的步数会更少，b>a的情况，那么x0+1的目标将比x0更优，
    * 至于a=b，x0-1 和x0的步数是一样的。u
    * 因此，最终汇聚棋子的x坐标只要在棋子初始的x个坐标中考虑
    */
    public static void main(String[] args) {
        Scanner in = new Scanner ( System.in );
        while (in.hasNext ()){
            int n = in.nextInt ();
            int[] x = new int[n];
            int[] y = new int[n];
            for (int i=0;i<n;i++)
                x[i] = in.nextInt ();
            for (int i=0;i<n;i++)
                y[i] = in.nextInt ();

            ArrayList<Long> res = new ArrayList<> (  );
            long min,sum;
            for (int i=1;i<=n;i++){
                min = Long.MAX_VALUE;
                for (int row = 0;row< n;row++){
                    for (int col = 0;col <n;col++){
                        sum = 0;
                        PriorityQueue<Integer> que = new PriorityQueue<> ( i, new Comparator<Integer> () {
                            @Override
                            public int compare(Integer t0, Integer t1) {
                                return t1-t0;
                            }
                        } );

                        for (int c=0;c<n;c++){
                            int xc=x[c];
                            int yc=y[c];
                            int dis = Math.abs ( xc-x[row] )+Math.abs ( yc-y[col] );
                            sum+=dis;
                            que.add ( dis );
                            if (que.size ()>i)
                                sum -= que.poll ();
                        }
                        min = Math.min ( min,sum );
                    }
                }
                res.add ( min );
            }

            for (int i=0;i<n-1;i++)
                System.out.print (res.get ( i )+" ");
            System.out.println (res.get ( n-1 ));
        }

    }


}
