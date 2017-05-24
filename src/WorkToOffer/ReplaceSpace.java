package WorkToOffer;

/**
 * Created by zhuhao on 17-5-22.
 */
public class ReplaceSpace {
    public String replaceSpace(StringBuffer str) {
        String result = "";
        if (str.length () == 0)
            return result;
        int length = str.length ();
        for(int i=0;i<length;i++){
            if(str.charAt ( i ) == ' '){
                str.replace ( i,i+1,"%20" );
                length +=2;
            }
        }
        return str.toString ();
    }
}
