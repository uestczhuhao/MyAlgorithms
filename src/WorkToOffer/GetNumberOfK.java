package WorkToOffer;

/**
 * Created by zhuhao on 17-6-17.
 */
public class GetNumberOfK {
    public int GetNumberOfK(int [] array , int k) {
        if (array == null || array.length == 0)
            return 0;

        int first = getFirstK ( array,k,0,array.length-1 );
//        System.out.println ("first = "+first);
        if (first == -1)
            return 0;
        int last = getLastK ( array,k,0,array.length-1 );
//        System.out.println ("Last= "+last);
        return last-first+1;
    }

    public int getFirstK(int[] array, int k,int low,int high){
        int middle = (low+high)>>1;
        if (low == high && array[low]!=k)
            return -1;
        if (middle==0)
            return 0;
        if (array[middle] == k){
            if (array[middle-1]!=k){
                return middle;
            }
            else {
                high = middle-1;
            }

        } else if(array[middle] < k){
            low = middle+1;
        } else
            high = middle-1;
        return getFirstK ( array,k,low,high );
    }

    public int getLastK(int[] array,int k,int low,int high){
        int middle = (low + high)>>1;
        if (low == high && array[low]!=k)
            return -1;
        if (middle == array.length-1)
            return array.length-1;
        if (array[middle] == k){
            if (array[middle+1] != k)
                return middle;
            else
                low = middle+1;
        } else if(array[middle] < k){
            low = middle+1;
        } else
            high = middle-1;
        return getLastK ( array,k,low,high );
    }
}
