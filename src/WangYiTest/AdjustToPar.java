package WangYiTest;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by zhuhao on 17-8-11.
 */
public class AdjustToPar {
    public static void main(String[] args) {
        Scanner in = new Scanner ( System.in );
        while (in.hasNextLine ()){
            int n = in.nextInt ();
            in.nextLine ();
            String str = in.nextLine ();
            String[] strs = str.split ( " " );

            if (n != strs.length)
                return;

            int[] ints = new int[n];
            for (int i=0;i<n;i++)
                ints[i] = Integer.parseInt ( strs[i] );

            int result = countCore ( n,ints );
            System.out.println ( result);
        }
//        int[] arr = {1,2};
//        System.out.println (isPar ( arr ));
    }

    private static int countCore(int n,int[] arr){
        int result = 0;
        if (isPar ( arr ))
            return 0;


        return result;
    }

    private static boolean isPar(int[] arr){
        if (arr == null || arr.length == 0)
            return false;
        for (int i=0;i<arr.length/2;i++){
            if (arr[i] != arr[arr.length-1-i]){
                return false;
            }
        }

        return true;
    }
}
