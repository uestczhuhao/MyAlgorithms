package Didi;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by zhuhao on 17-8-24.
 * 输入一个正整数n,求n!(即阶乘)末尾有多少个0？ 比如: n = 10; n! = 3628800,所以答案为2
 输入描述:
 输入为一行，n(1 ≤ n ≤ 1000)
 输出描述:
 输出一个整数,即题目所求
 示例1
 输入

 10
 输出

 2
 */
public class Factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner ( System.in );
        while (sc.hasNext ()) {
            int n = sc.nextInt ();
            HashMap<Integer,Integer> map = new HashMap<> (  );
            map.put ( 2,0 );
            map.put ( 5,0 );
//            map.put ( 10,0 );
            for (int j=1;j<=n;j++) {
                int i = j;
                if (i % 2 == 0) {
                    int count = 0;
                    while (i != 1) {
                        count++;
                        i /= 2;
                        if (i % 2 != 0)
                            break;
                    }
                    count = map.get ( 2 ) + count;
                    map.put ( 2, count );
                }
                if (i % 5 == 0) {
                    if (i % 5 == 0) {
                        int count = 0;
                        while (i != 1) {
                            count++;
                            i /= 5;
                            if (i % 5 != 0)
                                break;
                        }
                        count = map.get ( 5 ) + count;
                        map.put ( 5, count );
                    }
                }
            }
            int min = map.get ( 2 );
            if (map.get ( 5 )< min)
                min = map.get ( 5 );
            System.out.println (min);
        }
    }
}
