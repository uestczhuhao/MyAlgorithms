package WangYiTest.Spring2017;

import java.util.*;

/**
 * Created by zhuhao on 17-8-17.
 * 一种双核CPU的两个核能够同时的处理任务，现在有n个已知数据量的任务需要交给CPU处理，假设已知CPU的每个核1秒可以处理1kb，每个核同时只能处理一项任务。n个任务可以按照任意顺序放入CPU进行处理，现在需要设计一个方案让CPU处理完这批任务所需的时间最少，求这个最小的时间。
 输入描述:
 输入包括两行：
 第一行为整数n(1 ≤ n ≤ 50)
 第二行为n个整数length[i](1024 ≤ length[i] ≤ 4194304)，表示每个任务的长度为length[i]kb，每个数均为1024的倍数。


 输出描述:
 输出一个整数，表示最少需要处理的时间

 输入例子1:
 5
 3072 3072 7168 3072 1024

 输出例子1:
 9216
 */
public class TwoCoreCPU {

//    public static void main(String[] args) {
//        Scanner sc = new Scanner ( System.in );
//        while (sc.hasNext ()){
//            int n = sc.nextInt ();
//            LinkedList<Integer> nums = new LinkedList<> (  );
//            for (int i=0;i<n;i++)
//                nums.add ( sc.nextInt () );
//            Collections.sort ( nums );
//            System.out.println (nums);
//            if (nums.size () ==1){
//                System.out.println (nums.get ( 0 ));
//                return;
//            }
//            int sum1=nums.pollLast (),sum2=nums.get ( nums.size ()/2 );
//            nums.remove ( nums.size ()/2 );
//            boolean isTail = false;
//            while (!nums.isEmpty ()){
//
//                if (sum1 > sum2){
//                    sum2+=nums.get ( nums.size ()/2 );
//                    nums.remove ( nums.size ()/2 );
//                } else {
//                    if (isTail){
//                        sum1+=nums.pollLast ();
//                        isTail = false;
//                    } else {
//                        sum1+=nums.pollFirst ();
//                        isTail = true;
//                    }
//                }
//                System.out.println ("Sum1 = "+sum1);
//                System.out.println ("Sum2 = "+sum2);
//            }
//
//            int res = sum1>sum2 ? sum1:sum2;
//            System.out.println (res);
//        }
//    }
    /*
    根据题目意思，两个CPU平摊任务，然后输出执行这些任务的最小时间，最理想的情况是，
    每个CPU执行的任务占所有任务的总时间的一半（wholeTime/2），
    这样两个CPU执行的时间差就是最小的，输出的结果就是最小的，
    但任务只能由一个CPU独立完成，所以单个任务的执行时间已经是不可分割的了。

    解决的办法就是尽量让单个CPU执行的任务总时间接近wholeTime/2，越接近这个值，
    则这个CPU和另一个CPU的执行时间差就必定越小。
    也就能得到最优解，所以只要讨论一个CPU即可，
    而且希望它的执行时间越接近wholeTime/2就越好，
    这就与01背包问题挂上钩了，问题转化为限制背包的容量为wholeTime/2，
    每个任务转化为每个物品，物品的价值和大小都是任务的执行时间，
    这样一来，只要求得背包总价值最大即可得到原问题的答案了
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner ( System.in );
        while (sc.hasNext ()){
            int n = sc.nextInt ();
            int[] nums = new int[n];
            int sum = 0;
            for (int i=0;i<n;i++){
                nums[i] = sc.nextInt()>>10;
                sum+=nums[i];
            }
            int[] dp = new int[sum/2+1];
            // dp[j]表示在容量为j的情况下可存放的重量
            // 如果不放arr[i]重量为dp[j],如果放arr[i]重量为dp[j-arr[i]]+arr[i];
            for (int i=0;i<n;i++){
                for (int j=sum/2;j>=nums[i];j--){

                    dp[j] = Math.max ( dp[j],dp[j-nums[i]]+nums[i] );
                    System.out.println ("i= "+i);
                    System.out.println ( Arrays.toString (dp));
                }
            }
            System.out.println ( Arrays.toString (dp));
            System.out.println (Math.max ( dp[sum/2],sum-dp[sum/2] )<<10);
        }

    }
}
