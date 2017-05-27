package WorkToOffer;

import java.util.Arrays;

/**
 * Created by zhuhao on 17-5-27.
 */
public class ReOrderArray {
    /**
     * 重排数组，奇数在前，偶数在后,并保证其相对位置不变
     * @param array
     */
    public void reOrderArray(int [] array) {
        if (array.length == 0 || array.length==1)
            return;

        int oddLength = 0;
        for (int i=0;i<array.length;i++){
            if((array[i] & 1)==1){
                oddLength++;
            }
        }
        int eveLength = array.length - oddLength;
        int[] odd = new int[oddLength];
        int[] even = new int[eveLength];
        int pOdd=0,pEven=0;
        for(int i=0;i<array.length;i++){
            if ((array[i]&1)==1){
                odd[pOdd] = array[i];
                pOdd++;
            } else {
                even[pEven] = array[i];
                pEven++;
            }
        }

        for (int i=0;i<odd.length;i++)
            array[i] = odd[i];
        for (int i=0;i<even.length;i++)
            array[odd.length+i] = even[i];


    }

    /**
     * 重排数组，奇数在前，偶数在后
     */
    public void reOrderArray1(int [] array) {

        if(array.length ==0 || array.length==1)
            return;
        int pointer1=0,pointer2=array.length-1;
        while (pointer1 < pointer2){
            ///pointer1为偶数，pointer2为奇数，交换
            if ((array[pointer1] & 1) == 0
                    && (array[pointer2]&1) ==1){
                swap ( array,pointer1,pointer2 );
                pointer1++;
                pointer2--;
            } else if((array[pointer1] & 1) ==1){
                pointer1++;
            } else if((array[pointer2] & 1) == 0){
                pointer2--;
            }
        }
    }

    public void swap(int[] arr,int a,int b){
        int tmp;
        tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
