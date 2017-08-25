package Didi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by zhuhao on 17-8-24.
 * 某餐馆有n张桌子，每张桌子有一个参数：a 可容纳的最大人数； 有m批客人，每批客人有两个参数:b人数，c预计消费金额。 在不允许拼桌的情况下，请实现一个算法选择其中一部分客人，使得总预计消费金额最大
 输入描述:
 输入包括m+2行。
 第一行两个整数n(1 <= n <= 50000),m(1 <= m <= 50000)
 第二行为n个参数a,即每个桌子可容纳的最大人数,以空格分隔,范围均在32位int范围内。
 接下来m行，每行两个参数b,c。分别表示第i批客人的人数和预计消费金额,以空格分隔,范围均在32位int范围内。
 输出描述:
 输出一个整数,表示最大的总预计消费金额
 示例1
 输入

 3 5
 2 4 2
 1 3
 3 5
 3 7
 5 9
 1 10
 输出

 20
 */
public class Restaurant {
    public static void main(String[] args) {
        Scanner sc = new Scanner ( System.in );
        while (sc.hasNext ()){
            int n =sc.nextInt ();
            int m =sc.nextInt ();
            int[] capacity = new int[n];
            for (int i=0;i<n;i++)
                capacity[i] = sc.nextInt ();

            Arrays.sort (capacity);
            PriorityQueue<Customer> que = new PriorityQueue<> (  );
            for (int i=0;i<m;i++){
                int num = sc.nextInt ();
                int spent = sc.nextInt ();
                que.add ( new Customer ( num,spent ) );
            }

//            for (int i=0;i<5;i++){
//                Customer tmp = que.poll ();
//                System.out.println (tmp.getNum ()+" "+tmp.getSpent ());
//            }


            long result =0;
            int[] visited = new int[n];
            while (!que.isEmpty ()){
                Customer customer = que.poll ();
                for (int i=0;i<n;i++){
                    if (customer.getNum () <= capacity[i] && visited[i]==0){
                        visited[i] = 1;
                        result+=customer.getSpent ();
                        break;
                    }
                }
            }
            System.out.println (result);
        }
    }

    static class Customer implements Comparable<Customer>{
        private int num;
        private int spent;

        public Customer(){
            this.num =0;
            this.spent =0;
        }

        public Customer(int num,int spent){
            this.num =num;
            this.spent =spent;
        }

        public int getNum(){
            return this.num;
        }
        public int getSpent(){
            return this.spent;
        }

        @Override
        public int compareTo(Customer t){
            return t.spent-this.spent;
        }
    }
}
