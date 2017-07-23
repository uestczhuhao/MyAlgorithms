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
        System.out.println (kmp.indexOf ( "aaaaabcdef","aaaaax" ));

//        System.out.println (Arrays.toString ( kmp.getNext ( "aaaaaaaab" ) ));
        String str = "abcabc";
        System.out.println ( Arrays.toString ( kmp.getNextVal ( str ) ));
        System.out.println (Arrays.toString ( getNextVal ( str ) ));
    }


    public static int[] getNextVal(String str){
        char[] chs = str.toCharArray ();
        int[] next = new int[str.length ()];
        int k=-1,j=0;
        next[0] =-1;

        while (j<str.length ()-1){
            if (k==-1 || chs[k] == chs[j]){
                k++;
                j++;
                if (chs[k] != chs[j])
                    next[j] = k;
                else
                    next[j] = next[k];
            } else
                k = next[k];
        }

        return next;
    }
}
