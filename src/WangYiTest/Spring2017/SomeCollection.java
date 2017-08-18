package WangYiTest.Spring2017;

import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by zhuhao on 17-8-17.
 */
public class SomeCollection {
    public static void main(String[] args) {
        Scanner sc = new Scanner ( System.in );
        while (sc.hasNext ()) {
            int w = sc.nextInt ();
            int x = sc.nextInt ();
            int y = sc.nextInt ();
            int z = sc.nextInt ();
            TreeSet<Float> set = new TreeSet<> (  );
            for (int i=w;i<=x;i++){
                for (int j=y;j<=z;j++){
                    set.add ( (float)i/j );
                }
            }
            System.out.println (set.size ());
        }
    }
}
