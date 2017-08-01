package HaoWeilai;

/**
 * Created by zhuhao on 17-8-1.
 */

import java.util.Scanner;
public class InverseString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine ();

        String result = reverse(str);
        System.out.println (result);
    }

    public static String reverse(String str){
        if (str==null || str.length () ==0)
            return null;

        String[] strs = str.split ( " " );
        for (int i=0;i<strs.length;i++){
            StringBuilder tmp = new StringBuilder ( strs[i] );
            strs[i] = tmp.toString ();
        }

        StringBuilder resultBul = new StringBuilder ( "" );
        for (int i=strs.length-1;i>=0;i--){
            resultBul.append ( strs[i] );
            if (i!=0)
                resultBul.append ( " " );
        }

        return resultBul.toString ();
    }
}
