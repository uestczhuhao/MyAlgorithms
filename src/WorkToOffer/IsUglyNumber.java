package WorkToOffer;

import java.util.Arrays;

/**
 * Created by zhuhao on 17-6-7.
 */
public class IsUglyNumber {
    public int GetUglyNumber_Solution(int index) {
        if (index <= 0)
            return 0;
        int[] uglyNumbers = new int[index+1];
        uglyNumbers[0] = 1;
        int pointerMul2 =0,pointerMul3 =0,pointerMul5 =0;
        int nextUgly = 1;
        while (nextUgly<=index){
            int min = min ( 2*uglyNumbers[pointerMul2],3*uglyNumbers[pointerMul3],5*uglyNumbers[pointerMul5] );
            uglyNumbers[nextUgly] = min;
            while (uglyNumbers[pointerMul2]*2 <= uglyNumbers[nextUgly])
                pointerMul2++;
            while (uglyNumbers[pointerMul3]*3 <= uglyNumbers[nextUgly])
                pointerMul3++;
            while (uglyNumbers[pointerMul5]*5 <= uglyNumbers[nextUgly])
                pointerMul5++;


            ++nextUgly;
        }
//        System.out.println ( Arrays.toString ( uglyNumbers ));

        return uglyNumbers[index-1];

    }

    public int min(int A, int B, int C) {
        int min = A < B ? A : B;
        min = min<C ? min:C;
        return min;
    }
}
