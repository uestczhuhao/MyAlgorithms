package NationalSimulation;

import java.util.Scanner;

/**
 * Created by zhuhao on 17-8-19.
 */
public class MaxLengthDNA {
    public static void main(String[] args) {
        Scanner sc = new Scanner ( System.in );
        while (sc.hasNext ()){
            String s = sc.next ();
            char[] chs = s.toCharArray ();
            int count = 0,max=0;
            for (int i=0;i<chs.length;i++){
                count = 0;
                while (i < chs.length &&(chs[i] == 'A' || chs[i] == 'T' ||
                        chs[i] == 'C' || chs[i] == 'G')){
                    count++;
                    i++;
                }
                if (count > max)
                    max = count;

            }
            System.out.println (max);
        }
    }
}
