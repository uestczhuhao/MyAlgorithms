package Meituan;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by zhuhao on 17-8-31.
 * 5 1 2 3 4 5 5
 * 6 3 1 2 7 7 7 4
 * 5 1 3 5 10 9 10
 */
public class MaxLength {
    public static void main(String[] args) {
        Scanner sc = new Scanner ( System.in );
        while (sc.hasNext ()){
            int n = sc.nextInt ();
            int[] nums = new int[n];
            for (int i=0;i<n;i++){
                nums[i] = sc.nextInt ();
            }

            int k = sc.nextInt ();
            int sum = 0;
            int[] count = new int[n+1];
            count[0] = 0;
            for (int i=0;i<n;i++){
                sum+=nums[i];
                count[i+1] =sum;
            }
            boolean flag = false;
            int i,j;
//        System.out.println ( Arrays.toString (count));
            for (i=n;i>=1;i--){
                for (j=0;j+i <= n;j++){
                    int tmp = count[i + j] - count[j];
//                System.out.println ("tmp = "+tmp);
                    if (tmp % k ==0){
//                    System.out.println (i);
                        flag = true;
                        break;
                    }
                }
                if (flag)
                    break;
            }


            if (!flag)
                System.out.println (0);
            else
                System.out.println (i);
        }

    }

//    public static int countSum(int[] nums,int start,int len){
//
//    }
}
