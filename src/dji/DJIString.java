package dji;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by zhuhao on 17-8-26.
 */
public class DJIString {
    public static void main(String[] args) {
        Scanner sc = new Scanner ( System.in );
        while (sc.hasNext ()){
            int n = sc.nextInt ();
            String[] strs = new String[n];
            sc.nextLine ();
            for (int i=0;i<n;i++){
                strs[i] = sc.nextLine ();
            }

            for (int i=0;i<n;i++){
                System.out.println (countCore ( strs[i] ));
            }
        }
    }

    public static int countCore(String str){
        int count = 0;
        char[] chs= str.toCharArray ();
        for (int i=0;i<str.length ();i++){
            if (chs[i] == 'd')
                count++;
        }
        return count;
    }
}
