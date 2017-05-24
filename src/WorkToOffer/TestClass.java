package WorkToOffer;

/**
 * Created by zhuhao on 17-5-22.
 */
public class TestClass {
    public static void main(String[] args) {
        testReplaceSpace ();
    }

    public static void testReplaceSpace(){
        String str1 = "hello world";
        ReplaceSpace test = new ReplaceSpace ();

        StringBuffer str = new StringBuffer ( str1 );
        String result = test.replaceSpace ( str );
        System.out.println (result);
    }
}
