package WorkToOffer;

/**
 * Created by zhuhao on 17-6-19.
 * 写一个函数，求两个整数之和，
 * 要求在函数体内不得使用+、-、*、/四则运算符号。
 */
public class Add {
    public int Add(int num1,int num2) {
        //sum保存累加的和，
        //carry保存进位值
        int sum,carry;
        do {
            //sum的结果与异或结果一致（不包含进位）
            sum = num1^num2;
            //进位值等效为两数相与左移一位
            //0+1,0+1,1+0都不产生进位，只有1+1产生进位
            carry = (num1&num2) <<1;
            num1 = sum;
            num2 = carry;
        }while (num2!=0);

        return num1;
    }
}
