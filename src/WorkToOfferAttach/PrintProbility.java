package WorkToOfferAttach;

import java.util.Arrays;

/**
 * Created by zhuhao on 17-6-24.
 */
public class PrintProbility {
    int[] count = new int[1];
    public void PrintProbility(int n){
        if (n<=0)
            return;

        //sum中存储的是和为s的点数出现的次数，其中和为s的点数出现的次数保存在s-n中
        //例如：当n=2时，sum有5*2+1=11个元素，和为2的次数保存在sum[2-2]=sum[0]=1中
        int[] sum = new int[5*n+1];
        count[0]=0;
        countThisSum ( sum,1,count,n );
        System.out.println ( Arrays.toString (sum));
    }

    public void countThisSum(int[] sum,int index,int[] count,int n){
        if (index == n+1){
//            System.out.println (count[0]);
            sum[count[0]-n]++;
            return;
        }

        for (int i=1;i<=6;i++){
            count[0]+=i;
            countThisSum ( sum,index+1,count,n );
            count[0]-=i;
        }
    }


}
