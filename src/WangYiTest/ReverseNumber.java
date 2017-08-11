package WangYiTest;

import java.util.Scanner;

/**
 * Created by zhuhao on 17-8-11.
 */
public class ReverseNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner ( System.in );
        int x = in.nextInt ();
        int y = in.nextInt ();
        int result = reverseCore ( x )+reverseCore ( y );
        result = reverseCore ( result );
        System.out.println (result);
    }

    private static int reverseCore(int n){
        int result=0;
        int index = 0,tmp = n;
        while (tmp > 0){
            tmp /=10;
            index++;
        }
        int i=0;
        while (i<index){
            tmp = n % 10;
            while (tmp == 0){
                n = n/10;
                tmp = n%10;
                i++;
            }
            result += tmp*Math.pow ( 10,index-i-1 );
            n = n/10;
            i++;
        }
        return result;
    }
}
