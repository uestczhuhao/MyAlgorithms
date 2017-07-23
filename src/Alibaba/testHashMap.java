package Alibaba;

import java.util.HashMap;
import java.util.Random;

/**
 * Created by zhuhao on 17-7-11.
 */
public class testHashMap {
    public static void main(String[] args) {
        HashMap<Object,Integer> test = new HashMap (  );
        test.put ( 1,null );
        test.put ( 2,null );
        test.put ( null,2 );
        test.put ( 3,5 );
        test.put ( 4,5 );
//        for (HashMap.Entry<Object,Integer> tmp:test.entrySet ()){
//            System.out.println (tmp.getKey ()+ "  "+tmp.getValue ());
//        }
        Random ran = new Random (  );
        System.out.println (ran.nextInt (10)+1);
    }
}
