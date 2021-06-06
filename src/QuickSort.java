import java.util.Arrays;
import java.util.Date;
import java.util.Random;

/**
 * Created by zhuhao on 17-5-7.
 */
public class QuickSort {

    private static int testtt = 1;

    public static void main(String[] args) {
        int[] a = {10, 3, 3, 54, 45, 6, 17, 8, 9};
//        QSort ( a,0,8 );
//        quickSort (a,0,a.length-1);
//        System.out.println (Arrays.toString (a));
        QuickSort test = new QuickSort();
        test.testtt++;
        System.out.println(testtt);
    }


//    public static void QSort(int[] source,int low,int high){
//        int pivot;
//
//
//        if(low<high){
//            //将source分为两个子表，算出枢轴值pivot
////            pivot = Partition(source,low,high);
//            pivot = PartitionCorrection(source,low,high);
//
//            QSort ( source,low,pivot-1 );   //对低子表递归排序
//            QSort ( source,pivot+1,high);   //对高子表递归排序
//        }
//    }

    /**
     * 交换数组中子表的记录，使枢轴记录到位，并返回其位置
     * 此时在它之前（后）的记录均不大（小）于它
     * @return 返回枢轴的位置
     */
//    public static int Partition(int[] source,int low,int high){
//        int pivotkey = source[low];
//        while (low<high){
//            while (low<high && source[high]>=pivotkey)
//                high--;
//            BaseFunctions.swap ( source,low,high );
//            while (low<high && source[low] <= pivotkey)
//                low++;
//            BaseFunctions.swap ( source,low,high );
//        }
//        return low;
//    }

    /**
     * 快速排序优化算法
     */
//    public static int PartitionCorrection(int[] source,int low,int high){
//        int m=low +(high-low)/2;  //计算数组中间元素的下标
//        if(source[low] > source[high])
//            BaseFunctions.swap ( source,low,high );
//        if(source[m] > source[high])
//            BaseFunctions.swap ( source,m,high );
//        if(source[m] > source[low])
//            BaseFunctions.swap ( source,low,m );
//        //交换之后，source[low]已经是整个序列左右中三个关键字的中间值
//        int pivotkey = source[low];
//        int temp = pivotkey;
//        while (low<high){
//            while (low<high && source[high]>=pivotkey)
//                high--;
////            BaseFunctions.swap ( source,low,high );
//            source[low] = source[high]; //采用替换的方式代替交换
//            while (low<high && source[low] <= pivotkey)
//                low++;
////            BaseFunctions.swap ( source,low,high );
//            source[high] = source[low];
//        }
//        source[low] = temp;
//        return low;
//    }
    private static void quickSort(int[] arr, int low, int high) {
        if (arr == null || arr.length == 0)
            throw new Error("Invalid Input!!!");

        if (low < high) {
            int index = partition(arr, low, high);

            quickSort(arr, low, index - 1);
            quickSort(arr, index + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        if (low >= high)
            return low;
        ///制作一个在[low,high]中的随机数，每次调用返回一个随机值
        Random ran = new Random();
        int index = low + ran.nextInt(high - low + 1);
        swap(arr, low, index);
        int temp = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= temp)
                high--;
            arr[low] = arr[high];
            while (low < high && arr[low] <= temp)
                low++;
            arr[high] = arr[low];
//            System.out.println (Arrays.toString ( arr ));
        }
        arr[low] = temp;
        return low;
    }

    private static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
