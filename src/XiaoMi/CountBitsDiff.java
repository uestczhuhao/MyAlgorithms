package XiaoMi;

import Didi.DecToN;

/**
 * Created by zhuhao on 17-8-26.
 */
public class CountBitsDiff {
    public static void main(String[] args) {
        CountBitsDiff t = new CountBitsDiff ();

        System.out.println (t.countBitDiff ( 1999,2299));
    }

    public int countBitDiff(int m, int n) {
        int tmpM = m;
        int tmpN = n;
        int res = 0;
        while (tmpM != 0 || tmpN!=0){
            if ((tmpM &1) != (tmpN&1))
                res++;
            tmpM>>=1;
            tmpN>>=1;
        }

        return res;
    }
}
