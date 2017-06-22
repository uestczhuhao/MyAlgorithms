package WorkToOffer;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * Created by zhuhao on 17-6-21.
 */
public class MaxInWindows {
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> result = new ArrayList<> (  );
        if (num == null || num.length == 0 || size > num.length || size<=0)
            return result;
        
         getMaxList ( result,num,size );
        return result;
    }

    public void getMaxList(ArrayList<Integer> result,int[] num,int size){

        //保存此时窗口可能的最大值的下标
        ArrayDeque<Integer> max = new ArrayDeque<> (  );
        for (int i=0;i<size;i++){
            while (!max.isEmpty () && num[i]>num[max.getLast ()]){
                max.removeLast ();
            }
            max.add ( i );
        }

        for (int i=size;i<num.length;i++){
            result.add ( num[max.getFirst ()] );

            while (!max.isEmpty () && num[i] > num[max.getLast ()])
                max.removeLast ();
            if (!max.isEmpty () && max.getFirst () <= (i-size))
                max.removeFirst ();
            max.add ( i );
        }
        result.add ( num[max.getFirst ()] );
    }
}
