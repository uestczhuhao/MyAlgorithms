package WorkToOfferAttach;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by zhuhao on 17-6-24.
 */
public class DeleteRepeate {
    public String deleteRepeat(String str){
        if (str == null || str.length ()==0)
            return null;

        HashMap<Character,Boolean> repeat = new HashMap<> (  );
        StringBuffer strCopy = new StringBuffer ( str );
        int[] delete = new int[str.length ()];

        for (int i=0;i<str.length ();i++){
            if (repeat.get ( strCopy.charAt ( i ) ) == null){
                repeat.put ( strCopy.charAt ( i ),true );
                continue;
            }
            if (repeat.get ( strCopy.charAt ( i ) ) == true)
                delete[i] = 1;
        }
//        System.out.println (strCopy);
//        System.out.println (Arrays.toString ( delete ));
        for (int i=str.length ()-1;i>=0;i--){
            if (delete[i] == 1)
                strCopy.deleteCharAt ( i );
        }
        return strCopy.toString ();
    }

}
