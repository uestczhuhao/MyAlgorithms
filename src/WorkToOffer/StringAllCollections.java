package WorkToOffer;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * Created by zhuhao on 17-8-29.
 * 输出任意顺序的string字符串，例如输入abc，则输出a,b,c,ab,ac,bc,abc等全排列
 */
public class StringAllCollections {
    public static TreeSet<String> setComb = new TreeSet<> ( new Comparator<String> () {
        @Override
        public int compare(String t0, String t1) {
            if (t0.length () != t1.length ()){
                return t0.length ()-t1.length ();
            } else {

                return t0.compareTo ( t1 );
            }
        }
    } );
    public static TreeSet<String> set = new TreeSet<> (  );
    public static StringBuffer strB = new StringBuffer (  );
    public static void main(String[] args) {
        String str = "abc";
        char[] chs = str.toCharArray ();
        permutation ( chs,0 );
//        allCombiling (chs);
        doCombBits (chs);

        Iterator<String> iterator = set.iterator ();
        while (iterator.hasNext ()){
            System.out.print (iterator.next ()+" ");
        }

        System.out.println ();
        Iterator<String> iterator1 = setComb.iterator ();
        while (iterator1.hasNext ()){
            System.out.print (iterator1.next ()+" ");
        }
     }

     ///字符串的全排列
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

    //字符串的全组合
    public static void allCombiling(char[] chs){
        int n = chs.length;
        for (int i=1;i<=n;i++){
            doCombining ( chs,0,i );
        }

    }

    public static void doCombining(char[] chs,int start,int len){
        if (len == 0){
            setComb.add ( strB.toString () );
            return;
        }
        for (int i= start;i <= chs.length - len;i++){
            strB.append ( chs[i] );
            doCombining ( chs,i+1,len-1 );
            strB.deleteCharAt ( strB.length ()-1 );
        }
    }


    //利用二进制特性，如果字符串有3位，则依次为001,010,100,...111，
    //其中001代表a，010代表b，100代表c，值为1的位置代表取对应位置上的字符
    public static void doCombBits(char[] chars){
        setComb.clear ();
        int n = chars.length;
        int nbits = 1<<n;
        for (int i=0;i<nbits;i++){
            strB = new StringBuffer (  );
            for (int j=0;j<n;j++){
                if ((i & (1<<j)) != 0)
                    strB.append ( chars[j] );
            }
            setComb.add ( strB.toString () );
        }
    }

    public static void swapChars(char[] chs,int a,int b){
        char tmp = chs[a];
        chs[a] = chs[b];
        chs[b] = tmp;
    }

}
