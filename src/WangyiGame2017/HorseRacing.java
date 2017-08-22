package WangyiGame2017;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by zhuhao on 17-8-20.
 * 在一条无限长的跑道上，有N匹马在不同的位置上出发开始赛马。
 * 当开始赛马比赛后，所有的马开始以自己的速度一直匀速前进。
 * 每匹马的速度都不一样，且全部是同样的均匀随机分布。
 * 在比赛中当某匹马追上了前面的某匹马时，被追上的马就出局。
 *
 * 请问按以上的规则比赛无限长的时间后，赛道上剩余的马匹数量的数学期望是多少
 *
 */
public class HorseRacing {
    /*
    速度最大的马无论在什么位置都可以不被淘汰，所以速度最大的马存活的概率是1，
    然后速度第二大的马只有在速度最大的马后面才能存活，只有在它前后两种情况，所以存活的概率是1/2，
    同理，速度第三大的马有三种排列情况（不考虑前面两匹马的排列），存活概率是1/3,
    依次类推，所以最后的情况就是1+1/2+1/3+......1/n。

    注意不是通过每种排列情况计算能存活下来的马的数量，而是根据每匹马能存活的概率计算。
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner ( System.in );
        while (sc.hasNext ()) {
            int n = sc.nextInt ();
            double sum = 0;
            for (int i=1;i<=n;i++){
                sum += 1.0/i;
            }
            System.out.println (sum);
            System.out.println (String.format ( "%.4f",sum ));
        }
    }
}
