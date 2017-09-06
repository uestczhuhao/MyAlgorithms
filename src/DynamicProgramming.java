import java.util.Arrays;

/**
 * Created by zhuhao on 17-8-16.
 */
public class DynamicProgramming {
    public static void main(String[] args) {
//        System.out.println (coinQuestion ( 11 ));

        int[] value = {9,6,1,4,1};
        int[] weight = {4,3,5,2,5};
        int result = bagQustion1 ( 5,value,weight,10 );
        System.out.println (result);

//        int[] nums= {5,3,4,8,6,7};
//        System.out.println (LISQuestion ( nums ));
    }

    /**
     * 如果我们有面值为1元、3元和5元的硬币若干枚，如何用最少的硬币凑够n元？
     * 思路：d(i)=min{ d(i-vj)+1 }，其中i-vj >=0，vj表示第j个硬币的面值;
     * @param n
     * @return
     */
    //V数组代表硬币的金额，有1元，3元和5元面值的
    static int[] V = {1,3,5};
    private static int coinQuestion(int n){
        int d[] = new int[n+1];
        for (int i=1;i<=n;i++){
            int min = d[i-V[0]]+1;
            for (int j=0;j<V.length;j++){
                if (i-V[j]>=0 && d[i-V[j]]+1 < min){
                    min = d[i-V[j]]+1;
                }
            }
            d[i] = min;
        }
        System.out.println ( Arrays.toString (d));
        return d[n];
    }


    /**
     * 有一个容量为capacity的背包和n块宝石，求宝石价值的最大值
     * @param n  有n块宝石
     * @param value   每一块宝石的价值
     * @param weight    每块宝石的重量
     * @param capacity      背包的容量，即最大重量
     * @return
     * 把它形式化一下：d(i, j)=max{ d(i-1, j), d(i-1,j-weight[i-1]) + value[i-1] }。
     * 注意讨论前i个宝石装入背包的时候， 其实是在考查第i-1个宝石装不装入背包（因为宝石是从0开始编号的）。
     * 其中d(i,j)为前i个宝石装到剩余体积为j的背包里能达到的最大价值
     * 如：d(3, 10)表示的是前3个宝石装入到剩余体积为10的背包里能达到的最大价值
     *
     *
     * 状态转移方程转化为考虑第i-1号宝石装不装入背包的为问题，如果不装入，则是d(i-1, j)，装入则是d(i-1,j-value[i-1]) + weight[i-1]
     * 因为如果装入的话，则前面i-2块宝石的空间就变成了j-weight[i-1]，价值加上value[i-1]
     * 如果不装入，则前面i-2块宝石的空间依然为j，价值也不变
     *
     * 案例：n=3  value={20,10,12}   weight={5,4,3}  capacity=10
     * n=5  value = {9,6,1,4,1}  weight={4,3,5,2,5}  capacity=10
     */
    private static int bagQustion(int n,int[] value,int[] weight,int capacity){
        int[][] d= new int[n+1][capacity+1];
        for (int i=0;i<=n;i++){
            for (int j=0;j<=capacity;j++){
                d[i][j] = (i==0 ? 0 : d[i-1][j]);
                if (i>0 && j>=weight[i-1]){
                    d[i][j]=(d[i-1][j]>d[i-1][j-weight[i-1]]+value[i-1]?d[i-1][j]:d[i-1][j-weight[i-1]]+value[i-1]);
                }
            }
            System.out.println (Arrays.deepToString ( d ));
        }
        ///编号为i的宝石是否在bag中了
        int[] isInBag =new int[n];
        int j = capacity;
        for (int i=n;i>0;i--){
            if (d[i][j] > d[i-1][j]){
                isInBag[i-1]=1;
                j-=weight[i-1]; ////装入第i-1个宝石后背包能装入的体积就只剩下j - weight[i-1]
            }
        }
        return d[n][capacity];
    }
    private static int bagQustion1(int n,int[] value,int[] weight,int capacity){
        ///空间复杂度的优化，dp0表示i-1时的值，dp1表示i时的值
        ///因为当宝石数量为i时，其状态只与i-1有关，因此只需要把i-1的状态保存下来即可
        int[] dp0 = new int[capacity+1];
        int[] dp1 = new int[capacity+1];
            for (int i=1;i<=n;i++){
            for (int j=1;j<=capacity;j++){
                if (j>= weight[i-1])
                    dp1[j] = Math.max ( dp0[j],dp0[j-weight[i-1]]+value[i-1] );
            }
            int[] t = dp0;
            dp0 = dp1;
            dp1 = t;
        }
        return dp0[capacity];
    }

    /**
     * LIS(longest increasing subsequence)问题
     * 一个序列有N个数：A[1],A[2],…,A[N]，求出最长非降子序列的长度。
     * 例如：5，3，4，8，6，7 其最长递增序列为4
     * d(i) = max{1, d(j)+1},其中j<i,A[j]<=A[i]
     * @param nums 初始数组
     * @return
     */
    private static int LISQuestion(int[] nums){
        int[] d = new int[nums.length];
        int len = 1;
        for (int i=0;i<nums.length;i++){
            ///d[i]的初始值设为1,若计算的值比1大则d[i] = d[j]+1;
            d[i] = 1;
            for (int j=0;j<i;j++){
                if (nums[j] <= nums[i] && d[j]+1 > d[i])
                    d[i] = d[j]+1;
            }
            if (d[i] > len)
                len = d[i];
        }
        System.out.println (Arrays.toString ( d ));
        return len;
    }
}
