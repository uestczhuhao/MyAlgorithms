package Tecent;

/**
 * Created by zhuhao on 17-8-15.
 */
import java.util.*;
public class GrayCode {

    public static void main(String[] args) {
        GrayCode ttt = new GrayCode ();
        String[] test = ttt.getGray ( 4 );
        System.out.println (Arrays.toString ( test ));
    }
    public String[] getGray(int n) {
        // write code here
        String[] res = new String[(int)Math.pow ( 2,n )];
        if (n==1){
            res[0] = "0";
            res[1] = "1";
            return res;
        }

        String[] tmp = getGray ( n-1 );
        for (int i=0;i<tmp.length;i++){
            res[i] = "0"+tmp[i];
            res[res.length-1-i] = "1" + tmp[i];
        }

        return res;
    }


}
