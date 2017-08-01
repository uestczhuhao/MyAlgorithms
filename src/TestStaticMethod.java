/**
 * Created by zhuhao on 17-7-24.
 */
public class TestStaticMethod {

    public static void test0724Static(){

        System.out.println ("Static Method");
    }

    static {
        System.out.println ("Static Block");
    }

    public static void main(String[] args) {
        float oD = 3.0f;
        
        System.out.println (oD);
        System.out.println ("Main Method");
    }
}
