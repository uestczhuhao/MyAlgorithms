package HaoWeilai;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by zhuhao on 17-8-1.
 */
public class DeleteString1AppearAtString2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str1 = in.nextLine();
        String str2 = in.nextLine();

        str1= deleteCore ( str1,str2 );

        System.out.println (str1);
    }

    public static String deleteCore(String str1,String str2){
        if (str1 == null || str1.length ()==0 || str2==null)
            return null;

        StringBuilder strBul = new StringBuilder ( str1 );
//        int len = strBul.length ();
        HashMap<Character,Integer> map = new HashMap<> (  );
        char[] chs = str2.toCharArray ();
        for (char ch:chs){
            if (map.get ( ch )!=null)
                map.put ( ch,map.get ( ch )+1 );
            else
                map.put ( ch,1 );
        }

        StringBuilder tmp = new StringBuilder ( "" );
        for (int i=0;i<strBul.length ();i++){
            if (map.get ( strBul.charAt ( i ) ) == null)
                tmp.append ( strBul.charAt(i) );
        }

        return tmp.toString ();
    }
}
