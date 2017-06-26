package WorkToOffer;

import java.util.ArrayList;
/**
 * Created by zhuhao on 17-5-25.
 */
public class MinNumberInRotateArray {

    public int minNumberInRotateArray(int [] array) {
        if(array.length == 0)
            return 0;

        int pointer1 = 0,pointer2=array.length -1;
        int midPointer = pointer1;

        while (array[pointer1] >= array[pointer2]){
            if(pointer2-pointer1 ==1){
                midPointer = pointer2;
                break;
            }

            midPointer = (pointer1+pointer2)/2;
            if (array[midPointer] == array[pointer1] && array[midPointer] == array[pointer2]) {
                //由于pointer1，pointer2和midPointer三者相同，
                //无法判断中间数字的位置，因此需要用顺序查找的方法
                return seqSearch(array,pointer1,pointer2);
            }

            if(array[midPointer] >= array[pointer1]){
                pointer1 = midPointer;
            } else {

                pointer2 = midPointer;
            }
        }

        return array[midPointer];
    }

    //基于顺序查找的方法
    public int seqSearch(int[] array,int pointer1,int pointer2){
//        System.out.println ("comming here");
        int result = array[pointer1];
        while (pointer1 < pointer2){
            if(result > array[pointer1]){
                result = array[pointer1];
            }
            pointer1++;
        }
        return result;
    }
}
