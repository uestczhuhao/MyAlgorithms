package WorkToOffer;

/**
 * Created by zhuhao on 17-6-17.
 */
public class TestClass1 {
    public static void main(String[] args) {
//        testReverseString ();
        testLeftRotate();
    }

    public static void testReverseString(){
        ReverseString test = new ReverseString ();
        String str1 = "I am a student.";
        String str = "   ";
        String re = test.ReverseSentence ( str );
        System.out.println ("Result ="+re);
    }

    public static void testLeftRotate(){
        LeftRotateString test = new LeftRotateString ();
        String str = "abcdefg";
        String re = test.LeftRotateString1 ( str,2 );
        System.out.println (re);
    }
}
