package WorkToOffer;

import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * Created by zhuhao on 17-5-22.
 * 在一个二维数组中，
 * 每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。
 *
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class Find {
    public static void main(String[] args) {
        int[][] test = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
//        System.out.println (test[4].length);
        System.out.println (Find(10,test));
    }
    public static boolean Find(int target, int[][] array){
        if (array.length == 0)
            return false;
        int row = array.length;
        int list = array[0].length;
        int xIndex=0,yIndex=list-1;
        while (xIndex >=0 && xIndex<row && yIndex >= 0 && yIndex <list){
            int numIndex = array[xIndex][yIndex];
//            System.out.println ("x,y = "+xIndex + " "+yIndex);
//            System.out.println (numIndex);
            if(numIndex == target)
                return true;
            else if(numIndex > target){
                yIndex --;
            } else xIndex++;

        }

        return false;
    }
}
