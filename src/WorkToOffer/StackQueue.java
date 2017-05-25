package WorkToOffer;
import java.util.Stack;
/**
 * Created by zhuhao on 17-5-24.
 */
public class StackQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push ( node );
    }

    public int pop() {
        if(!stack2.isEmpty ())
            return stack2.pop ();
        while (!stack1.isEmpty ()){
            int tmp = stack1.pop ();
            stack2.push ( tmp );
        }
        return stack2.pop ();
    }
}
