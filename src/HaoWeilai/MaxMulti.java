package HaoWeilai;

import java.util.Scanner;

/**
 * Created by zhuhao on 17-8-1.
 */
public class MaxMulti {
    public static void main(String[] args) {
        Scanner in = new Scanner ( System.in );
        String nStr = in.nextLine ();
        String arrStr = in.nextLine ();

        int n = Integer.parseInt ( nStr );
        String[] strs = arrStr.split ( " " );
        if (strs.length != n || n<3 || strs.length<3 || strs == null || strs.length == 0)
            return ;
        int[] arr = new int[n];
        for (int i=0;i<n;i++)
            arr[i] = Integer.parseInt ( strs[i] );

        int result = findMax(arr);
        System.out.println (result);
    }

    public static int findMax(int[] arr){
        if (arr == null || arr.length < 3 )
            return 0;

        int maxMul = Integer.MIN_VALUE;
        int currMul = arr[0]*arr[1]*arr[2];
        if (currMul>maxMul)
            maxMul = currMul;
        int p0=0,p1=1,p2=2;
        for (int i=3;i<arr.length;i++){

            int sum1 = arr[p0]*arr[p1]*arr[i];
            int sum2 = arr[p0]*arr[p2]*arr[i];
            int sum3 = arr[p1]*arr[p2]*arr[i];
            if (max3 ( sum1,sum2,sum3 ) == sum1)
                p2 = i;
            else if (max3 ( sum1,sum2,sum3 ) == sum2)
                p1 = i;
            else if (max3 ( sum1,sum2,sum3 ) == sum3)
                p0 = i;


            currMul = arr[p0]*arr[p1]*arr[p2];
            if (currMul>maxMul)
                maxMul = currMul;
        }

        return maxMul;
    }

    public static int max3(int a,int b,int c){
        int max=a;
        if (b>max)
            max = b;
        if (c>max)
            max = c;
        return max;
    }
}
