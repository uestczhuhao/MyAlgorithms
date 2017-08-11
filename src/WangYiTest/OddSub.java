package WangYiTest;

import java.util.Scanner;

/**
 * Created by zhuhao on 17-8-11.
 */
public class OddSub {
    public static void main(String[] args) {
        Scanner in = new Scanner ( System.in );
        while (in.hasNextLine ()){
            String str = in.nextLine ();
            int n = Integer.parseInt ( str );
            if(n<=0)
                return;

            int[] arr = new int[n];
            countCore ( n,arr );
            int count = 0;
            for (int i=0;i<n;i++){
                count+=arr[i];
            }

            System.out.println (count);
        }
//        System.out.println (countCore ( 4 ));
    }


    private static void countCore(int n,int[] arr){
        if (n==1) {
            arr[0] = 1;
            return;
        }
        arr[0] = arr[1] = 1;
        for (int i=2;i<n;i++){
            if (isPrime ( i+1 ))
                arr[i] = i+1;
            else
                arr[i] = countCore ( i+1 );
        }
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

    private static int countCore(int n){
        int sqrtM = n>>1;
        for (int i=sqrtM;i>2;i--){
            if (n%i == 0 && (i/2)!=0){
                return i;
            }
        }
        return 1;
    }
}
