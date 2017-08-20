package NationalSimulation;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by zhuhao on 17-8-19.
 * 牛牛和羊羊在玩一个有趣的猜数游戏。在这个游戏中,牛牛玩家选择一个正整数,羊羊根据已给的提示猜这个数字。第i个提示是"Y"或者"N",表示牛牛选择的数是否是i的倍数。
 例如,如果提示是"YYNYY",它表示这个数使1,2,4,5的倍数,但不是3的倍数。
 注意到一些提示会出现错误。例如: 提示"NYYY"是错误的,因为所有的整数都是1的倍数,所以起始元素肯定不会是"N"。此外,例如"YNNY"的提示也是错误的,因为结果不可能是4的倍数但不是2的倍数。
 现在给出一个整数n,表示已给的提示的长度。请计算出长度为n的合法的提示的个数。
 例如 n = 5:
 合法的提示有:
 YNNNN YNNNY YNYNN YNYNY YYNNN YYNNY
 YYNYN YYNYY YYYNN YYYNY YYYYN YYYYY
 所以输出12
 输入描述:
 输入包括一个整数n(1 ≤ n ≤ 10^6),表示已给提示的长度。


 输出描述:
 输出一个整数,表示合法的提示个数。因为答案可能会很大,所以输出对于1000000007的模

 输入例子1:
 5

 输出例子1:
 12
 */
public class GuessNumber {
    /*
    思路： 1.第i个数是素数，那么dp[i]=dp[i-1]*2，
    这是因为素数和前面的所有数都没有依赖关系，因此YN都行

    2.第i个数不是素数的幂次，也就是像6这样的数字，你会发现，
    它已经被2,3唯一确定了，例如23分别是YY，那么6一定是Y，
    23分别是YN或NY或NN，6一定是N，所以说这时候有dp[i]=dp[i-1]


    3.第i个数是素数的幂次，它不能唯一确定，比如4，
    当2为Y时，4不确定，可以是Y，也可以是N。
    将4和2放入集合，若2取，4必定取，所以有NN，YN，YY三种情况。
    那么引申一下，加入8就是3个元素的集合，共4种情况，9就是2个元素的集合（3、9），有3种情况，以此类推。
    最后将这些情况相乘即可，因为这些集合之间相互不影响

    用10来举例吧，1我们不考虑，2是素数，它的10以内幂次是2,4,8，因此有4种情况。
    接下来是3，它10以内的幂次是3,9，因此有3种情况，4我们考虑完了，
    5有2种情况，6由2和3唯一确定不需要考虑，7有2种情况（Y和N），
    8我们也考虑完了，9我们也考虑完了，10 由2和5唯一确定，因此总共的情况就是素数序列的个数乘积,
    即num(2)*num(3)*num(5)*num(7)（4*3*2*2=48）
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner ( System.in );
        while (sc.hasNext ()) {
            int n = sc.nextInt ();
            if (n==1 || n==2){
                System.out.println (n);
                return;
            }
            int[] table = new int[n+1];
            long res =1;
            for (int i=2;i<=n;i++){
                int count=0;
                if (table[i] == 1)
                    continue;
                for (int j=i+i;j<=n;j+=i){
                    table[j] =1;
                }

                long mi=i;
                while (mi<=n){
                    count++;
                    mi *= i;
                }
//                System.out.print ("i = "+ i+" count = ");
//                System.out.println (count+1);
                res = res*(count+1) %1000000007;
            }
            System.out.println (res);
        }
    }

}
