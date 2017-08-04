import java.util.Arrays;

/**
 * Created by zhuhao on 17-5-6.
 */
public class MergingSort {
    public static void main(String[] args) {
//        int[] a = {10,3,3,54,45,6,17,8,9};
        int[] a = {50,10,90,30,70};
//        int[] desOut = MergingSort ( a );
        int[] desOut = mergeSort ( a );
        System.out.println ( Arrays.toString (desOut));
    }

//    public static int[] MergingSort(int[] source){
//        int[] des = new int[source.length+1];
//        int[] sorCorrect = new int[source.length+1];
//        System.arraycopy ( source,0,sorCorrect,1,source.length );
//        //调用MergeSort函数，因为此函数需要递归调用，因此需要重新包装一下
//        MergeSort ( sorCorrect,des,1,source.length );
//        int[] desOut = new int[source.length];
//        System.arraycopy ( des,1,desOut,0,desOut.length );
//        return desOut;
//    }

    /**
     * 将sourse[start...end]数组归并排序为des[start...end]
     * @param source 有序的数组
     * @param des   归并后的数组
     * @param start     数组的起始位置
     * @param end       数组的结束位置
     */
//    public static void MergeSort(int[] source,int[] des,int start,int end){
//        int middle;
//        //中间数组，用作把目的数组区分为前后两部分
//        int[] temp = new int[source.length+1];
//
////        System.out.println ("The Start is "+start);
////        System.out.println ("The End is "+end);
////        System.out.println (Arrays.toString ( des ));
//        if(start == end)
//            des[start] = source[start];
//        else {
////            System.out.println ("The Start is "+start);
////            System.out.println ("The End is "+end);
//            middle = (start+end)/2; //把source分为source[start...middle]和source[middle+1...end]两部分
////            System.out.println ("The Middle is "+middle);
//
//            MergeSort ( source,temp,start,middle ); //递归将source[start...middle]归并为有序的temp[start...middle]
//            MergeSort ( source,temp,middle+1,end ); //递归将source[middle+1...end]归并为有序的temp[middle+1...end]
//            Merge ( temp,des,start,middle,end );  //将temp[start...middle]和temp[middle+1...end]归并到des
//
////            System.out.println ("After Merge temp to des:");
////            System.out.println ("The des is "+Arrays.toString ( des ));
//
//        }
//    }

    /**
     * 将temp数组的temp[start,middle]和temp[middle+1,end]归并为有序的des[start,end]
     * @param temp      有序的数组
     * @param des       归并后的数组
     * @param start     数组的起始位置
     * @param middle    数组的中间位置
     * @param end       数组的结束位置
     */
//    public static void Merge(int[] temp,int[] des,int start,int middle,int end){
////        System.out.println ("Comming Start End and Middle are "+start+" "+end+" "+middle);
////        System.out.println ("The Temp is "+Arrays.toString ( temp ));
//
//        int i,j,k,l;
//        for (i=start,j=middle+1,k=start;i<=middle && j<=end;k++){
//            if(temp[i]<temp[j])
//                des[k] = temp[i++];
//            else
//                des[k] = temp[j++];
//        }
//        //循环之后，如果temp的前半段还有值，此时已经i++了，这个值是新的
//        //k也是一样，因为上一次循环结束后k++了，因此从本次的i和k开始循环
//        if(i<=middle){
//            for(l = 0;l<middle-i+1;l++)
//                des[k+l] = temp[i+l];
//        }else {
//            for(l = 0;l<end-j+1;l++)
//                des[k+l] = temp[j+l];
//        }
//    }


    /**
     * 递归版本的归并排序
     */

    public static int[] mergeSort(int[] arr){
        if (arr == null || arr.length == 0)
            throw new Error ( "Invalid Input!!!" );

        int[] des = new int[arr.length];
        mergeCore(arr,des,0,arr.length-1);
        return des;
    }
    public static void mergeCore(int[] src,int[] des,int start,int end){
        int mid = (start+end)>>1;
        int temp[] = new int[src.length];
        if (start == end){
            des[start] = src[start];
            System.out.println (start+" "+mid+" "+end);
            System.out.println (Arrays.toString ( des ));

        }
        else {
            ///再对中间数组进行归并排序
            ///把源数组先分开至中间数组temp
            mergeCore ( src,temp,start,mid );
            mergeCore ( src,temp,mid+1,end );
            merge2Arrs ( temp, des, start, mid ,end );
        }
    }

    public static void merge2Arrs(int[] src,int[] des,int start,int mid,int end){
        int i,j,k=start;
        for (i=start,j=mid+1;i<=mid&&j<=end;){
            if (src[i] <= src[j])
                des[k++] = src[i++];
            else
                des[k++] = src[j++];
        }

        if (i<=mid){
            for (int l=i;l<=mid;l++)
                des[k++] = src[l];
        }

        if (j<=end){
            for (int l=j;l<=end;l++)
                des[k++] = src[l];
        }

    }
}
