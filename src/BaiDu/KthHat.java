package BaiDu;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by zhuhao on 17-8-19.
 */
public class KthHat {
    public static void main(String[] args) {
        Scanner sc = new Scanner ( System.in );
        TreeSet<Integer> set = new TreeSet<> ( new Comparator<Integer> () {
            @Override
            public int compare(Integer t1, Integer t2) {
                return t1-t2;
            }
        } );
        while (sc.hasNext ()){
            int n = sc.nextInt ();
            for (int i=0;i<n;i++)
                set.add ( sc.nextInt () );

            if (set.size ()<3){
                System.out.println (-1);
                return;
            }
            set.pollFirst ();
            set.pollFirst ();
            System.out.println (set.pollFirst ());
        }
    }
}
