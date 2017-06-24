package WorkToOfferAttach;

/**
 * Created by zhuhao on 17-6-24.
 * 问题描述：剑指Offer第28题的扩展
 * 在8×8的棋盘上摆着8个皇后，任意两个皇后不在同一行，同一列或者同一对角线上
 */
public class EightQueens {
    private final int QUEEN = 6;
    public static void main(String[] args) {
        EightQueens test = new EightQueens ();
        test.countEgihtQueens ();
    }
    public int countEgihtQueens(){
        int[] columnIndex = new int[QUEEN];
        for (int i=0;i<QUEEN;i++)
            columnIndex[i] = i;
        int[] count= new int[1];
        count[0] = 0;
        countCore ( 0,count,columnIndex );

        System.out.println (count[0]);
        return count[0];
    }

    //先全排列，再判断全排列之后的值是否满足条件
    public void countCore(int begin,int[] count,int[] columnIndex){
        if (begin == columnIndex.length-1){
            boolean flag = true;
            for (int i=0;i<QUEEN;i++){
                for (int j=i+1;j<QUEEN;j++)
                    if ((i-j==columnIndex[i]-columnIndex[j])
                            ||(j-i==columnIndex[i]-columnIndex[j]))
                        flag = false;
            }
            if (flag)
                count[0]++;
            return ;
        }

        for (int i=begin;i<columnIndex.length;i++){
            swapColumn ( columnIndex,begin,i );

            countCore ( begin+1,count,columnIndex );
            swapColumn ( columnIndex,begin,i );
        }
    }

    public void swapColumn(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
