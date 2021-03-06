package WorkToOffer;

/**
 * Created by zhuhao on 17-6-18.
 */
public class UnusualSum {


    public static void main(String[] args) {
        Solution test = new Solution ();
        int re = test.Sum_Solution ( 10 );
        System.out.println (re);
    }
}

class Solution{

    static private int n=0;
    static private int sum = 0;

    public Solution(){
        n++;
        sum = sum+n;
    }
    public static int getSum(){
        return sum;
    }
    public static void reset(){
        n =0 ;
        sum = 0;
    }
    public int Sum_Solution(int n) {
        if (n<0)
            throw new Error ( "Illegal Input!" );
//        if (n == 0 || n==1)
//            return n;
        Solution.reset();
//        for (int i=0;i<n;i++){
//            Solution s = new Solution ();
//        }
        return Solution.getSum ();
    }

    //利用短路求值方法，在n不为0时一直运行递归函数，并把结果相加
    //当递归运算到n=0时，递归退出并返回结果
    public int Sum_Solution1(int n){
        int ans=n;
        boolean flag = (n>0)&&((ans+=Sum_Solution(n-1))>0);
        return ans;
    }
}