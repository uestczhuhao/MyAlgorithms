import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * Created by zhuhao on 17-9-3.
 */
public class TestWeakHashMap {
    public static void main(String[] args) {
        String a = new String("a");
        String b = new String("b");
        HashMap<String,String> map1 = new HashMap<> (  );
        WeakHashMap<String,String> map2 = new WeakHashMap<> (  );

        map1.put ( a,"aaa" );
        map1.put ( b,"bbb" );
        map2.put ( a,"aaa" );
        map2.put ( b,"bbb" );

        map1.remove ( a );

        a = null;
        b = null;
        System.gc ();

        for (Map.Entry<String,String> tmp : map1.entrySet ()){
            System.out.println (tmp.getKey ()+" "+tmp.getValue ());
        }

        for (Map.Entry<String,String> tmp : map2.entrySet ()){
            System.out.println (tmp.getKey ()+" "+tmp.getValue ());
        }
    }
}
