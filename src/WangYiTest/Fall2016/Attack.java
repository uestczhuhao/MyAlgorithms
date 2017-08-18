package WangYiTest.Fall2016;

import java.util.Scanner;

/**
 * Created by zhuhao on 17-8-18.
 */
public class Attack {
    public static void main(String[] args) {
        Scanner sc = new Scanner ( System.in );
        while (sc.hasNext ()){
            int R = sc.nextInt ();
            int[] x =new int[3];
            int[] y =new int[3];
            for (int i=0;i<3;i++){
                x[i] = sc.nextInt ();
                y[i] = sc.nextInt ();
            }
            int x0,y0;
            x0 = sc.nextInt ();
            y0 = sc.nextInt ();
            int totalInj = 0;
            for (int i=0;i<3;i++){
                double dis = Math.sqrt ( Math.pow ( x0-x[i],2 )+Math.pow ( y0-y[i],2 ) );
                if (dis <= R)
                    totalInj++;
            }
            if (totalInj != 0)
                System.out.println (totalInj+"x");
            else
                System.out.println ("0x");
        }
    }
}
