package WorkToOffer;

import java.util.ArrayList;

/**
 * Created by zhuhao on 17-6-17.
 */
public class FindNumbersWithSum {
    public static void main(String[] args) {
        int[] test = {1,2,4,7,11,15};
        ArrayList<Integer> re = FindNumbersWithSum ( test,15 );
        System.out.println (re);
    }
    public static ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {

        ArrayList result = new ArrayList (  );
        if (array== null || array.length == 0)
            return result;

        int low =0,high = array.length-1;
        int sumTemp = array[low]+array[high];
        while (low<high){
//            System.out.println (sumTemp);
            if (sumTemp == sum){
                result.add ( array[low] );
                result.add ( array[high] );
                break;
            } else if (sumTemp>sum){
                sumTemp -= array[high];
                high--;
                sumTemp += array[high];
            } else {
                sumTemp -= array[low];
                low++;
                sumTemp += array[low];
            }
        }

        return result;
    }
}
