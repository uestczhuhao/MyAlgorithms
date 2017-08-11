package WangYiTest;

import java.util.Scanner;

/**
 * Created by zhuhao on 17-8-11.
 */
public class BuyApple {
    public static void main(String[] args) {
        Scanner in = new Scanner ( System.in );
        while (in.hasNextLine ()){
            int n = in.nextInt ();
            if(n<=0)
                return;

            int count = 0;
            if (n < 8 && n != 6){
                System.out.println (-1);
                return;
            }

            count = countCore ( n );
            System.out.println (count);
        }
//        System.out.println (countCore ( 32 ));
    }

    private static int countCore(int n){

        if (isPrime ( n ))
            return -1;

        int low = n/8,high = n/6 + 1;
        for (int i=low;i<=high;i++){
            if (i*8 == n || i*6 == n)
                return i;
            else if (8*i < n || 6*i>n)
                continue;
            else if (6*i < n || 8*i > n){
                if (isKey ( i,n ))
                    return i;
            }
        }
        return -1;
    }

    ///输入的m大于等于3
    private static boolean isPrime(int m){
        int sqrtM = (int)Math.sqrt ( m );
        for (int i=2;i<=sqrtM;i++)
            if (m%i == 0){
                return false;
            }
        return true;
    }

    ///判断对应的i值是否可以取得
    private static boolean isKey(int n,int key){

        for (int i=1;i<n;i++){
            int sum =6*(n-i) + 8*i;
            if (sum == key)
                return true;
            else if (sum > key){
                return false;
            } else {
                continue;
            }
        }
        return false;
    }
}
