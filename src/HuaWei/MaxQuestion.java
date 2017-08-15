package HuaWei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by zhuhao on 17-8-15.
 */
public class MaxQuestion {
    public static void main(String[] args) {
        Scanner sc = new Scanner ( System.in );
        while (sc.hasNext ()){
            int n = sc.nextInt ();
            int m = sc.nextInt ();
            int[] score = new int[n];
            for (int i=0;i<n;i++){
                score[i] = sc.nextInt ();
            }

            sc.nextLine ();
            for (int i=0;i<m;i++){
                String[] chs = new String[3];
                chs[0] = sc.next ();
                chs[1] = sc.next ();
                chs[2] = sc.next ();
                if (chs[0].equals ( "Q" )){
                    int low = Integer.parseInt ( chs[1] );
                    int high = Integer.parseInt ( chs[2] );
                    int max = maxScore ( score,low-1,high-1 );
                    System.out.println (max);
                } else if (chs[0].equals ( "U" )){
                    int index= Integer.parseInt(chs[1]);
                    int scoreCh = Integer.parseInt ( chs[2] );
                    score[index-1] = scoreCh;
                }
            }
        }
    }

    private static int maxScore(int[] num,int low,int high){
        if (low > high){
            int tmp = low;
            low = high;
            high = tmp;
        }
        int max = num[low];
        for (int i=low;i<=high;i++)
            if (num[i] > max)
                max=num[i];
        return max;
    }
}
