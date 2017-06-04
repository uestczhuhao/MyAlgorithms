package WorkToOffer;

/**
 * Created by zhuhao on 17-6-4.
 */
public class GreatestSumOfSubArray {
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array==null || array.length ==0){
            return 0;
        }

        int curSum =0;
        int greatestSum = -100000;

        for (int i=0;i<array.length;i++){
            if (curSum<=0){
                curSum = array[i];
            } else {
                curSum += array[i];
            }

            if (curSum > greatestSum)
                greatestSum = curSum;
        }

        return greatestSum;
    }
}
