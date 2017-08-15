package HuaWei;

import java.util.Scanner;

/**
 * Created by zhuhao on 17-8-15.
 */
public class HexToDec {
    public static void main(String[] args) {
        Scanner sc = new Scanner ( System.in );
        while (sc.hasNext ()){
            String str = sc.next ();
            char[] chs = str.toCharArray ();
            int dec = 0;
            for (int i=chs.length-1;i>1;i--){
                int index = chs.length-1-i;
                if (chs[i] >= 'A' && chs[i] <='F'){
                    int tmp = chs[i] -'A'+10;
                    dec += tmp*(int)Math.pow ( 16,index );
                } else if (chs[i] >= 'a' && chs[i] <='f'){
                    int tmp = chs[i] -'a'+10;
                    dec += tmp*(int)Math.pow ( 16,index );
                } else if (chs[i] >= '0' && chs[i] <='9'){
                    int tmp = chs[i] -'0';
                    dec += tmp*(int)Math.pow ( 16,index );
                }
            }
            System.out.println (dec);
        }
//        System.out.println ('F'-'A');
    }
}
