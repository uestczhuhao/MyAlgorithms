package KeDaXunFei;

import java.util.*;

/**
 * Created by zhuhao on 17-9-16.
 */
public class Test03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner ( System.in );
        while (sc.hasNext ()) {
            int n = sc.nextInt ();
            sc.nextLine ();
            Set<String> set = new HashSet<> (  );
            HashMap<String,String> map = new HashMap<> (  );
            String[] input = new String[n];
            for (int i=0;i<n;i++){
                String tmp = sc.nextLine ();
                String[] str = tmp.split ( " " );
                set.add ( str[0] );
                input[i] = tmp;
                if (!map.isEmpty () && map.get ( str[0] )!=null){
                    String tmp1 = map.get ( str[0] );
                    tmp1 = tmp1 +" "+ str[1];
                    map.put ( str[0],tmp1 );
                } else {
                    map.put ( str[0],str[1] );
                }
            }
            if (n == set.size ()){
                System.out.println ("YES");
            } else {
                TreeMap<String,String> map2 = new TreeMap<> ( new Comparator<String> () {
                    @Override
                    public int compare(String s, String t1) {
                        return s.compareTo ( t1 );
                    }
                } );
                map2.putAll ( map );
                Iterator iter=map2.entrySet().iterator();
                while (iter.hasNext ()){
                    Map.Entry ent=(Map.Entry )iter.next();
                    String valuet=ent.getValue().toString();
                    if (valuet.length ()>6){
                        String keyt=ent.getKey().toString();
                        System.out.println(keyt+" "+valuet);
                    }
                }
            }
        }
    }
}
