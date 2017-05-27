package WorkToOffer;

/**
 * Created by zhuhao on 17-5-25.
 */
public class Power {
    public double power(double base, int exponent){
        if (Math.abs ( base-0.0 )<0.00001){
            if (exponent >= 0)
                return 0.0;
            else
                System.out.println ("Infinity");
        }

        double result = 0.0;
        if (exponent < 0){
            exponent = -exponent;
            result = calculate ( base, exponent);
            result = 1.0/result;
        } else if(exponent ==0){
            return 1;
        } else {
            result = calculate ( base,exponent );
        }

        return result;
    }

    public double calculate(double base,int exponent){
        if (exponent ==1)
            return base;
        if (exponent == 0)
            return 1;

        //递归调用自己，每次把exponent右移一位，等效除二
        double result = calculate ( base,exponent >>1 );
        result *= result;
        //与1做与运算则证明exponent为奇数，a^n=a^((n-1)/2)*a^((n-1)/2)*a
        //否则exponent为偶数，则此时a^n=a^(n/2)*a^(n/2)
        if((exponent & 1) == 1)
            result *= base;
        return result;
    }
}
