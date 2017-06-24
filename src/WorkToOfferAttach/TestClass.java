package WorkToOfferAttach;

/**
 * Created by zhuhao on 17-6-24.
 */
public class TestClass {
    public static void main(String[] args) {
        testMGroup ();
    }

    public static void testMGroup(){
        MGroupOfNlengthString test = new MGroupOfNlengthString ();
        String str = "abcd";
        test.mGroupOfNlengthString ( str );
    }
}
