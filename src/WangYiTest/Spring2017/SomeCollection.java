package WangYiTest.Spring2017;

import java.util.Scanner;

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
            System.out.println ((x-w+1)*(z-y+1));
        }
    }
}
