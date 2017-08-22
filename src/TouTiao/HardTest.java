package TouTiao;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by zhuhao on 17-8-22.
 */
public class HardTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner ( System.in );
        while (sc.hasNext ()){
            int n = sc.nextInt ();
            int[] lev = new int[n];
            for (int i=0;i<n;i++){
                lev[i] = sc.nextInt ();
            }
            Arrays.sort (lev);
//            System.out.println (Arrays.toString ( lev ));
            int index = 1,flag = 0,res = 0;

            while (index < n-1){
                if (lev[index]-lev[index-1] <= 10 && lev[index+1]-lev[index] <= 10 ){
                    flag = index+2;
                    index+=3;
                } else if (lev[index]-lev[index-1] <= 10 ){
                    res++;
                    flag = index+1;
                    index+=2;
                } else if (lev[index+1]-lev[index] <= 10 ){
                    res+=2;
                    flag = index;
                    index+=1;
                } else {
                    res+=4;
                    flag = index+1;
                    index+=2;
                }
            }
            if (flag == n-1)
                res+=2;
            if (flag == n-2){
                if (lev[n-1]-lev[n-2]<=10)
                    res+=1;
                else
                    res+=4;
            }
//            res+=(2-count);
            System.out.println (res );
        }
    }
}
