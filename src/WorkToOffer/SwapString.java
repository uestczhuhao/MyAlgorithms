package WorkToOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

/**
 * Created by zhuhao on 17-6-3.
 * 输出任意顺序的string字符串，例如输入abc，则输出a,b,c,ab,ac,bc....cba等全排列
 */
public class SwapString {
    public static void main(String[] args) {
        SwapString test = new SwapString ();
        ArrayList<String> re = test.Permutation ( "abc" );
        System.out.println (re);
    }
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList<> (  );
        if (str == null || str.length () == 0){
            return result;
        }
        char[] chars = str.toCharArray ();
        TreeSet<String> temp = new TreeSet<>() ;
        Permutation(chars, 0, temp,2);

//        for (int i=1;i<=str.length ();i++){
//            Permutation(chars, 0, temp,i);
//        }
        result.addAll(temp) ;
        return result;
    }

    public void Permutation(char[] chars, int begin, TreeSet<String> result,int len) {
        if(chars==null || chars.length==0 || begin<0 || begin>chars.length-1) { return ; }

        if(begin == len-1) {
//            System.out.println (begin);
            char[] tmp = new char[len];
            for (int i=0;i<len;i++)
                tmp[i] = chars[i];
            result.add(String.valueOf(tmp)) ;
        }else {
            ///字符串与后面的每一个单独字符互换，以新的首字母重排
            for(int i=begin ; i<=chars.length-1 ; i++) {
                ///for循环处理第一个字符，递归调用解决后续的部分，把问题分解
                swap(chars, begin, i) ;

//                System.out.println ("i= "+i+" begin= "+begin);
//                System.out.println ("Chars are "+ Arrays.toString (chars));
                Permutation(chars, begin+1, result,len);

                swap(chars, begin, i) ;
            }
        }
    }

    public void swap(char[] source,int pos1,int pos2){
        char tmp=source[pos1];
        source[pos1] = source[pos2];
        source[pos2] = tmp;
    }
}
