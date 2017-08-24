package TouTiao.Test2017;

import java.util.Scanner;

/**
 * Created by zhuhao on 17-8-23.
 你作为一名出道的歌手终于要出自己的第一份专辑了，你计划收录 n 首歌而且每首歌的长度都是 s 秒，每首歌必须完整地收录于一张 CD
 当中。每张 CD 的容量长度都是 L 秒，而且你至少得保证同一张 CD 内相邻两首歌中间至少要隔 1 秒。为了辟邪，你决定任意一张 CD
 内的歌数不能被 13 这个数字整除，那么请问你出这张专辑至少需要多少张 CD ？

 输入描述:
 每组测试用例仅包含一组数据，每组数据第一行为三个正整数 n, s, L。 保证 n ≤ 100 , s ≤ L ≤ 10000


 输出描述:
 输出一个整数代表你至少需要的 CD 数量。

 示例1

 输入

 7 2 6

 输出

 4
 */
public class CDNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner ( System.in );
        while (sc.hasNext ()){
            int n = sc.nextInt ();
            int s = sc.nextInt ();
            int l = sc.nextInt ();
            int result =countCD ( n,s,l );
            System.out.println (result);
        }
    }

    public static int countCD(int n,int s,int l){
        int everyCD = l/(s+1);
        while (everyCD <= n){
            if (s*everyCD + everyCD-1 <=l && s*(everyCD+1)+everyCD > l)
                break;
            everyCD++;
        }
        everyCD = Math.min ( everyCD,n );
        if (everyCD % 13 ==0)
            everyCD--;


        int result = n/everyCD;
        int remain = n%everyCD;
        if (remain != 0){
            result ++;
            if (remain %13 ==0 && (everyCD-remain)==1 )
                result++;
        }
//        if (n%everyCD == 0){
//            //证明一张专辑可以放完，但是此时n是13的倍数，输出2
//            if (n <= everyCD && n%13==0)
//                return 2;
//
//            return n/everyCD;
//        } else {
//            int tmp = n%everyCD;
//            if (tmp % 13 ==0)
//                return n/everyCD+2;
//            return n/everyCD+1;
//        }
        return result;
    }
}
