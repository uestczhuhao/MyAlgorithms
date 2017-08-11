package WangYiTest;

import java.util.Scanner;

/**
 * Created by zhuhao on 17-8-11.
 */
public class ElegantPoint {
    private static int count = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner ( System.in );
        int n = in.nextInt ();
        if (n<= 0)
            return;
        int m = (int)Math.sqrt ( (double)n );
//        m*=m;
        countCore(n,m);
        System.out.println (count);
    }

    private static void countCore(int n,int m){

        int low = 0,high = m;
        while (low<=high){
            int sum = low*low + high*high;
            if (sum == n){
                if (low == 0 || low==high)
                   count +=4;
                else
                    count+=8;
                low++;
            } else if (sum < n){
                low ++;
            } else if (sum > n )
                high--;
        }
    }


}
