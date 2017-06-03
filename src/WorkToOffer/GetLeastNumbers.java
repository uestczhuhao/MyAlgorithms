package WorkToOffer;

import java.util.ArrayList;

/**
 * Created by zhuhao on 17-6-3.
 */
public class GetLeastNumbers {

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<> (  );
        if (input == null || input.length==0 || k>input.length)
            return result;
        quickSort(input,0,input.length-1);
        for (int i=0;i<k;i++){
            result.add ( input[i] );
        }

        return result;
    }

    public void quickSort(int[] input,int low,int high){
        int pivot;
        if (low<high){
            pivot = Partition ( input,low,high );
            quickSort ( input,low,pivot-1 );
            quickSort ( input,pivot+1,high );
        }
    }

    public int Partition(int[] input,int low,int high){
        int middle = (low+high)/2;
        if (input[low] > input[high])
            swap(input,low,high);
        if (input[middle]>input[high])
            swap ( input,middle,high );
        if (input[low]>input[middle])
            swap ( input,low,middle );

        int pivotkey = input[low];
        while (low<high){
            while (low<high && input[high]>=pivotkey)
                high--;
            input[low] = input[high];
//            swap ( input,low,high );
            while (low<high && input[low]<=pivotkey)
                low++;
            input[high] = input[low];
//            swap ( input,low,high );
        }
        input[low] = pivotkey;
        return low;
    }

    public void swap(int[] source,int pos1,int pos2){
        int tmp=source[pos1];
        source[pos1] = source[pos2];
        source[pos2] = tmp;
    }
}
