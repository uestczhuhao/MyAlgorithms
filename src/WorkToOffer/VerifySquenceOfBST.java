package WorkToOffer;

import java.util.Arrays;

/**
 * Created by zhuhao on 17-5-31.
 */
public class VerifySquenceOfBST {

    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length==0)
            return false;

        boolean result = false;
        int length =sequence.length;
        int root = sequence[length-1];
        //寻找左子树，其值都小于root值
        int i;
        for (i=0;i<length-1;i++){
            if (sequence[i]>root)
                break;
        }
        //寻找右子树，其值都大于root值
        int j=i;
        for (;j<length-1;j++){
            if (sequence[j]<root)
                return false;
        }

        //判断左子树是否为二叉搜索树
        boolean left =true;
        if (i>0){
            if (length==1)
                return true;
            int[] seqTemp = new int[i];
            System.arraycopy ( sequence,0,seqTemp,0,seqTemp.length );
//            System.out.println ( Arrays.toString (seqTemp));
            left = VerifySquenceOfBST ( seqTemp );
        }

        //判断右子树是否为二叉搜索树
        boolean right = true;
        if (i<length-1){
            if (length==1)
                return true;
            int[] seqTemp = new int[length-1-i];
            System.arraycopy ( sequence,i,seqTemp,0,seqTemp.length );
//            System.out.println ( Arrays.toString (seqTemp));
            right = VerifySquenceOfBST ( seqTemp );
        }

        result = left && right;
        return result;
    }
}
