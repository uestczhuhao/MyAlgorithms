package WorkToOfferAttach;

/**
 * Created by zhuhao on 17-6-24.
 */
public class TestClass {
    public static void main(String[] args) {
//        testMGroup ();
        testIsAnagram();
    }

    public static void testMGroup(){
        MGroupOfNlengthString test = new MGroupOfNlengthString ();
        String str = "abcd";
        test.mGroupOfNlengthString ( str );
    }

    public static void testIsAnagram(){
        IsAnagramString test = new IsAnagramString ();
        String s1 = "livee";
        String s2 = "evill";
        boolean isOrNot=test.isAnagram ( s1,s2 );
        System.out.println (isOrNot);
    }
}
