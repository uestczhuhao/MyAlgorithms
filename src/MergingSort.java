import java.util.Arrays;

/**
 * Created by zhuhao on 17-5-6.
 */
public class MergingSort {
    public static void main(String[] args) {
        int[] a = {10,3,3,54,45,6,17,8,9};
        int[] desOut = MergingSort ( a );
        System.out.println ( Arrays.toString (desOut));
    }

    public static int[] MergingSort(int[] source){
        int[] des = new int[source.length+1];
        int[] sorCorrect = new int[source.length+1];
        System.arraycopy ( source,0,sorCorrect,1,source.length );
        //调用MergeSort函数，因为此函数需要递归调用，因此需要重新包装一下
        MergeSort ( sorCorrect,des,1,source.length );
        int[] desOut = new int[source.length];
        System.arraycopy ( des,1,desOut,0,desOut.length );
        return desOut;
    }

    /**
     * 将sourse[start...end]数组归并排序为des[start...end]
     * @param source 有序的数组
     * @param des   归并后的数组
     * @param start     数组的起始位置
     * @param end       数组的结束位置
     */
    public static void MergeSort(int[] source,int[] des,int start,int end){
        int middle;
        //中间数组，用作把目的数组区分为前后两部分
        int[] temp = new int[source.length+1];

//        System.out.println ("The Start is "+start);
//        System.out.println ("The End is "+end);
//        System.out.println (Arrays.toString ( des ));
        if(start == end)
            des[start] = source[start];
        else {
            System.out.println ("The Start is "+start);
            System.out.println ("The End is "+end);
            middle = (start+end)/2; //把source分为source[start...middle]和source[middle+1...end]两部分
            System.out.println ("The Middle is "+middle);

            MergeSort ( source,temp,start,middle ); //递归将source[start...middle]归并为有序的temp[start...middle]
            MergeSort ( source,temp,middle+1,end ); //递归将source[middle+1...end]归并为有序的temp[middle+1...end]
            Merge ( temp,des,start,middle,end );  //将temp[start...middle]和temp[middle+1...end]归并到des

            System.out.println ("After Merge temp to des:");
            System.out.println ("The des is "+Arrays.toString ( des ));

        }
    }

    /**
     * 将temp数组的temp[start,middle]和temp[middle+1,end]归并为有序的des[start,end]
     * @param temp      有序的数组
     * @param des       归并后的数组
     * @param start     数组的起始位置
     * @param middle    数组的中间位置
     * @param end       数组的结束位置
     */
    public static void Merge(int[] temp,int[] des,int start,int middle,int end){
        System.out.println ("Comming Start End and Middle are "+start+" "+end+" "+middle);
        System.out.println ("The Temp is "+Arrays.toString ( temp ));

        int i,j,k,l;
        for (i=start,j=middle+1,k=start;i<=middle && j<=end;k++){
            if(temp[i]<temp[j])
                des[k] = temp[i++];
            else
                des[k] = temp[j++];
        }
        //循环之后，如果temp的前半段还有值，此时已经i++了，这个值是新的
        //k也是一样，因为上一次循环结束后k++了，因此从本次的i和k开始循环
        if(i<=middle){
            for(l = 0;l<middle-i+1;l++)
                des[k+l] = temp[i+l];
        }else {
            for(l = 0;l<end-j+1;l++)
                des[k+l] = temp[j+l];
        }
    }
}
