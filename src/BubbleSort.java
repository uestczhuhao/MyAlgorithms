import java.util.Arrays;

/**
 * Created by zhuhao on 17-5-1.
 * 冒泡排序
 * 最好情况(已经有序)：n-1次比较，没有交换，时间复杂度O(n)
 * 最坏情况(已经逆序)：1+2+...+n-1次=n(n-1)/2比较，等数量级交换，时间复杂度O(n^2)
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] a = {10,3,3,54,45,6,17,8,9};
        BubbleSort (a);
        System.out.println ( Arrays.toString (a));
    }



    /**
     * 最简单的冒泡排序（初级版）
     * @param list 输入要排序的数组（名）
     */
    public static void BubbleSort0 (int[] list){
        int i,j;
        for (i=0;i<list.length;i++){
            for (j = i+1;j<list.length;j++){
                if(list[i] > list[j])
                    BaseFunctions.swap(list,i,j);
            }
        }
    }

    /**
     * 正宗的冒泡排序算法
     * @param list  输入要排序的数组（名）
     */
    public static void BubbleSort(int[] list){
        int i,j;
        for (i=0;i<list.length;i++)
            for (j=list.length-2;j>=i;j--){
                //j是从后往前循环，
                // 好处是可以把后面比较小的数据在移动的过程中就提到靠前的位置
                if(list[j] > list[j+1])
                    BaseFunctions.swap ( list,j,j+1 );
            }
    }

    /**
     * 冒泡排序的改进，设立flag值，减少无用的比较
     * @param list
     */
    public static void BubbleSortCorrect(int[] list) {
        int i,j;
        boolean flag = true;
        for(i=0; i<list.length && flag;i++){
            flag = false;  //初始为false
            for (j=list.length-2;j>=i;j--){
                if (list[j] > list[j+1]){
                    BaseFunctions.swap ( list,j,j+1 );
                    flag = true;
                }
            }

        }
    }


}
