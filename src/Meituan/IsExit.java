package Meituan;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by zhuhao on 17-8-31.
 */
public class IsExit {
    public static void main(String[] args) {
        Scanner sc = new Scanner ( System.in );
        while (sc.hasNext ()){
            int n = sc.nextInt ();
            int[] nums = new int[n];
            int sum =0;
            for (int i=0;i<n;i++){
                nums[i] = sc.nextInt ();
                sum += nums[i];
            }

            Arrays.sort (nums);
            if (nums[n-1]<=sum/2)
                System.out.println ("Yes");
            else
                System.out.println ("No");
        }
    }
}
