package WorkToOffer;

import java.util.Stack;

/**
 * Created by zhuhao on 17-5-29.
 */
public class IsPopOrder {
    public boolean IsPopOrder(int[] pushA,int[] popA){
        if (pushA.length != popA.length)
            return false;
        if (pushA.length == 0)
            return true;

        boolean isOrNot = true;
        int pointer1=0,pointer2=0;
        Stack<Integer> stack = new Stack<> ();
        while (pointer2<popA.length){
            if (!stack.isEmpty ()){
                if (popA[pointer2] == stack.peek ()){
                    stack.pop ();
                    pointer2++;
                }
            }
            while (stack.isEmpty () || stack.peek () != popA[pointer2]){
                if (pointer1 >= pushA.length)
                    break;
                stack.push ( pushA[pointer1] );
                pointer1++;
            }
            System.out.println (stack);
            if (pointer1 >= pushA.length && !stack.isEmpty () &&stack.peek ()!=popA[pointer2]){
                isOrNot =false;
                return isOrNot;
            }
        }

        return isOrNot;
    }
}
