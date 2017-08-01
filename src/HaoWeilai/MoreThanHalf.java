package HaoWeilai;

import java.util.Scanner;

/**
 * Created by zhuhao on 17-7-31.
 */
public class MoreThanHalf {

    public static void main(String[] args) {
        Scanner in = new Scanner ( System.in );
        String str = in.nextLine ();
        String[] strs = str.split ( " " );
        int[] ints = new int[strs.length];
        for (int i=0;i<strs.length;i++)
            ints[i] = Integer.parseInt(strs[i]);

        int result = MoreThanHalfSimple(ints);
        System.out.println (result);
    }


    public static int MoreThanHalfSimple(int[] array){
        if (array == null || array.length ==0)
            return 0;

        //result记录之前的值，如果下一个值与记录值相同
        //则time加1,不一样则减1
        int result=array[0],time = 1;
        for (int i=1;i<array.length;i++){
            //如果次数为0,则重新计算
            if (time == 0){
                result = array[i];
                time++;
            } else if(result == array[i])
                time++;
            else time--;
        }

//        System.out.println (result);
        if (!isMoreThanHalfNum ( array,result ))
            result = 0;
        return result;
    }
    public static boolean isMoreThanHalfNum(int[] array,int result){
        int count=0;
        boolean isOrNot = false;

        for (int i=0;i<array.length;i++){
            if (array[i] == result)
                count++;
        }
        if (count*2 >= array.length)
            isOrNot = true;

        return isOrNot;
    }
}
