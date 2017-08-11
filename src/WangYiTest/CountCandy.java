package WangYiTest;

import java.util.Scanner;

/**
 * Created by zhuhao on 17-8-11.
 */
public class CountCandy {
    private static int A=0,B=0,C=0;
    private static boolean isNormal = true;
    public static void main(String[] args) {
        Scanner in = new Scanner ( System.in );
        while (in.hasNextLine ()){
            String str = in.nextLine ();
            String[] strs = str.split ( " " );
            if (strs == null || strs.length !=4)
                return;

            int n1 = Integer.parseInt ( strs[0] );
            int n2 = Integer.parseInt ( strs[1] );
            int n3 = Integer.parseInt ( strs[2] );
            int n4 = Integer.parseInt ( strs[3] );


            countCore(n1,n2,n3,n4);
            if (isNormal)
                System.out.println (A+" "+B+" "+C);
            else
                System.out.println ("No");

        }
    }

    private static void countCore(int n1,int n2,int n3,int n4){

        A = (n1+n3)/2;
        B = (n2+n4)/2;
        C = (n4-n2)/2;

        if (((n1+n3)%2) !=0 || ((n2+n4)%2) !=0 || ((n4-n2)%2) !=0){
            isNormal = false;
            return;
        }
        if ((A-B) != n1 || (B-C) != n2 || (A+B) != n3 || (B+C) != n4){
            System.out.println ("Comming B");

            isNormal = false;
            return;
        }
    }
}
