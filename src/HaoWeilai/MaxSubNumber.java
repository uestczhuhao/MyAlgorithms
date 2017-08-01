package HaoWeilai;

import java.util.Scanner;

/**
 * Created by zhuhao on 17-7-31.
 */
public class MaxSubNumber {
//    public static void main(String[] args) {
////        Scanner in = new Scanner ( System.in );
////        String str= in.nextLine ();
//
//        MaxSubNumber test = new MaxSubNumber ();
//        Scanner in = new Scanner ( System.in );
//        String str = in.nextLine ();;
//        ///213hjhu12u42uh123456789
//        String result = test.findMaxSubNumber(str);
//        System.out.println (result);
//    }
public static void main(String[] args) {
    MaxSubNumber test = new MaxSubNumber ();
    Scanner in = new Scanner ( System.in );
    String str = in.nextLine ();
//    in.close ();
//    StringBuilder strTmp = new StringBuilder ( str );
    String result = test.findMaxSubNumber(str);
//    String result = test.findMaxSubNumber("2131213123hjhu12u42uh12345afewae116789");
    System.out.println (result);
}

    public String findMaxSubNumber(String str){
        if (str == null || str.length ()==0)
            return null;

        int[] index = new int[2];
        index = findCore ( str,index );
        int pointer = index[0];
        StringBuilder strBul = new StringBuilder (  );
        for (int i=0;i<index[1];i++){
            strBul.append ( str.charAt ( pointer ) );
            pointer--;
        }
        return strBul.reverse ().toString ();
    }

    ///index[0]保存数字字串截止位置，index[1]保存次数
    public int[] findCore(String str,int[] index){
        index[0] = 0;index[1]=0;
        char[] chs = str.toCharArray();
        int count = 0,i=0;
        while (i<chs.length){
            while (i<chs.length && chs[i] >='0' && chs[i]<='9'){
                count++;
                i++;
            }

            if (count > index[1]){
                index[0] = i-1;
                index[1] = count;
                count =0;
                continue;
            }
            count = 0;
            i++;
        }
        return index;
    }


}
