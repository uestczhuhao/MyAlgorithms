import java.util.Arrays;

/**
 * Created by zhuhao on 17-5-2.
 * 希尔排序，类似与插入排序，只是通过一个增量来跳跃
 * 增量本程序中使用 increment = increment/3+1; 网上一般使用减半操作确定增量
 *
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] a = {10,3,3,54,45,6,17,8,9};
        shellSort ( a );
        System.out.println ( Arrays.toString (a));
    }

//    public static void ShellSort(int[] a){
//        int increment = a.length;
//        int i,j,temp;
//        while (increment >=1) {
//            increment = increment/3+1;
//            for(i=increment;i<a.length;i++){
//                if(a[i]<a[i-increment]){
//                    temp = a[i];
//                    for (j=i-increment;j>=0 && temp<a[j];j-=increment)
//                        a[j+increment] = a[j];
//                    a[j+increment] = temp;
//                }
//            }
//            if(increment ==1)
//                break;
//        }
//    }

    private static void shellSort(int[] arr){
        if (arr == null || arr.length == 0){
            throw new Error ( "Invalid Input!!!" );
        }

        int increment = arr.length;
        while (increment >=1){
            increment = increment/3+1;

            for (int i=increment;i<arr.length;i+=increment){
                int temp = arr[i];
                ///判断，只有有逆序对时才会有交换的动作（以increment为跳跃间隔）
                if (arr[i]<arr[i-increment]){
                    int j;
                    ///并非只是交换间隔的两个关键字，例如9...6...3
                    ///此时应该把3放入9的位置，9放入6的位置，变成3...9...6
                    ///利用插入排序的思想
                    for (j=i-increment;j>=0 && temp < arr[j];j-=increment){
                        arr[j+increment] = arr[j];
                    }
                    arr[j+increment] = temp;
                }

            }
            if (increment ==1)
                break;
        }
    }
}
