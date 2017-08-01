package HaoWeilai;

/**
 * Created by zhuhao on 17-8-1.
 * 输入两个整数 n 和 m，从数列1，2，3…….n 中 随意取几个数, 使其和等于 m
 *
 *
 * 先取初始值为1,然后依次累加，把序列存入数组arr中，
 * 下次递归时把m的值减去上次最后的值（即arr数组的最后一个）
 * 最后当m的值减到0时，arr中即为所求的序列
 */
import java.util.ArrayList;
import java.util.Scanner;

public class SumIsM {
    public static void main(String[] args) {
        Scanner in = new Scanner ( System.in );
        int n = in.nextInt ();
        int m = in.nextInt ();

        ArrayList<Integer> arr = new ArrayList<> (  );
        find ( n,m,arr,1 );

    }

    /**
     * 每次beg值累加，m值递减，知道m值递减为0时恰好就是要找的序列
     * @param m 每次递减，到0时截止
     * @param arr 存储序列，在m==0时输出
     */
    public static void find(int n,int m,ArrayList<Integer> arr,int beg){

        if (m == 0){
            for (int i=0;i<arr.size ();i++){
                System.out.print (arr.get ( i ));
                if (i != arr.size ()-1)
                    System.out.print (" ");
            }
            System.out.println ();
        }

        for (int i=beg;i<=n && i<=m;i++){
            arr.add ( i );
            find ( n,m-i,arr,i+1 );
            arr.remove ( arr.size ()-1 );
        }
    }
}
