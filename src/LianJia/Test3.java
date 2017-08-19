package LianJia;

import java.util.Scanner;

/**
 * Created by zhuhao on 17-8-19.
 */
public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner ( System.in );
        while (sc.hasNext ()) {
            int[] input = new int[10];
            for (int i=0;i<10;i++)
                input[i] = sc.nextInt ();

            int height = sc.nextInt ();
            height+=30;

            int count = 0;
            for (int i=0;i<10;i++)
                if (height>=input[i])
                    count++;
            System.out.println (count);
        }
    }
}
