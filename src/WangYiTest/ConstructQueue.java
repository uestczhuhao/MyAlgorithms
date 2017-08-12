package WangYiTest;

import org.omg.CORBA.INTERNAL;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by zhuhao on 17-8-12.
 */
public class ConstructQueue {
    public static void main(String[] args) {
        Scanner in = new Scanner ( System.in );
        int n = in.nextInt ();
        int[] arr = new int[n];
        for (int i=0;i<n;i++){
            arr[i] = in.nextInt ();
            int m = arr[i];
            LinkedList<Integer> result = new LinkedList<> (  );
            construct(m,result);
            for (int j=0;j<m-1;j++){
                System.out.print (result.removeFirst ()+" ");
            }
            System.out.print (result.removeFirst ());
            System.out.println ();
        }
    }

    private static void construct(int n,LinkedList<Integer> res){

        for (int i=n;i>0;i--){
            res.addFirst ( i );
            res.addFirst ( res.removeLast () );
        }
    }
}
