package WangYiTest.Test0909;

import java.util.Arrays;
import java.util.Scanner;

public class ReOrder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int t = sc.nextInt();
            int[][] nums = new int[t][];
            for (int i=0;i<t;i++){
                int tmp = sc.nextInt();
                int odd =0,four = 0;
                for (int j=0;j<tmp;j++){
                    int in = sc.nextInt();
                    if (in % 2 ==1)
                        odd++;
                    if (in % 4 ==0)
                        four++;
                }
                if (four > odd-1)
                    System.out.println("Yes");
                else
                    System.out.println("No");
            }

//            for (int i=0;i<t;i++){
//                int odd =0,four = 0;
//                int len = nums[i].length;
//                for(int j=0;j<len;j++){
//                    if (nums[i][j] % 2 ==1)
//                        odd++;
//                    if (nums[i][j] % 4 ==0)
//                        four++;
//                }
//                if (four > odd-1)
//                    System.out.println("Yes");
//                else
//                    System.out.println("No");
//            }

        }


    }
}
