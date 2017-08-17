package WangYiTest.Spring2017;

import java.util.Scanner;

/**
 * Created by zhuhao on 17-8-17.
 */
public class WalkOrTaxi {
    public static void main(String[] args) {
        Scanner sc = new Scanner ( System.in );
        while (sc.hasNext ()){
            int n = sc.nextInt ();
            int[] x = new int[n];
            int[] y = new int[n];
            for (int i=0;i<n;i++)
                x[i] = sc.nextInt ();
            for (int i=0;i<n;i++)
                y[i] = sc.nextInt ();

            int xDes,yDes,walkT,taxiT;
            xDes = sc.nextInt ();
            yDes = sc.nextInt ();
            walkT =sc.nextInt ();
            taxiT =sc.nextInt ();
            //步行到办公室所需时间
            int walkTotleTime = walkT*(Math.abs ( xDes )+Math.abs ( yDes ));
//            System.out.println ("walkTotleTime = "+walkTotleTime);
            int toleTimeTaxiAndWalk = Integer.MAX_VALUE;
            for (int i=0;i<n;i++){
                int tmp1 = walkT*(Math.abs ( x[i] )+Math.abs ( y[i] ));
                int tmp2 = tmp1 + (Math.abs ( xDes-x[i] )+Math.abs ( yDes-y[i] ))*taxiT;
//                System.out.println ("xi="+x[i]+"yi = "+y[i]+" "+tmp1+" " +tmp2);
                if (tmp2 < toleTimeTaxiAndWalk)
                    toleTimeTaxiAndWalk = tmp2;
            }
            int res = walkTotleTime < toleTimeTaxiAndWalk ? walkTotleTime:toleTimeTaxiAndWalk;
            System.out.println (res);
        }
    }
}
