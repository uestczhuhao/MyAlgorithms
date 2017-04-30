import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Created by zhuhao on 17-4-18.
 */
public class TestAlgorithm {
    public static void main(String[] args) {
        testKMPMatch ();
    }

    public static void testKMPMatch(){
//        kmp.print ();
//        VoilentMatch test = new VoilentMatch ();
//        int index= test.indexOf ("goodgoogle","google");
//        System.out.println (index);
        KMPMatch kmp = new KMPMatch ();
        System.out.println (kmp.indexOf ( "aaabaaa","aaab" ));

//        System.out.println (Arrays.toString ( kmp.getNext ( "aaaaaaaab" ) ));
        System.out.println ( Arrays.toString ( kmp.getNextVal ( "aaab" ) ));
    }
}
