package WangYiTest.Spring2017;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by zhuhao on 17-8-17.
 *
 * 常规的表达式求值，
 * 我们都会根据计算的优先级来计算。
 * 比如*和/的优先级就高于+-。
 * 但是小易所生活的世界的表达式规则很简单，从左往右依次计算即可，而且小易所在的世界没有除法，意味着表达式中没有/，只有(+, - 和 *)。现在给出一个表达式，需要你帮忙计算出小易所在的世界这个表达式的值为多少
        输入描述:
        输入为一行字符串，即一个表达式。其中运算符只有-,+,*。参与计算的数字只有0~9.
        保证表达式都是合法的，排列规则如样例所示。


        输出描述:
        输出一个数，即表达式的值

        输入例子1:
        3+5*7

        输出例子1:
        56
 */
public class SpecialCount {
    public static void main(String[] args) {
        Scanner sc= new Scanner ( System.in );
        while (sc.hasNext ()){
            String str = sc.nextLine ();
            char[] chs = str.toCharArray ();
            Stack<Integer> numSta = new Stack<> ();
            Stack<Character> countSta = new Stack<> ();
            for (int i=chs.length-1;i>=0;i--){
                if (chs[i] >= '0' && chs[i]<='9'){
                    int num = chs[i] - '0';
                    numSta.push ( num );
                } else
                    countSta.push ( chs[i] );
            }

            while (!numSta.isEmpty () && !countSta.isEmpty ()){
                int num1 = numSta.pop ();
                int num2 = numSta.pop ();
                char ch = countSta.pop ();
                if (ch == '+'){
                    numSta.push ( num1+num2 );
                } else if (ch == '-'){
                    numSta.push ( num1-num2 );
                } else if (ch == '*')
                    numSta.push ( num1*num2 );
            }

            System.out.println (numSta.pop ());
        }
    }
}
