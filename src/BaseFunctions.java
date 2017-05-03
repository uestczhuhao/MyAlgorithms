/**
 * Created by zhuhao on 17-5-2.
 */
public class BaseFunctions {

    public static void swap(int[] a,int i,int j){
        int temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
