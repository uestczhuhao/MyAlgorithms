package TouTiao.Test0822;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by zhuhao on 17-8-22.
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext ()){
            int n = sc.nextInt ();
            if (n == 0){
                System.out.println (0);

            }
            int[] input = new int[n];
            for (int i=0;i<n;i++)
                input[i] = sc.nextInt ();

            Arrays.sort ( input );
            long max = Long.MIN_VALUE;
            long sum = 0;
            for (int i=0;i<n;i++)
                sum+=input[i];
            for (int i=0;i<n;i++){
                long tmp = input[i]*sum;
                if (tmp > max)
                    max = tmp;
                sum -= input[i];
            }
            System.out.println (max);
        }
    }


}
