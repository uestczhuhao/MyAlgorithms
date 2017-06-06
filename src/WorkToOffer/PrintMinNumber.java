package WorkToOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by zhuhao on 17-6-6.
 */
public class PrintMinNumber {
    //解法1：利用自己写的冒泡排序做
    public String PrintMinNumber(int [] numbers) {
        if (numbers == null || numbers.length ==0)
            return "";
        String[] numStrs = new String[numbers.length];
        for (int i=0;i<numbers.length;i++){
            numStrs[i] = String.valueOf ( numbers[i] );
        }
        String result = minNumber ( numStrs );
        return result;
    }

    public String minNumber(String[] numStrs){
        String result="";
        if (numStrs == null || numStrs.length ==0)
            return result;
        for (int i=0;i<numStrs.length;i++){
            for (int j=numStrs.length-1;j>i;j--){
                if (isALessB ( numStrs[j],numStrs[i] ))
                    swap ( numStrs,i,j );
            }
        }

        for (int i=0;i<numStrs.length;i++)
            result+=numStrs[i];

        return result;
    }

    public boolean isALessB(String a,String b){
        String tmpA = a+b;
        String tmpB = b+a;
        boolean isLess=false;
        if (tmpA.compareTo ( tmpB )<0)
            isLess = true;
        return isLess;
    }

    public void swap(String[] source,int i,int j){
        String tmp=source[i];
        source[i] = source[j];
        source[j] = tmp;
    }

    //解法2：利用Collection的sort方法排序
    public String PrintMinNumber2(int [] numbers) {
        if (numbers == null || numbers.length == 0)
            return "";
        String result = "";
        ArrayList<String> arrays = new ArrayList<String> ();
        for (int tmp:numbers){
            String temp = String.valueOf ( tmp );
            arrays.add ( temp );
        }

        Collections.sort ( arrays, new Comparator<String> () {
            @Override
            public int compare(String a, String b) {
                String tmpA = a+b;
                String tmpB = b+a;
                return tmpA.compareTo ( tmpB );
            }
        } );

        for (String tmp:arrays)
            result+=tmp;

        return result;
    }
}
