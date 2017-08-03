import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by zhuhao on 17-8-3.
 *
 * 基数排序
 * 时间复杂度为O(k*n)，其中k为常数（即最大数的位数），n为数据规模
 * 空间复杂度O(10*n)，建立一个10*n的二维数组用于存储
 */
public class RadixSort {
    public static void main(String[] args) {
        RadixSort test = new RadixSort ();
        int[] arr = {1,32,123,3,5,23,432};

        System.out.println (Arrays.toString ( arr ));
        test.radixSort ( arr );

        System.out.println ( Arrays.toString ( arr ) );

    }

    public void radixSort(int[] arr){
        if (arr == null || arr.length == 0)
            throw new Error ( "Invalid Input!!!" );

        int n = arr.length;
        int[][] temp = new int[10][n];
        int maxLen = countLength ( arr[0] );


        for (int i=1;i<n;i++){
            if (countLength ( arr[i] )>maxLen)
                maxLen = countLength ( arr[i] );
        }

        for (int i=0;i<maxLen;i++){
            clear2(temp);
            int count[] = new int[10];
            ////把数据放入对应的桶中
            for (int j=0;j<n;j++){
                int divide = (int)Math.pow ( 10,i );
                int num = (arr[j]/divide)%10;

                temp[num][count[num]++] = arr[j];
            }
            for (int iii=0;iii<10;iii++)
                System.out.println (Arrays.toString ( temp[iii]));

            ////从桶中取出数据，并按照大小排序
            int k=0;
            for (int j=0;j<10;j++){
//                System.out.println ("Count array are "+Arrays.toString ( count ));
                for (int cou=0;cou<count[j];cou++){
                    arr[k] = temp[j][cou];
                    k++;
                }
            }
            clear1 ( count );
        }

    }

    public void clear1(int[] arr){
        int row = arr.length;


        for (int i=0;i<row;i++){
            arr[i] = 0;
        }
    }
    public void clear2(int[][] arr){
        int row = arr.length;
        int col = arr[0].length;

        for (int i=0;i<row;i++){
            for (int j=0;j<col;j++)
                arr[i][j] = 0;
        }
    }
    public int countLength(int n){
        int count = 0;
        while (n!=0){
            count++;
            n=n/10;
        }

        return count;
    }
    public void swapArr(int[] arr,int a,int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
