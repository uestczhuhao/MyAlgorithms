package HuaWei;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by zhuhao on 17-8-15.
 */
public class SubString {
    public static void main(String[] args) {
        Scanner sc = new Scanner ( System.in );
        while (sc.hasNext ()){
            String str = sc.next ();
            char[] chs = str.toCharArray ();
            StringBuilder strB = new StringBuilder (  );
            HashMap<Character,Integer> map = new HashMap<> (  );
            for (int i=0;i<chs.length;i++){
                if (map.get ( chs[i] )==null){
                    strB.append ( chs[i] );
                    map.put ( chs[i],1 );
                }
            }
            System.out.println (strB.toString ());
        }
    }
}
