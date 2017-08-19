package LianJia;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by zhuhao on 17-8-19.
 5
 2 7 3 4 9
 3
 1 5 11
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner ( System.in );
        while (sc.hasNext ()) {
            int n = sc.nextInt ();
            int[] group = new int[n];
            int sum = 0;
            for (int i=0;i<n;i++){
                group[i] = sc.nextInt ();
                sum+=group[i];
            }
            int q = sc.nextInt ();
            int[] query = new int[q];
            for (int i=0;i<q;i++)
                query[i] = sc.nextInt ();

            int[] index = new int[n+1];
            for (int i=1;i<=n;i++){
                index[i] = group[i-1]+index[i-1];
            }

//            System.out.println (Arrays.toString ( query ));
            for (int i=0;i<q;i++){
                for (int j=1;j<=n;j++){
                    if (query[i] <= index[j]){
                        System.out.println (j);
                        break;
                    }
                }
            }
        }
    }
}
