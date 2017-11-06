package KeDaXunFei;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by zhuhao on 17-9-16.
 */
public class Test01 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        while (scan.hasNext ()){
            String sb=scan.nextLine();
            char[] chs = sb.toCharArray ();
            int n1=0;
            while (n1<sb.length ()){
                if (chs[n1] == 'R')
                    break;
                n1++;
            }
            int index = chs.length-1;
            int n2 = 0;
            while (index>=0){
                if (chs[index] == 'L')
                    break;
                index--;
                n2++;
            }
            System.out.println (n1+"   "+n2);
            if (n1+n2 == sb.length ())
                System.out.println (sb.length ());
            else
                System.out.println (n1+n2+1);
        }


    }
}
