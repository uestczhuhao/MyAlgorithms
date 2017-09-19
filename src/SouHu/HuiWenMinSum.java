package SouHu;

import java.util.Scanner;

/**
 * Created by zhuhao on 17-9-17.
 */
public class HuiWenMinSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner ( System.in );
        while (sc.hasNext ()){
            int n = sc.nextInt ();
            int[] arr = new int[n];
            long sum = 0;
            for (int i=0;i<n;i++){
                arr[i] =sc.nextInt ();
                sum += arr[i];
            }
//
//            int arrRe[] = new int[n];
//            boolean visit[] = new boolean[n];
//            for (int i=0;i<n;i++){
//                arrRe[i] = arr[n-1-i];
//            }
//            countLength(arr,arrRe,arr.length,visit);
            int low = 0,high = n-1;
            long sumCopy = sum;
            while (low<=high){
                if (arr[low] == arr[high]){
                    low++; high--;
                } else {
                    if (high-1 != low && arr[low]==arr[high-1]){
                        sum += arr[high];
                        high--;
                    } else {
                        sum += arr[low];
                        low++;
                    }
                }
            }
            low = 0;high = n-1;
            while (low<=high){
                if (arr[low] == arr[high]){
                    low++; high--;
                } else {
                    if (arr[low] > arr[high]){
                        sumCopy += arr[high];
                        high--;
                    } else {
                        sumCopy += arr[low];
                        low++;
                    }
                }
            }
            System.out.println (Math.min ( sum,sumCopy ));
        }
    }


//    public static void countLength(int[] arr1,int[] arr2,int n,boolean[] visit){
//        //dp[i][j]代表str1[0...i]与str2[0...j]的最长公共子序列的长度
//        int[] dp[] = new int[n][n];
//        dp[0][0] = arr1[0]== arr2[0]? 1:0;
//        for (int i=1;i<n;i++){
//            dp[i][0] = Math.max(dp[i-1][0],chs1[i]==chs2[0]? 1:0);
//        }
//        for (int j=1;j<m;j++)
//            dp[0][j] = Math.max(dp[0][j-1],chs1[0]==chs2[j]? 1:0);
//
//        for (int i=1;i<n;i++){
//            for (int j=1;j<m;j++){
//                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
//                if (chs1[i] == chs2[j]){
//                    dp[i][j] = Math.max(dp[i][j],dp[i-1][j-1]+1);
//                }
//            }
//        }
//
//        return dp[n-1][m-1];
//    }
}
