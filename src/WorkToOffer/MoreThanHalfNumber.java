package WorkToOffer;

/**
 * Created by zhuhao on 17-6-3.
 */
public class MoreThanHalfNumber {
    public int MoreThanHalfNum_Solution(int [] array) {
        if (array == null || array.length == 0)
            return 0;

        int result = 0;
        ///利用快速排序对数组排序
        QuickSort ( array,0,array.length-1 );
        int middle = array.length >>1;
        if (isMoreThanHalfNum ( array,array[middle] ))
            result = array[middle];

        return result;
    }

    public void QuickSort(int[] array,int low,int high){
        int pointer;
        if (low<high){
            pointer = Partition ( array,low,high );
            ///对枢轴的前后一半数组元素进行同样的操作，数组就有序了
            QuickSort ( array,low,pointer-1 );
            QuickSort ( array,pointer+1,high );
        }

    }
    ///返回枢轴的位置
    public int Partition(int[] array,int start,int end){
        int pivot = array[0];

        while (start<end){
            while (start<end && array[end]>=pivot)
                end--;
            swap ( array,start,end );
            while (start<end && array[start]<=pivot)
                start++;
            swap ( array,start,end );
        }
        return start;
    }

    public boolean isMoreThanHalfNum(int[] array,int result){
        int count=0;
        boolean isOrNot = false;

        for (int i=0;i<array.length;i++){
            if (array[i] == result)
                count++;
        }
        if (count*2 > array.length)
            isOrNot = true;

        return isOrNot;
    }

    public void swap(int[] source,int pos1,int pos2){
        int tmp=source[pos1];
        source[pos1] = source[pos2];
        source[pos2] = tmp;
    }


    //更简单的解法
    public int MoreThanHalfSimple(int[] array){
        if (array == null || array.length ==0)
            return 0;

        //result记录之前的值，如果下一个值与记录值相同
        //则time加1,不一样则减1
        int result=array[0],time = 1;
        for (int i=0;i<array.length;i++){
            //如果次数为0,则重新计算
            if (time == 0){
                result = array[i];
                time++;
            } else if(result == array[i])
                time++;
            else time--;
        }

        if (!isMoreThanHalfNum ( array,result ))
            result = 0;
        return result;
    }
}
