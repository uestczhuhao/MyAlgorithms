import java.util.Arrays;

/**
 * Created by zhuhao on 17-8-15.
 */
public class TestNewCoder {
//    public static TestNewCoder t1 = new TestNewCoder();
//    public static TestNewCoder t2 = new TestNewCoder();
//    {
//        System.out.println("构造块");
//    }
//    static
//    {
//        System.out.println("静态块");
//    }
//    public static void main(String[] args)
//    {
//        TestNewCoder t = new TestNewCoder();
//    }

    public static void main(String[] args) {
            long n = (long) 16;
        System.out.println(Arrays.toString(createArr(n)));
        long[] dp = new long[(int)(n+(int)1)];
        dp[0] = 1;
        long a=1,b=2;
        if (a -dp[0] >=0){

        }
    }

    public static long[] createArr(long n){
        int index = 1;
        while ((long) Math.pow(2,index) <= n){
            index++;
        }

        System.out.println(index);
        long[] arr = new long[2*index];
        int tmp =0;
        for (int i=0;i<2*index-1;i+=2){
            arr[i] = (long) Math.pow(2,tmp);
            arr[i+1] = arr[i];
            tmp++;
        }
        return arr;
    }
}
