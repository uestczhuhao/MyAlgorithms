package WangYiTest.Spring2017;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by zhuhao on 17-8-17.
 */
public class MagicRoll {
    public static void main(String[] args) {
        Scanner sc = new Scanner ( System.in );
        while (sc.hasNext ()) {
            int n = sc.nextInt ();
            int k = sc.nextInt ();
            int[] nums = new int[n];
            for (int i=0;i<n;i++)
                nums[i] = sc.nextInt ();

            for (int i=0;i<k;i++){
                int tmp = nums[0];
                for (int j=0;j<n;j++){
                    if (j<n-1){
                        nums[j] = nums[j]+nums[j+1];
                    } else{
                        nums[j] += tmp;
                    }
                    if (nums[j]>=100)
                        nums[j] %= 100;
                }
//                System.out.println ( Arrays.toString (nums));
            }

            System.out.print (nums[0]);
            for (int i=1;i<n;i++)
                System.out.print (" "+nums[i]);
        }
    }
}
