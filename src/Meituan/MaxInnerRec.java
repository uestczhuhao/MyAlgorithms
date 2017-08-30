package Meituan;

import java.util.Arrays;

/**
 * Created by zhuhao on 17-8-30.
 */
public class MaxInnerRec {
    public static void main(String[] args) {
        int[] A = {2,7,9,4,1};
        MaxInnerRec test = new MaxInnerRec ();
        System.out.println (test.countArea ( A,A.length ));
    }

    public int countArea(int[] A, int n) {
        // write code here
        int[] maxArea = new int[n];

        int left,right;
        for (int i=1;i<n-1;i++){
            left = i-1;
            right = i+1;
            while (left >= 0 &&A[left] >= A[i])
                left--;
//            System.out.println ("left = "+left);
            while (right<n && A[right] >= A[i])
                right++;
//            System.out.println ("right = "+right);

            maxArea[i] = A[i]*(right-left-1);
        }
        left = n-2;
        while (left >= 0 && A[left] >= A[n-1])
            left--;
        maxArea[n-1] = A[n-1]*(n-left-1);

        right = 1;
        while (right<n && A[right] >= A[0])
            right++;
        maxArea[0] = A[0]*(right);

//        System.out.println ( Arrays.toString (maxArea));
        int max = maxArea[0];
        for (int i=1;i<n;i++){
            if (maxArea[i] > max)
                max = maxArea[i];
        }

        return max;
    }
}
