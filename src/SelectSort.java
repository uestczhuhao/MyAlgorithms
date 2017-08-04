import java.util.Arrays;

/**
 * Created by zhuhao on 17-5-2.
 * 第i趟排序需要进行n-i次的比较，因此一共需要n(n-1)/2次比较
 * 交换次数：最好时0次，最差（初始降序）时n-1次
 * 因此，一共是n(n-1)/2+(n-1)/2，最终的时间复杂度是O(n^2)，但优于冒泡排序
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] a = {10,3,3,54,45,6,17,8,9};
        System.out.println ( Arrays.toString (a));
        selectSort ( a );
        System.out.println ( Arrays.toString (a));
    }

//    public static void SelectSort(int[] a){
//        int i,j,min;
//        for (i=0;i<a.length;i++){
//            min = i;
//
//            for(j = i+1; j<a.length ;j++){
//                if(a[min] > a[j])
//                    min = j;
//            }
//
//            if(min != i)
//                BaseFunctions.swap(a,min,i);
//        }
//    }

    private static void selectSort(int[] arr){
        if (arr == null || arr.length == 0){
            throw new Error ( "Invalid Input!!!" );
        }

        ///i的值从0到len-2即可，当i=len-1时，arr[i]已经是最大值了
        for (int i=0;i<arr.length-1;i++){
            int min = i;
            for (int j=i+1;j<arr.length;j++){
                if (arr[j]<arr[min])
                    min = j;
            }

            if (min != i){
                int tmp = arr[min];
                arr[min] = arr[i];
                arr[i] = tmp;
            }
        }
    }
}
