package LeetCode;

/**
 * Created by zhuhao on 17-5-18.
 * Given an array of integers,
 * every element appears three times except for one.
 * Find that single one.
 * Note:
 * Your algorithm should have a linear runtime complexity.
 * Could you implement it without using extra memory?
 */
public class SingleNumber {

    /**
     * 异或运算满足交换率，即A^B^C=A^C^B
     * 且两个相等的数异或为0,0与任何书异或为其本身0^A=A
     * @param A
     * @return
     */
    public int singleNumber(int[] A) {
        int result = A[0];
        for (int i = 1; i < A.length; i++){
            result = result ^ A[i];
            System.out.println (result);
        }
        return result;
    }
    /**
     * Single Number的本质，就是用一个数记录每个bit出现的次数，
     * 如果一个bit出现两次就归0，
     * 这种运算采用二进制底下的位操作^是很自然的。
     * Single Number II中，如果能定义三进制底下的某种位操作，
     * 也可以达到相同的效果，
     * Single Number II中想要记录每个bit出现的次数，
     * 一个数搞不定就加两个数，用ones来记录只出现过一次的bits，
     * 用twos来记录只出现过两次的bits，
     * ones&twos实际上就记录了出现过三次的bits，
     * 这时候我们来模拟进行出现3次就抵消为0的操作，
     * 抹去ones和twos中都为1的bits。
     */
    public int singleNumber2 (int[] A) {
        int ones = 0;//记录只出现过1次的bits
        int twos = 0;//记录只出现过2次的bits
        int threes;
        for (int i = 0; i < A.length; i++) {
            int t = A[i];
            twos |= ones & t;//要在更新ones前面更新twos
            ones ^= t;
            threes = ones & twos;//ones和twos中都为1即出现了3次
            ones &= ~threes;//抹去出现了3次的bits
            twos &= ~threes;
            System.out.println ("A[i] is "+A[i]);
            System.out.println ("ones is "+ones);
            System.out.println ("twos is "+twos);
            System.out.println ("threes is "+threes);
        }
        return ones;
    }
}
