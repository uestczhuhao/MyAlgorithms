import java.util.Arrays;

/**
 * Created by zhuhao on 17-5-2.
 * 最好情况(已经有序)：比较了n-1次，没有移动，复杂度O(n)
 * 最坏情况(逆序)：需要比较2+3+...+n=(n+1)(n-1)/2次，移动3+4+..+n+1=(n+4)(n-1)/2次
 * 注意：在最坏情况的分析中，第二个for循环前后各有一个赋值语句，所以要整体加2
 * 综上，如果排序记录是随即的，也即概率相同时，平均比较和移动的次数约为n^2/4，时间复杂度O(n^2)
 */
public class InsertSort {
    public static void main(String[] args) {
//        int[] a={5,2,4,6,3};
        int[] a = {10,3,3,54,45,6,17,8,9};

        InsertSort ( a );
        System.out.println ( Arrays.toString (a));
    }

    public static void InsertSort(int[] a){
        int i,j,temp;
        for (i=1;i<a.length;i++){
            if(a[i] < a[i-1]){
                temp = a[i];
                for (j=i-1;j>=0 && a[j]>temp;j--)
                    a[j+1] = a[j];      //把比记录值大的值都后移，
                a[j+1] = temp;          //把记录值插入合适的地方
            }
        }
    }
}
