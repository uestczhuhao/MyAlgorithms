package WorkToOffer1;

import java.text.DecimalFormat;

/**
 * Created by zhuhao on 17-9-3.
 * 实现函数double Power(double base,int exponent)，不必考虑大数问题
 */
public class NPowM {
    public static void main(String[] args) {
        double base = 3;
        int exp = 0;
        DecimalFormat format = new DecimalFormat ( "0.000" );
        System.out.println ( format.format ( Power ( base,exp ) ));
    }

    private static double Power(double base,int exponent){
        if ((base-0) < 0.0001)
            throw new Error ( "Invalid Input!!" );
        if (exponent == 0){
            return 1;
        } else if (exponent < 0){
            exponent = -exponent;
            return 1.0/countCore ( base,exponent );
        } else
            return countCore ( base,exponent );
    }

    private static double countCore(double base,int exponent){
        if (exponent == 1){
            return base;
        }

        double result = countCore ( base,exponent>>1 );
        result *= result;

        if ((exponent & 1) == 1)
            return base*result;

        return result;
    }
}
