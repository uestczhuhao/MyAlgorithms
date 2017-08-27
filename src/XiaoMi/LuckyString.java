package XiaoMi;

import java.util.*;

/**
 * Created by zhuhao on 17-8-27.
 * A string s is LUCKY if and only if the number of different characters in s is a fibonacci number. Given a string consisting of only lower case letters , output all its lucky non-empty substrings in lexicographical order. Same substrings should be printed once.
 输入描述:
 a string consisting no more than 100 lower case letters.
 输出描述:
 output the lucky substrings in lexicographical order.one per line. Same substrings should be printed once.
 示例1
 输入

 aabcd
 输出

 a
 aa
 aab
 aabc
 ab
 abc
 b
 bc
 bcd
 c
 cd
 d
 */
public class LuckyString {
    public static void main(String[] args) {
        Scanner sc = new Scanner ( System.in );
        while (sc.hasNext ()){
            String str=sc.nextLine ();
            TreeSet<String> set = new TreeSet<> (  );
            for (int i=0;i<str.length ();i++){
                for (int len=1;i+len<=str.length ();len++){
                    String tmp = str.substring ( i,i+len );
                    if (isFac ( tmp )){
                        set.add ( tmp );
                    }
                }
            }

            Iterator<String> iterator = set.iterator ();
            while (iterator.hasNext ()){
                System.out.println (iterator.next ());
            }
        }
    }

    public static boolean isFac(String str ){
        int[] facInit = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89 };
        char[] chs = str.toCharArray ();
        HashSet<Character> set = new HashSet<> (  );
        for (int i=0;i<chs.length;i++)
            set.add ( chs[i] );
        for (int i=0;i<11;i++){
            if (facInit[i] == set.size ()){
                return true;
            }
        }
        return false;
    }

    private static int[] createFac(){
        int[] facInit = new int[12];
        facInit[0] = facInit[1] = 1;
        int i=2;
        while (i<=100){
            facInit[i] = facInit[i-1] + facInit[i-2];
            if (facInit[i] >=100)
                break;
            i++;
        }
        System.out.println ( Arrays.toString (facInit));
        return facInit;
    }

}
