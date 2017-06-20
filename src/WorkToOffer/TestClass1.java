package WorkToOffer;

/**
 * Created by zhuhao on 17-6-17.
 */
public class TestClass1 {
    public static void main(String[] args) {
//        testReverseString ();
//        testLeftRotate();
//        testIsContinus();
//        testLastRemaing();
//        testStrToInt();
        testIsNumeric ();
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

    public static void testIsContinus(){
        IsContinous test = new IsContinous ();
        int[] arr= {1,2,4,6,0};
        boolean re = test.isContinuous ( arr );
        System.out.println (re);
    }

    public static void testLastRemaing(){
        LastRemaining test = new LastRemaining ();
        int re = test.LastRemaining_Solution ( 5,3 );
        System.out.println (re);
    }

    public static void testStrToInt(){
        StrToInt test = new StrToInt ();
        String str = "112a23";
        int re = test.StrToInt ( str );
        System.out.println (re);
    }

    public static void testIsNumeric(){
        IsNumeric test = new IsNumeric ();
        String str= "5e2.21";
        char[] chs = str.toCharArray ();
        boolean re =test.isNumeric ( chs );
        System.out.println (re);
    }
}
