package WorkToOffer;

/**
 * Created by zhuhao on 17-6-17.
 //num1,num2分别为长度为1的数组。传出参数
 //将num1[0],num2[0]设置为返回结果
 */
public class FindNumberAppearOnce {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if (array == null || array.length<2)
            return;

        int resultExcOr = 0;
        for (int i=0;i<array.length;i++)
            resultExcOr ^= array[i];
        int indexOf1 = findFirstBitIs1(resultExcOr);
        num1[0] = num2[0] =0;
        for (int j=0;j<array.length;j++){
            if (IsBit1(array[j],indexOf1))
                num1[0] ^= array[j];
            else num2[0] ^= array[j];
        }
    }

    public int findFirstBitIs1(int num){
        int indexBit = 0;
        while (((num &1 )==0) && (indexBit <32)){
            num = num>>1;
            indexBit ++;
        }
        return indexBit;
    }

    public boolean IsBit1(int num,int indexBit){
        num = num >> indexBit;
        if ((num & 1) == 0 )
            return false;
        return true;
    }
}
