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
        ShellSort ( a );
        System.out.println ( Arrays.toString (a));
    }

    public static void ShellSort(int[] a){
        int increment = a.length;
        int i,j,temp;
        while (increment >=1) {
            increment = increment/3+1;
            for(i=increment;i<a.length;i++){
                if(a[i]<a[i-increment]){
                    temp = a[i];
                    for (j=i-increment;j>=0 && temp<a[j];j-=increment)
                        a[j+increment] = a[j];
                    a[j+increment] = temp;
                }
            }
            if(increment ==1)
                break;
        }
    }
}
