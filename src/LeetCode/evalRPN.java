package LeetCode;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by zhuhao on 17-5-10.
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are+,-,*,/. Each operand may be an integer or another expression.
 * Some examples:
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 * 逆波兰形式参考《大话数据结构》第105页，或维基百科（https://zh.wikipedia.org/wiki/%E9%80%86%E6%B3%A2%E5%85%B0%E8%A1%A8%E7%A4%BA%E6%B3%95）
 */
public class evalRPN {
    public static void main(String[] args) {
//        String[] strs = {"as","sad","dd"};
//        Stack operateStack = new Stack ();
//        operateStack.push ( strs[0] );
//        operateStack.push ( 1 );
//        Object temp = operateStack.pop ();
//        Object temp1 = operateStack.pop ();
//        System.out.println (temp+" "+ temp.getClass ().getName ());
//        System.out.println (temp1+" "+ temp1.getClass ().getName ());
//        String[] strs = {"4", "13", "5", "/", "+"};
        String[] strs = {"9","3","1","-","3","*","+","10","2","/","+"};
        System.out.println (evalRPN ( strs ));
//        System.out.println ( strs[2]);
    }

    public static int evalRPN(String[] tokens){
        Stack numStack = new Stack ();
        Stack operateStack = new Stack ();
        for (int i=0;i<tokens.length;i++){
            Object opeNum1,opeNum2;
            int result;
            String resultStr;
            switch (tokens[i]){
                case "+":
                    opeNum1 = numStack.pop ();
                    opeNum2 = numStack.pop ();
                    result = Integer.parseInt ( opeNum1.toString () ) + Integer.parseInt ( opeNum2.toString () );
                    resultStr = String.valueOf ( result );
                    numStack.push ( resultStr );
                    break;
                case "-":
                    opeNum1 = numStack.pop ();
                    opeNum2 = numStack.pop ();
                    result = Integer.parseInt ( opeNum2.toString () ) - Integer.parseInt ( opeNum1.toString () );
                    resultStr = String.valueOf ( result );
                    numStack.push ( resultStr );
                    break;
                case "*":
                    opeNum1 = numStack.pop ();
                    opeNum2 = numStack.pop ();
                    result = Integer.parseInt ( opeNum1.toString () ) * Integer.parseInt ( opeNum2.toString () );
                    resultStr = String.valueOf ( result );
                    numStack.push ( resultStr );
                    break;
                case "/":
                    opeNum1 = numStack.pop ();
                    opeNum2 = numStack.pop ();
                    result = Integer.parseInt ( opeNum2.toString () ) / Integer.parseInt ( opeNum1.toString () );
                    resultStr = String.valueOf ( result );
                    numStack.push ( resultStr );
                    break;
                default:
                    numStack.push ( tokens[i] );
                    break;
            }


        }
        return Integer.parseInt ( numStack.pop ().toString () );
    }


}

