package WangYiTest.AutumnOf2017;

import java.util.Arrays;
import java.util.Scanner;
/**
 * Created by zhuhao on 17-9-7.
 *
 */


public class MaxMulti {
    /*

题目要求n各学生中选择k个，使这k个学生的能力值乘积最大。这是一个最优化的问题。另外，在优化过程中，提出了相邻两个学生的位置编号差不超过d的约束。
如果不用递归或者动态规划，问题很难入手，并且，限制条件d也需要对每一个进行约束，编程十分复杂
所以，解决的方法是采用动态规划（理由：1.求解的是最优化问题；2.可以分解为最优子结构）
2. 问题分解
1.对该问题的分解是关键。
从n个学生中，选择k个，可以看成是：先从n个学生里选择最后1个，然后在剩下的里选择k-1个，并且让这1个和前k-1个满足约束条件
2.数学描述
为了能够编程实现，需要归纳出其递推公式，而在写递推公式之前，首先又需要对其进行数学描述
记第k个人的位置为one,则可以用f[one][k]表示从n个人中选择k个的方案。然后，它的子问题，需要从one前面的left个人里面，选择k-1个，这里left表示k-1个人中最后一个（即第k-1个）人的位置，因此，子问题可以表示成f[left][k-1].
学生能力数组记为arr[n+1],第i个学生的能力值为arr[i]
one表示最后一个人，其取值范围为[1,n];
left表示第k-1个人所处的位置，需要和第k个人的位置差不超过d，因此
max{k-1,one-d}<=left<=one-1
在n和k定了之后，需要求解出n个学生选择k个能力值乘积的最大值。因为能力值有正有负，所以
当one对应的学生能力值为正时，
f[one][k] = max{f[left][k-1]arr[i]}(min{k-1,one-d}<=left<=one-1);
当one对应的学生能力值为负时
f[one][k] = max{g[left][k-1]arr[i]}(min{k-1,one-d}<=left<=one-1);
此处g[][]是存储n个选k个能力值乘积的最小值数组
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int[] ablity = new int[n+1];
            for (int i=1;i<=n;i++)
                ablity[i] = sc.nextInt();
            int kk = sc.nextInt();
            int d = sc.nextInt();


            /*
            递推的时候，以f[one][k]的形式表示从n个人中选择k个的方案
          * 其中：one表示最后一个人的位置，k为包括这个人，一共有k个人
          * 原问题和子问题的关系：f[one][k]=max{f[left][k-1]*arr[one],g[left][k-1]*arr[one]}
             */

            long f[][] = new long[n+1][kk+1];
            long g[][] = new long[n+1][kk+1];

            for (int one =1;one <=n;one++){
                f[one][1] = ablity[one];
                g[one][1] = ablity[one];
            }

            System.out.println(Arrays.deepToString(f));
            System.out.println(Arrays.deepToString(g));
            for (int k=2;k<=kk;k++){
                for (int one = k;one <= n;one ++){
                    //求解当one和k定的时候，最大的分割点
                    long tempmax = Long.MIN_VALUE;
                    long tempmin = Long.MAX_VALUE;
                    for(int left = Math.max(k-1,one-d);left<=one-1;left++){
                        if(tempmax<Math.max(f[left][k-1]*ablity[one],g[left][k-1]*ablity[one])){
                            tempmax=Math.max(f[left][k-1]*ablity[one],g[left][k-1]*ablity[one]);
                        }
                        if(tempmin>Math.min(f[left][k-1]*ablity[one],g[left][k-1]*ablity[one])){
                            tempmin=Math.min(f[left][k-1]*ablity[one],g[left][k-1]*ablity[one]);
                        }
                    }
                    f[one][k] = tempmax;
                    g[one][k] = tempmin;
                }
            }

            //n选k最大的需要从最后一个最大的位置选
            long result = Long.MIN_VALUE;
            for(int one = kk;one<=n;one++){
                if(result<f[one][kk]){
                    result = f[one][kk];
                }
            }
            System.out.println(result);
        }
    }
}
