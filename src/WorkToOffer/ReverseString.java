package WorkToOffer;

import java.util.Arrays;

/**
 * Created by zhuhao on 17-6-17.
 */
public class ReverseString {
    public String ReverseSentence(String str) {
        if (str==null)
            return null;
        if (str.trim ().length () == 1 || str.trim ().length ()==0)
            return str;

        System.out.println ("Comming here");
        StringBuffer strBuf = new StringBuffer ( str );
        strBuf = strBuf.reverse ();
        String result = reverse ( strBuf );
//        System.out.println (result);
        return result;
    }

    public String reverse(StringBuffer sb){
        String[] strs = sb.toString ().split ( " " );
        sb.delete ( 0,sb.length () );
        for (int i=0;i<strs.length;i++){
            String tmp = strs[i];
            StringBuffer strBuf = new StringBuffer ( tmp );
            if (i==strs.length-1)
                strBuf = strBuf.reverse ();
            else
                strBuf = strBuf.reverse ().append ( " " );
            sb.append ( strBuf );
        }


        return sb.toString ();
    }
}
