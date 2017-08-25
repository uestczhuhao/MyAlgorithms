package Didi;

import java.util.*;

/**
 * Created by zhuhao on 17-8-24.
 * 给定一个有n个正整数的数组A和一个整数sum,求选择数组A中部分数字和为sum的方案数。
 当两种选取方案有一个数字的下标不一样,我们就认为是不同的组成方案。
 输入描述:
 输入为两行:

 第一行为两个正整数n(1 ≤ n ≤ 1000)，sum(1 ≤ sum ≤ 1000)

 第二行为n个正整数A[i](32位整数)，以空格隔开。
 输出描述:
 输出所求的方案数
 示例1
 输入

 5 15
 5 5 10 2 3
 输出

 4
 */
public class CountSumNumber {
    public static ArrayList<ArrayList<Integer>> lists = new ArrayList<> (  );
//    public static void main(String[] args) {
//        Scanner sc = new Scanner ( System.in );
//        while(sc.hasNext ()) {
//            int n = sc.nextInt ();
//            int sum = sc.nextInt ();
//            int[] arr = new int[n];
//            for (int i=0;i<n;i++){
//                arr[i] = sc.nextInt ();
//            }
//            Arrays.sort (arr);
//            int[] visited = new int[n];
//            findSubArray ( arr,visited,0,sum,0 );
//
//            TreeSet<ArrayList<Integer>> res = new TreeSet<> ( new Comparator<ArrayList<Integer>> () {
//                @Override
//                public int compare(ArrayList<Integer> t0, ArrayList<Integer> t1) {
//                    if (t0.size () != t1.size ()){
//                        return t1.size ()-t0.size ();
//                    } else {
//                        int len = t0.size ();
//                        Collections.sort ( t0 );
//                        Collections.sort ( t1 );
//                        for (int i=0;i<len;i++){
//                            if (t0.get ( i ) != t1.get ( i )){
//                                return t0.get ( i )-t1.get ( i );
//                            }
//                        }
//                        return 0;
//                    }
//                }
//            } );
//            res.addAll ( lists );
////            System.out.println (lists);
////            System.out.println (res);
////            Iterator<ArrayList<Integer>> tmp = res.descendingIterator ();
////            while (tmp.hasNext ()){
////                System.out.println (tmp.next ());
////            }
//            System.out.println (res.size ());
//        }
//    }

    public static void findSubArray(int[] arr,int[] visited,int index,int key,int currSum){
        int n = arr.length;
        if (currSum > key)
            return;
        if (currSum == key){
            ArrayList<Integer> list = new ArrayList<> (  );
            for (int i=0;i<n;i++){
                if (visited[i] == 1)
                    list.add ( arr[i] );
            }
            lists.add ( list );
            return;
        }

        for (int i=index;i<n;i++){
            if (visited[i] == 0){
                currSum+=arr[i];
                visited[i] = 1;
                findSubArray ( arr,visited,index+1,key,currSum );
                currSum -= arr[i];
                visited[i] =0;
            }
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner ( System.in );
        while(sc.hasNext ()) {
            int n = sc.nextInt ();
            int sum = sc.nextInt ();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt ();
            }

            //dp[i][j]代表用前i个数组成和为j的方法数
            long[][] dp = new long[n][sum+1];
            dp[0][0] =1;
            for (int i=0;i<n;i++){
                dp[i][0] = 1;
            }
            if (arr[0] <=sum)
                dp[0][arr[0]] = 1;
            for (int i=1;i<n;i++){
                for (int j=1;j<=sum;j++){
                    if (j < arr[i])
                        dp[i][j] = dp[i-1][j];
                    else {
                        //dp[i][j]代表用前i个数组成和为j的方法数
                        //其数量等于前i-1个数的组合组成和为j，即第i个不用，
                        //加上前i-1个数的组合组成和为j-arr[i]
                        dp[i][j] = dp[i-1][j-arr[i]]+ dp[i-1][j];
                    }
                }
            }
            System.out.println (dp[n-1][sum]);
        }
    }
}
