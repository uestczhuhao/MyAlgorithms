package dji;

import java.util.Scanner;

/**
 * Created by zhuhao on 17-8-26.
 */
public class CountNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner ( System.in );
        while (sc.hasNext ()) {
            int n = sc.nextInt ();
            int[] nums = new int[n];
            for (int i=0;i<n;i++){
                nums[i] = sc.nextInt ();
            }
            long sum = 0;
//            int[] bits = new int[64];
//            for (int i=0;i<n;i++){
//                int tmp = nums[i];
//                for (int j=0; tmp!=0 && j<64;j++){
//                    if ((tmp&1) == 1){
//                        bits[j] ++;
//                    }
//                    tmp>>=1;
//                }
//            }
//
//            for (int i=0;i<64;i++){
//                if (bits[i] < n && bits[i]!=0){
//                    sum += bits[i]*(n-bits[i]);
//                }
//            }
            for (int i=0;i<n;i++){
                for (int j=i+1;j<n;j++){
                    sum+= countCo ( nums[i],nums[j] );
                }
            }
            System.out.println ( sum );

        }
    }


    public static int countCo(int m,int n){
        int res=m^n;
        int count=0;
        while(res!=0){
        count++;
        res=res&(res-1);
        }

        return count;
    }

}
