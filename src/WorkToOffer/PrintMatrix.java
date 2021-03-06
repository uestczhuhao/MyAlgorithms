package WorkToOffer;

import java.util.ArrayList;

/**
 * Created by zhuhao on 17-5-29.
 */
public class PrintMatrix {
    public ArrayList<Integer> printMatrix(int [][] matrix) {

        ArrayList<Integer> result = new ArrayList<Integer> (  );
        if (matrix.length == 0)
            return result;
        int row = matrix.length,list = matrix[0].length;
        result = doPrint(matrix,row,list);
        ArrayList result1 = doPrintSimple(matrix,row,list);
        System.out.println (result);
        System.out.println (result1);
        return result;
    }

    /**
     * 复杂的方法，利用行数和列数控制
     * @param matrix
     * @param row
     * @param list
     * @return
     */
    public ArrayList<Integer> doPrint(int[][] matrix,int row,int list){
        int start = 0;
        ArrayList<Integer> result = new ArrayList<Integer> (  );
        while (row>0 && list>0){
            int i,j,k,l;
            int count=0;
            ///从左向右打印第一行
//            System.out.println ("第一行");
            for (i=start;count<list;i++,count++){
//                System.out.print (i + " ");
                result.add ( matrix[start][i] );

            }
//            System.out.println ();
            //结束循环后，i=start+list
            //其中最后的+1是最后退出循环时加上的，因此要减去
            i--;
//            System.out.println ("i = "+i);
            ///从上到下打印第一列
//            System.out.println ("第一列");
            count=0;
            if (row == 1){
                break;
            } else {
                for (j=start+1;count<row-1;j++,count++){
//                    System.out.print (j + " ");
                    result.add ( matrix[j][i] );
                }
//                System.out.println ();
            }
            ///结束循环之后， j=start+row
            //其中最后的+1是最后退出循环时加上的，因此要减去
            j--;
//            System.out.println ("j = "+j);

            ///从右向左打印第二行，即第三步，最少需要两行两列
            ///此时的起点为matrix[i][j]
//            System.out.println ("第二行");

//            System.out.println ("i = "+i);
//            System.out.println ("j = "+j);
            count=0;
            if (row > 1 && list>1){
                for (k=i-1;count<list-1;k--,count++){
//                    System.out.print (" "+k+" "+matrix[j][k]);
                    result.add ( matrix[j][k] );
                }
//                System.out.println ();
            } else
                break;


            ///从下到上打印第二列，即第四步，要打印第四步，必须要多于两行两列
            //多余两行两列的意思是行数一定要大于2，列数可以等于2,例如一个3*2的矩阵
            //此时起点为matrix[start][j]
            count=0;
            if (row>2 && list>=2){
                for (l=j-1;count<row-2;l--,count++){
//                    System.out.println ("start ="+start+ " l="+ l+" "+matrix[l][start]);
                    result.add ( matrix[l][start] );
                }
            } else break;


            start++;
            row -=2;
            list -=2;
        }

        return result;
    }

    /**
     * 可以直接用每一次的开始和结束的坐标来控制
     */
    public ArrayList<Integer> doPrintSimple(int[][] matrix,int row,int column){
        int start = 0;
        ArrayList<Integer> result = new ArrayList<> (  );
        while (row > start*2 && column>start*2){
            int endX = column - 1 -start;
            int endY = row -1 - start;
            //从左到右打印一行
            for (int i=start;i<=endX;i++){
                result.add ( matrix[start][i] );
            }

            //从上到下打印一列
            if(start < endY){
                for (int i=start+1;i<=endY;i++){
                    result.add ( matrix[i][endX] );
                }
            }

            //从右往左打印第二行
            if (start<endX && start<endY){
                for (int i=endX-1;i>=start;i--){
                    result.add ( matrix[endY][i] );
                }
            }

            //从下到上打印一列
            if (start<endX && start<endY-1){
                for (int i=endY-1;i>=start+1;i--){
                    result.add ( matrix[i][start] );
                }
            }

            start++;
        }
        return result;
    }
}
