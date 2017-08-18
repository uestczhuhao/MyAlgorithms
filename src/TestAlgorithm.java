import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by zhuhao on 17-4-18.
 */
public class TestAlgorithm {
    public static void main(String[] args) {
//        testKMPMatch ();
        Scanner sc = new Scanner ( System.in );
        while (sc.hasNext ()){
            int n = sc.nextInt ();
//            int[] nums = new int[n];
//            kthPrime ( n,nums );
//            System.out.println (nums[n-1]);
            if (n<=2){
                System.out.println (1);
                return;
            }
            int res = Fabcco ( n );
            System.out.println (res);
        }
    }

    public static void kthPrime(int n,int[] nums){
        nums[0] = 2;
        int count = 1;
        for (int i=3;count<n;i++){
            int t = (int)Math.sqrt ( i );
            int j = 2,flag=1;
            while ( j<=t ){
                if (i%j == 0){
                    flag = 0;
                    break;
                }
                j++;
            }
            if (flag == 1){
                nums[count] = i;
                count++;
            }
        }
    }

    public static int Fabcco(int n){
        int preResult = 1;
        int pre2Result = 1;
        int result = 0;
        for (int i=3;i<=n;i++){
            result = preResult+pre2Result;
            pre2Result = preResult;
            preResult = result;
        }
        return result;
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
