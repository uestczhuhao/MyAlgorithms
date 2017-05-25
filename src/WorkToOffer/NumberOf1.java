package WorkToOffer;

/**
 * Created by zhuhao on 17-5-25.
 */
public class NumberOf1 {

    public static void main(String[] args) {
        int n=121;
        int res = numberOf1Normal ( n );
        System.out.println (res);
    }

    /**
     * 常规解法，声明flag=1,与已知的n做与运算
     * 如果n的最后一位为1,则结果为1,否则为零
     * 把flag向左移动一位，即为01,检查n的倒数第二位是否为1
     * 重复此过程32次（因为int类型是32位的）
     */
    public static int numberOf1Normal(int n){
        int count = 0;
        int num = 0;
        int flag = 1;
        while (flag!=0){
            num++;
            if ((n & flag)!=0){
                count++;
            }

            flag = flag <<1;
        }
        System.out.println (num);
        return count;
    }
    /**
     * 分析：把一个整数用二进制表示，有两种情况：
     * 1.最后一位为1，此时假设n=1101，则n-1=1100，
     * 用n和n-1相与，则n&(n-1)=1100
     * 2.最后一位不为1，如n=1100，n-1=1011，
     * 用n和n-1相与，则n&(n-1)=1000
     *
     * 观察上述两种情况，n和n-1相与以后，会把n的最右边的1变成0
     * 那么一个整数的二进制表示中有多少个1,就进行多少次这样的操作
     */
    public int numberOf1(int n){
        int count = 0;
        while (n != 0){
            count ++;
            n = n&(n-1);
        }

        return count;
    }
}
