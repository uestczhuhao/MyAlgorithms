package WorkToOffer;

import java.util.Arrays;

/**
 * Created by zhuhao on 17-6-19.
 */
public class StrToInt {
    public int StrToInt(String str) {
        if (str==null || str.length ()==0)
            return 0;

        char[] chs = str.toCharArray ();
        int positive;
        if (chs[0]=='+'){
            positive = 0;
        } else if (chs[0] == '-'){
            positive = 1;
        }
        else if (chs[0]>='0' && chs[0]<='9'){
            positive = 2;
        } else {
            return 0;
        }
        int result = convert(chs,positive);
        return result;
    }
    ////positive为0和2时为正，为1时负
    ////且为0时"+"号显示，为2时无显示"+"符号
    public int convert(char[] chs,int pos){
        int sum=0,pow=1;
        if (pos == 0 || pos ==1){
            for (int i=chs.length-1;i>0;i--){
                if (chs[i]>='0' && chs[i]<='9'){
                    int temp = chs[i]-'0';
                    temp*=pow;
                    sum+=temp;
                } else
                    return 0;
                pow *= 10;
            }
            if (pos == 1)
                sum = -sum;
        } else {
            for (int i=chs.length-1;i>=0;i--){
                if (chs[i]>='0' && chs[i]<='9'){
                    int temp = chs[i]-'0';
                    temp*=pow;
                    sum+=temp;
                } else
                    return 0;
                pow *= 10;
            }
        }
        return sum;
    }
}
