package WorkToOfferAttach;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Set;

/**
 * Created by zhuhao on 17-6-24.
 */
public class IsAnagramString {
    public boolean isAnagram(String str1,String str2){
        if (str1 == null || str2 == null ||
                (str1.length ())*(str2.length ())==0 ||
                str1.length () != str2.length ())
            return false;

        HashMap<Character,Integer> strToNum = new HashMap (  );
        char[] str1Chs = str1.toCharArray ();
        char[] str2Chs = str2.toCharArray ();
        boolean isAnagram = true;
        for (int i=0;i<str1.length ();i++){
            if (strToNum.get ( str1Chs[i] ) == null)
                strToNum.put ( str1Chs[i],1 );
            else {
                int num = strToNum.get ( str1Chs[i] )+1;
                strToNum.put ( str1Chs[i],num);
            }
        }
//        System.out.println (strToNum);
        for (int i=0;i<str2.length ();i++){
            if (strToNum.get ( str2Chs[i] ) == null){
                isAnagram = false;
                break;
            }
            strToNum.put ( str2Chs[i],strToNum.get ( str2Chs[i] )-1 );
        }
//        System.out.println (strToNum);

//        for (HashMap.Entry<Character,Integer> tmp:strToNum.entrySet ()){
//            if (tmp.getValue () != 0){
//                isAnagram = false;
//                break;
//            }
//        }
        for (Integer value:strToNum.values ()){
            if (value!=0){
                isAnagram = false;
                break;
            }
        }
        return isAnagram;
     }
}
