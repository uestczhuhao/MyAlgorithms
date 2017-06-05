package WorkToOffer;

/**
 * Created by zhuhao on 17-6-4.
 */
public class NumberOf1Between1AndN {
    public static void main(String[] args) {
        NumberOf1Between1AndN test = new NumberOf1Between1AndN ();
        int result = test.NumberOf1Between1AndN_Solution ( 21345);
        System.out.println (result);
    }
    ///解法1：经典解法，容易想到，时间复杂度O(n*logn)
    public int NumberOf1Between1AndN_Solution(int n) {
        if (n<=0)
            return 0;

        int number=0;
        for (int i=1;i<=n;i++)
            number+=countNumber1(i);

        return number;
    }

    public int countNumber1(int m){
        int number =0;
        while (m!=0){
            if (m%10 ==1)
                number++;

            m=m/10;
        }

        return number;
    }

    ///解法2：O(logn)的解法，从数字规律着手

    /**
     * 1. 取第 i 位左边（高位）的数字，乘以 10i−1，得到基础值 a。
     * 2. 取第 i 位数字，计算修正值：
     *      1.如果大于 X，则结果为 a+10i−1。
     *      2.如果小于 X，则结果为 a。
     *      3.如果等 X，则取第 i 位右边（低位）数字，设为 b，最后结果为 a+b+1。
     */
    public int NumberOf1Between1AndN_Solution2(int n) {
        int count = 0;
        for (int i = 1; i <= n; i *= 10) {
            int a = n / i,b = n % i;
            //之所以补8，是因为当百位为0，则a/10==(a+8)/10，
            //当百位>=2，补8会产生进位位，效果等同于(a/10+1)
            count += (a + 8) / 10 * i + ((a % 10 == 1) ? b + 1 : 0);
        }
        return count;
    }
}
