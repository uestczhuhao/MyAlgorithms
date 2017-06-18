package WorkToOffer;

/**
 * Created by zhuhao on 17-6-18.
 * 本题中，先把字符串分为（0,n）和（n+1,end）两部分，
 * 例如把abcdefg分为ab和cdefg两部分（此时n=2）
 * 再把这两部分分别翻转之后拼到一起，bagfedc
 * 再翻转整个字符串就是所要的结果，cdefgab
 */
public class LeftRotateString {
    public String LeftRotateString(String str,int n) {
        if (str == null)
            return null;
        if (n<0 || n>str.length ())
            return "";
        StringBuffer sb1 = new StringBuffer ( str.substring ( 0,n ) );
        StringBuffer sb2 = new StringBuffer ( str.substring ( n,str.length () ) );
        sb1 = sb1.reverse ();
        sb2 = sb2.reverse ();
        sb1 = sb1.append ( sb2 );

        String result = sb1.reverse ().toString ();
        return result;
    }
    public String LeftRotateString1(String str,int n) {
        if (str == null)
            return null;
        if (n<0 || n>str.length ())
            return "";
        StringBuffer sb = new StringBuffer ( str );
        StringBuffer tmp = new StringBuffer ( str.substring ( 0,n ) );
        sb = sb.delete ( 0,n );
        sb.append ( tmp );
        return sb.toString ();

    }



}
