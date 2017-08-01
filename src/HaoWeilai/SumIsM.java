package HaoWeilai;

/**
 * Created by zhuhao on 17-8-1.
 * 输入两个整数 n 和 m，从数列1，2，3…….n 中 随意取几个数, 使其和等于 m
 *
 *
 * 类似这种组合问题一般都是使用递归的策略，考虑到n个数和为m,
 * 假设要解决的函数为f(n,m), 假设我们选择了第n个数，那么问题就变成了f(n-1,m-n)，
 * 否则的话问题就是f(n-1,m),
 * 再考虑下边界条件： 如果n<1 或者 m<1显然不会有结果，
 * 如果n==m，那么显然可以输出一个结果了,然后问题就变成了f(m-1,m)
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
public class SumIsM {
    public static ArrayList<ArrayList<Integer>> result = new ArrayList<> (  );
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        int n = in.nextInt ();
        int m = in.nextInt ();
        findCore ( n,m );
        Collections.sort ( result, new Comparator<ArrayList<Integer>> () {
            @Override
            public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
                if (a==null || a.size ()==0 || b==null || b.size()==0 )
                    return 0;
                if (a.get ( 0 )>b.get ( 0 ))
                    return 1;
                if (a.get ( 0 )<b.get ( 0 ))
                    return -1;
                return 0;
            }
        } );
        for (ArrayList<Integer> tmp:result){
            for (int i=0;i<tmp.size ();i++){
                System.out.print (tmp.get ( i ));
                if (i!=tmp.size ()-1)
                    System.out.print (" ");
            }
            System.out.println ();
        }
    }

    public static void findCore(int n,int m){
        if (n<0 || m<0 || m>=2*n){
            return;
        }


        int low = 1,high = n;
        while (low<high){
            if (low == m || high == m){
                if (low == m){
                    ArrayList<Integer> arr = new ArrayList<> (  );
                    arr.add ( low );
                    result.add ( arr );
                    break;
                }
                if (high == m){
                    ArrayList<Integer> arr = new ArrayList<> (  );
                    arr.add ( high );
                    result.add ( arr );
                    high--;
                    continue;
                }
            }
            int sum=low+high;
            if (sum>m)
                high--;
            else if (sum<m)
                low++;
            else{
                ArrayList<Integer> arr = new ArrayList<> (  );
                arr.add ( low );
                arr.add ( high );
                result.add ( arr );
                low++;
                high--;
             }
        }

        return result;
    }
}
