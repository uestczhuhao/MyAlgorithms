package WorkToOffer;

import java.util.ArrayList;

/**
 * Created by zhuhao on 17-6-21.
 */
public class MiddleNumber {
    private ArrayList<Integer> list = new ArrayList<> (  );
    //使用无序数组，插入时直接在尾部，时间为O(1)
    //得到中位值用快排方法，时间复杂度为O(n)
    public void Insert(Integer num) {

        list.add ( num );
    }

    public Double GetMedian() {
        if (list==null || list.size () == 0)
            return 0.0;
        int length = list.size ();

        int middle1 = 0,middle2 = 0;
        if ((length &1) !=0){
            middle1 = middle2 = length/2;
            return (double)getKthNum ( middle1 );
        } else {
            middle2 = length/2;
            middle1 = middle2-1;
            int mid1 = getKthNum ( middle1 );
            int mid2 = getKthNum ( middle2 );
            double ave = (double)(mid1+mid2)*1.0/2;
            return ave;
        }
    }

    public int getKthNum(int k){
        if (k<0)
            return Integer.MIN_VALUE;

        int start= 0,end = list.size ()-1;
        int index = partition ( list,start,end );

        while (index != k){
            if (index > k){
                end = index-1;
                index = partition ( list,start,end );
            } else {
                start = index+1;
                index = partition ( list,start,end );
            }
        }

        return list.get ( k );
    }

    public int partition(ArrayList<Integer> list,int start,int end){
        if (start <0 || end>=list.size ())
            throw new Error ( "Invalid Input!" );
        int temp = list.get ( start );
        while (start<end){
            while (start<end && list.get ( end ) >=temp )
                end--;
            list.set ( start,list.get ( end ) );
            while (start<end && list.get ( start )<= temp)
                start++;
            list.set ( end,list.get ( start ) );
        }
        list.set ( start,temp );
        return start;
    }

    //用最大堆和最小堆实现，暂时放弃
//    public void minHeapAdjust(ArrayList<Integer> list,int low,int high){
//
//    }
//
//    public void maxHeapAdjust(ArrayList<Integer> list,,int low,int high){
//
//    }
}
