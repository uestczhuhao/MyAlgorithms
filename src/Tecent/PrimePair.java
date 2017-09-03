package Tecent;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by zhuhao on 17-9-3.
 * 给定一个正整数，编写程序计算有多少对质数的和等于输入的这个正整数，并输出结果。输入值小于1000。
 如，输入为10, 程序应该输出结果为2。（共有两对质数的和为10,分别为(5,5),(3,7)）
 输入描述:
 输入包括一个整数n,(3 ≤ n < 1000)
 输出描述:
 输出对数
 示例1
 输入

 10
 输出

 2
 */
public class PrimePair {
    public static int[] Prime =new int[168];
    public static void main(String[] args) {
        Scanner sc = new Scanner ( System.in );
        while (sc.hasNext ()){
            int n = sc.nextInt ();
            System.out.println (countCore ( n ));
//            createPrime ();
//            int count = 0;
//            int low = 0,high=167;
//            for (int i=167;i>=0;i--){
//                if (Prime[i] < n){
//                    high = i;
//                    break;
//                }
//            }
//
//            while (low <= high){
//                int sum =Prime[low] + Prime[high];
//                if (n == sum){
////                    System.out.println (Prime[low]+" "+Prime[high]);
//                    count++;
//                    low++;
//                } else if (sum > n){
//                    high --;
//                } else
//                    low ++ ;
//            }
//            System.out.println ( count );
        }
    }

    private static void createPrime(){
        Prime[0] = 2;
        int index = 1;
        for (int j=3;j<1000;j++){
            if ( isPrime(j) ){
                Prime[index] = j;
                index++;
            }
        }
    }

    private static boolean isPrime(int j){
        int tmp = (int) Math.sqrt ( j );
        for (int i=2;i<=tmp;i++)
            if (j % i==0)
                return false;

        return true;
    }


    private static int countCore(int n){
        if (n <= 3)
            return 0;
        int count = 0;
        for (int i=1;i<=n/2;i++){
            if (isPrime ( i ) && isPrime ( n-i ))
                count++;
        }

        return count;
    }
}
