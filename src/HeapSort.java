import java.util.Arrays;

/**
 * Created by zhuhao on 17-5-3.
 * 堆排序，主要在于重建堆
 * 由于其对原始排序不敏感，因此最好，最坏和平均时间复杂度都是O(nlogn)
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] a = {10,3,3,54,45,6,17,8,9};
        int[] b = {30,10,90,-2,50,70,40,80,60,20,-1};
        int[] temp = HeapSort ( b );
        System.out.println (Arrays.toString ( temp ));

    }


    public static int[] HeapSort(int[] a){
        int[] b =new int[a.length+1];
        //把a数组首位加个0,赋值到b数组
        //原因是堆排序的序号从1开始，从0开始就打乱了其规则
        System.arraycopy ( a,0,b,1,a.length );

        for(int i=a.length/2;i>0;i--)
            HeapCreate ( b,i,a.length );

        for (int i=a.length;i>1;i--){
            BaseFunctions.swap ( b,1,i );
            HeapCreate ( b,1,i-1 );
        }
        //排序完成后在赋值回a数组
        System.arraycopy ( b,1,a,0,a.length );
//        System.out.println (Arrays.toString ( a ));
//        System.out.println (Arrays.toString ( b ));
        return a;
    }

    public static void HeapCreate(int[] b,int s,int m){
        int i;
        int temp = b[s];
        for (i=2*s;i <= m;i=2*i){
            //此时i指向结点s的子结点中较大的那个
            if(i<m && b[i]<b[i+1])
                i++;
            //如果父结点(s)比子结点都大(比较大的还大)，
            // 则此结点满足了大顶堆的条件，直接退出
            if(temp>b[i])
//                break;
                //用continue而不是break的原因：此时的结点s已经达到了最大堆的要求，
                //但其子结点不一定满足，因此应该继续往下找
                continue;

            b[s] = b[i];
            s=i;
        }
        b[s] = temp;
    }
}
