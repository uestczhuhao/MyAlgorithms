/**
 * Created by zhuhao on 17-6-10.
 */
import java.lang.reflect.Field;
import java.lang.reflect.Method;
public class SugerTest {
    public static void main(String[] args) throws Exception {
//        Integer a=1;
//        Integer b=1;
//        Integer c=128;
//        Integer d=128;
//        Class<?> tClass = Class.forName ( "java.util.ArrayList" );
//        Field[] fields = tClass.getFields ();
//        for (Field field:fields){
//            System.out.println (field);
//        }
//
//        System.out.println (a == b);
//        System.out.println (c == d);
//        System.out.println (a.equals ( b ));
//        System.out.println (c.equals ( d ));
////        System.out.println (c == (a+b));
////        System.out.println (c.equals (a+b));
////        System.out.println (g == (a+b));
////        System.out.println (g.equals (a+b));


    }
}


class A {
    public void belongA(){
        System.out.println ("Just Belong A!");
    }
}

class B extends A{
    public void belongA(){
        System.out.println ("B extend A!");
    }

    public void belongB(){
        System.out.println ("Just belong B!");
    }
}
