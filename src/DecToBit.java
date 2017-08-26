/**
 * Created by zhuhao on 17-8-26.
 */
public class DecToBit {
    public static void main(String[] args) {

        System.out.println (Convert ( 1999 ));
        System.out.println (Convert ( 2299 ));
    }

    public static String Convert(int m){
        StringBuffer bits = new StringBuffer (  );
        int count = 0;
        while (m!=0){
            if ( (m&1) ==0){
                bits.append ( 0 );

            }
            else{
                bits.append ( 1 );

            }
            count++;
            if (count %4 ==0){
                bits.append ( " " );
            }
            m>>=1;
        }
        if (bits.substring ( bits.length ()-1 ).equals ( " " )){
            bits.deleteCharAt ( bits.length ()-1 );
        }

        return bits.reverse ().toString ();
    }
}
