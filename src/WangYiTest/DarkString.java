package WangYiTest;

import java.util.Scanner;

/**
 * Created by zhuhao on 17-8-11.
 */
public class DarkString {
    public static void main(String[] args) {
        Scanner in = new Scanner ( System.in );
        while (in.hasNextLine ()){
            int n = in.nextInt ();
            if (n<=0)
                return;
            int result = countCore ( n );
            System.out.println (result);
        }

        in.close ();
    }

    private static int countCore(int n){
        if (n<3)
            return (int) Math.pow ( 3,n );


        return 0;
    }
}
