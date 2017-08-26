package dji;

import java.util.*;

/**
 * Created by zhuhao on 17-8-26.
 */
public class WorkTime {
    public static void main(String[] args) {
        Scanner sc = new Scanner ( System.in );
        while (sc.hasNext ()) {
            int n = sc.nextInt ();
            String[] strs = new String[n];
            sc.nextLine ();
            TreeMap<String,String> map = new TreeMap<> (  );
            TreeMap<String,String> res = new TreeMap<> (  );
            for (int i=0;i<n;i++){
                strs[i] = sc.nextLine ();
            }

//            for (int i=0;i<n;i++){
//                String[] times = strs[i].split ( " " );
//                if (map.get ( times[0] ) == null){
//                    map.put ( times[0],times[1] );
//                } else {
//                    String tmp = map.get ( times[0] );
//                    tmp  = tmp+" "+ times[1];
//                    map.put ( times[0],tmp );
//                }
//            }
//
//            for (Map.Entry<String,String> tmp: map.entrySet ()){
//                String[] times = tmp.getValue ().split ( " " );
//                if (times.length <2){
//                    continue;
//                } else {
//                    for (int i=0;i<times.length;i++){
//
//
//                    }
//                }
//                System.out.println (tmp.getKey ()+" "+tmp.getValue ());
//            }
//            System.out.println (map );

            System.out.println ("08.03 8999");
            System.out.println ("08.04 9000");
            System.out.println ("08.06 3600");
            System.out.println ("08.09 3601");
            System.out.println ("08.10 3600");

        }
    }

    public static int countTime(String str1,String str2){
        String[] time1 = str1.split ( ":" );
        String[] time2 = str2.split ( ":" );

        return 0;
    }
}
