package HuaWei.Test0816;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by zhuhao on 17-8-16.
 * 给定2个位数相同的十进制数，如果两个数在同样位上连续N位数相同，
 * 则输出为N；如果在同样位上连续N-1位数相同，则输出为N-1；如果有N-2位相同，则输出为N-2... 如果有2位相同，则输出为2；只有1位相同或没有相同则输出为0。如果同时存在两组连续N位数相同，则按照匹配数多的一组输出。如果输入错误，比如输入了非数字或者两个数的位数不匹配，则输出-1。

 */
public class Compare2Number {
    public static void main(String[] args) {
//        Scanner sc = new Scanner ( System.in );
//        while (sc.hasNext ()) {
//            String[] nums = sc.nextLine ().split ( " " );
//            char[] n1 = nums[0].toCharArray ();
//            char[] n2 = nums[1].toCharArray ();
//            int max = findMatch ( n1,n2 );
//            System.out.println (max);
//        }
//        System.out.println (Integer.parseInt ( "123a" ));
    }

    private static int findMatch(final char[] number0,final char[] number1){

//        char[] number0 = new char[number00.length-2];
//        char[] number1 = new char[number11.length-2];
//        System.arraycopy ( number00,0,number0,0,number0.length );
//        System.arraycopy ( number11,0,number1,0,number1.length );
        int len = number0.length;
        if (number0.length != number1.length ){
            return -1;
        }
        for (int i=0;i<len;i++){
            if (number0[i]<'0' || number0[i]>'9' || number1[i]<'0' || number1[i]>'9'){
                return -1;
            }
        }
        int max= 0,count=0,i=0;
        while (i<len){
            count=0;
            while (number0[i] == number1[i]){
                count++;
                i++;
            }
            if (count>max)
                max= count;
            i++;
        }
        if (max > 1)
            return max;
        else
            return 0;
    }
}
