package WangYiTest.WangYi0812;

import java.util.Scanner;

/**
 * Created by zhuhao on 17-8-12.
 */
public class Servive {
    public static void main(String[] args) {
        Scanner in = new Scanner ( System.in );
        while (in.hasNext ()){
            int x = in.nextInt ();
            int f = in.nextInt ();
            int d = in.nextInt ();
            int p = in.nextInt ();
            if (x<0 || f<0 || d<0 || p<0)
                return;
            int days =service ( x,f,d,p );

            System.out.println (days);

        }
    }

    private static int service(int x,int f,int d,int p){
        int days = 0,intiDays = f;
        if (d < x) return 0;

        ///第一种情况，水果富裕，所有的钱全部交房租
        if (d <= intiDays*x){
            for (int i = intiDays;i>0;i--){
                if (d >= i*x)
                    return i;
            }
        } else {
            d = d-intiDays*x;
            days+=intiDays;
            days+= d/(p+x);
        }

        return days;
    }
}
