package Didi.Test0826;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by zhuhao on 17-8-26.
 */
public class MaxSubArr {
    public static void main(String[] args) {
        Scanner sc = new Scanner ( System.in );
        ArrayList<Integer> in = new ArrayList<> (  );
        while (sc.hasNext ()){
            in.add ( sc.nextInt () );
        }
        sc.close ();
        int n = in.size ();
        int max = Integer.MIN_VALUE;
        int sum=0;
        for (int i=0;i<n;i++){
            sum += in.get ( i );
            if (sum < in.get ( i )){
                sum = in.get ( i );
            }
            if (sum > max){
                max = sum;
            }
        }

        System.out.println (max);
    }
}
