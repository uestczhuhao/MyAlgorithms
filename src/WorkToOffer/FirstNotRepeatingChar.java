package WorkToOffer;

import java.util.HashMap;

/**
 * Created by zhuhao on 17-6-7.
 */
public class FirstNotRepeatingChar {
    public int FirstNotRepeatingChar(String str) {
        if (str==null || str.length () == 0)
            return -1;
        HashMap<Character,Integer> charMap = new HashMap<> (  );
        char[] charArray = str.toCharArray ();
        for (char ch:charArray){
            if (charMap.containsKey ( ch )){
                int tmp = charMap.get ( ch );
                tmp++;
                charMap.put ( ch,tmp );
            }
            else
                charMap.put ( ch,1 );
        }
        for (int i=0;i<charArray.length;i++){
            if (charMap.containsKey ( charArray[i] ) &&
                    charMap.get ( charArray[i] )==1)
                return i;
        }
        return 0;
    }
}
