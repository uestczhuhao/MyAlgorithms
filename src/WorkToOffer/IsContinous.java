package WorkToOffer;

import java.util.Arrays;

/**
 * Created by zhuhao on 17-6-18.
 */
public class IsContinous {
    public boolean isContinuous(int [] numbers) {
        if (numbers == null || numbers.length==0)
            return false;

        int[] cards = sortOfTimeN ( numbers );
        int countNum0 = cards[0],tempNum0 = countNum0;
//        System.out.println (countNum0);
//        System.out.println (Arrays.toString ( numbers ));
        //如果有对子(除了0的对)，则不可能是顺子，直接返回false
        for (int i=1;i<14;i++){
            if (cards[i]>=2)
                return false;
        }
        for(int i=numbers.length-1;i>countNum0;i--){
            int diff = numbers[i]-numbers[i-1];
//            System.out.println ("diff= "+diff);
            tempNum0 -= (diff-1);
//            System.out.println ("tempNum0= "+tempNum0);
            if (tempNum0<0)
                return false;
        }

        return true;
    }

    //用空间换时间——新建一个长度为14的数组存储每张牌出现的次数
    //并返回card数组的内容
    public int[] sortOfTimeN(int[] numbers){
        int[] cards = new int[14];
        for (int i=0;i<14;i++)
            cards[i] = 0;

        for (int i=0;i<numbers.length;i++){
            if (numbers[i]<0 || numbers[i]>13)
                throw new Error ( "Illege Input" );
            int index = numbers[i];
            cards[index]++;
        }

        int index = 0;
        for (int i=0;i<14;i++){
            for (int j=0;j<cards[i];j++){
                numbers[index] = i;
                index++;
            }
        }
        return cards;
    }

//    public void swapCards(int[] cards,int a,int b){
//        int temp = cards[a];
//        cards[a] = cards[b];
//        cards[b] = temp;
//    }
}
