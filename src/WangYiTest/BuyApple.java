package WangYiTest;

import java.util.Scanner;

/**
 * Created by zhuhao on 17-8-11.
 * 小易去附近的商店买苹果，奸诈的商贩使用了捆绑交易，只提供6个每袋和8个每袋的包装(包装不可拆分)。 可是小易现在只想购买恰好n个苹果，小易想购买尽量少的袋数方便携带。如果不能购买恰好n个苹果，小易将不会购买。
 输入描述:

 输入一个整数n，表示小易想购买n(1 ≤ n ≤ 100)个苹果


 输出描述:

 输出一个整数表示最少需要购买的袋数，如果不能买恰好n个苹果则输出-1
 示例1
 输入

 20

 输出

 3
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
