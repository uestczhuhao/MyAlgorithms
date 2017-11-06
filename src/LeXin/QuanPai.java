package LeXin;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class QuanPai {
    public static TreeSet<String> set = new TreeSet<> (  );
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            char[] chs = str.toCharArray();
            set = new TreeSet<> (  );
            permutation(chs, 0);
            Iterator<String> iterator = set.iterator();
            if (iterator.hasNext())
                System.out.print(iterator.next() );
            while (iterator.hasNext()) {
                System.out.print(","+iterator.next() );
            }

        }
    }

    public static void permutation(char[] chs,int start){
        if (start == chs.length-1){
            set.add ( String.valueOf ( chs ) );
            return;
        }

        permutation ( chs,start+1 );
        for (int i=start;i<chs.length;i++){
            if (chs[i] != chs[start]){
                swapChars ( chs,i,start );
                permutation ( chs,start+1 );
                swapChars ( chs,i,start );
            }
        }
    }

    public static void swapChars(char[] chs,int a,int b){
        char tmp = chs[a];
        chs[a] = chs[b];
        chs[b] = tmp;
    }
}
