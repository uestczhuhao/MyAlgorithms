package Alibaba.Test0825;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
public class Test1 {
/** 请完成下面这个process函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    private static int process(int lo,int wid,int high,Model[] items) {
        int n = items.length;
        int[] tmpBox = new int[3];
        tmpBox[0] = lo;
        tmpBox[1] = wid;
        tmpBox[2] = high;
        Arrays.sort (tmpBox);
        int[] dp = new int[n+1];
        dp[0] = 0;
        int remain1=0,remain2=0,remain0=0;
        for (int i=0;i<n;i++){
            if (items[i].price<=CUSTOMS_LIMIT_MONEY_PER_BOX){
                int[] tmpItem = new int[3];
                tmpItem[0] = items[i].length;
                tmpItem[1] = items[i].width;
                tmpItem[2] = items[i].height;
                Arrays.sort (tmpItem);
//                tmpItem[0]+=remain0;
//                tmpItem[1]+=remain1;
//                tmpItem[2]+=remain2;
                if (tmpItem[0] > tmpBox[0] || tmpItem[1] > tmpBox[1] || tmpItem[2] > tmpBox[2]){
                    return -1;
                } else if (remain0 >= tmpItem[0] && remain1 >= tmpItem[1] && remain2 >= tmpItem[2]){
                    dp[i] = dp[i-1];
                    remain0 -= tmpItem[0];
                    remain1 -= tmpItem[1];
                    remain2 -= tmpItem[2];
                } else {
                    remain0 = tmpBox[0]-tmpItem[0];
                    remain1 = tmpBox[1]-tmpItem[1];
                    remain2 = tmpBox[2]-tmpItem[2];
                    dp[i] = dp[i-1]+1;
                }
            } else {
                dp[i] = dp[i-1] +items[i].price/CUSTOMS_LIMIT_MONEY_PER_BOX+1;
            }
        }
        return dp[n];
    }
    public static final int CUSTOMS_LIMIT_MONEY_PER_BOX=2000;
    public static int boxMinNum = Integer.MAX_VALUE;;
    public static void main(String args[]){
        Scanner sc = new Scanner ( System.in );
        while(sc.hasNext ()) {
            int boxLong = sc.nextInt ();
            int boxWidth = sc.nextInt ();
            int boxHigh = sc.nextInt ();

            int n = sc.nextInt ();
            Model[] items = new Model[n];
            for(int i=0; i<n; i++){
                Model item = new Model();
                item.price = sc.nextInt();
                item.length = sc.nextInt();
                item.width = sc.nextInt();
                item.height = sc.nextInt();
                items[i] = item;
            }

            long startTime = System.currentTimeMillis();

            System.out.println (process(boxLong,boxWidth,boxHigh,items));
        }
    }

    static class Model{
        int price;
        int length;
        int width;
        int height;
    }



}