package WangYiTest.Spring2017;

import java.util.*;

/**
 * Created by zhuhao on 17-8-17.
 */
public class DeleteCopy {
    public static void main(String[] args) {
        Scanner sc = new Scanner ( System.in );
        while (sc.hasNext ()){
            int n = sc.nextInt ();
            ArrayList<Integer> seq = new ArrayList<> (  );
            for (int i=0;i<n;i++)
                seq.add ( sc.nextInt () );

            Set set = new TreeSet ( );
            set.addAll ( seq );

            Stack<Integer> stack = new Stack<> ();
            for (int i=seq.size ()-1;i>=0 && (!set.isEmpty ());i--){
                int tmp = seq.get ( i );
                if (set.contains ( tmp )){
                    stack.push ( tmp );
                    set.remove ( tmp );
                }
            }
//            System.out.println (stack);
            int len = stack.size ()-1;
            for (int i=0;i<len;i++){
                System.out.print (stack.pop ()+" ");
            }
            System.out.println (stack.pop ());

        }
    }
}

