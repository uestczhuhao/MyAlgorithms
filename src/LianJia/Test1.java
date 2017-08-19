package LianJia;

import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by zhuhao on 17-8-19.
 *
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner ( System.in );
        while (sc.hasNext ()){
            int n = sc.nextInt ();
            TreeSet<Integer> set = new TreeSet<> ( new Comparator<Integer> () {
                @Override
                public int compare(Integer t0, Integer t1) {
                    return t0-t1;
                }
            } );
            for (int i=0;i<n;i++){
                set.add ( sc.nextInt () );
            }
            int len = set.size ();
            System.out.println (set.size ());
            System.out.print (set.pollFirst ());
            for (int i=0;i<len-1;i++)
                System.out.print (" "+set.pollFirst ());
            System.out.println ();
        }
    }
}
