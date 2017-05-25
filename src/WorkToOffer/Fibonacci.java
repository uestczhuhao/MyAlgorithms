package WorkToOffer;

/**
 * Created by zhuhao on 17-5-25.
 */
public class Fibonacci {
    //递归解法
    public int fibonacci(int n){
        if(n<=0)
            return 0;
        if(n==1 || n==2)
            return 1;
        return fibonacci ( n-1 )+fibonacci ( n-2);
    }

    //循环解法
    public int fibonacci2(int n){
        int[] result = {0,1,1};
        if(n<=2){
            return result[n];
        }

        int result1 = result[1];
        int result2 = result[2];
        int resultFinal = 0;
        for (int i=3;i<=n;i++){
            resultFinal = result1 +result2;

            result1 = result2;
            result2 = resultFinal;
        }
        return resultFinal;
    }
}
