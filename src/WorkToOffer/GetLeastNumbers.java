package WorkToOffer;

import java.util.ArrayList;

/**
 * Created by zhuhao on 17-6-3.
 */
public class GetLeastNumbers {

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<> (  );
        if (input == null || input.length==0 || k>input.length || k<=0)
            return result;
        quickSort(input,0,input.length-1);
        for (int i=0;i<k;i++){
            result.add ( input[i] );
        }

        return result;
    }

    //解法1：快排之后，选择最小的k个值
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

    //解法2：对一开始的k和输入构建最大堆，后面的值与最大堆顶值比较
    //若小于堆顶，则替换堆顶并重构最大堆
    public ArrayList<Integer> GetLeastNumbers1(int [] input, int k){
        ArrayList<Integer> result = new ArrayList<> (  );
        if (input == null || input.length==0 || k>input.length)
            return result;
        return result;
    }

    //解法3：不完全的快排，用循环完成，比解法1更快
    //此解法基于k来排序，只保证在第k个元素左边的元素都比input[k]小
    //右边的元素都比它大即可，不一定要使数组完全有序
    public ArrayList<Integer> GetLeastNumbers2(int [] input, int k){
        ArrayList<Integer> result = new ArrayList<> (  );
        if (input == null || input.length==0 || k>input.length ||k<=0)
            return result;
        int low = 0,high = input.length-1;
        int index = Partition ( input,low,high );
        while (index!=k-1){
            if (index>k-1){
                high = index-1;
                index = Partition ( input,low,high );
            } else {
                low = index+1;
                index = Partition ( input,low,high );
            }
        }
        for (int i=0;i<k;i++)
            result.add ( input[i] );
        return result;
    }

    public void swap(int[] source,int pos1,int pos2){
        int tmp=source[pos1];
        source[pos1] = source[pos2];
        source[pos2] = tmp;
    }
}
