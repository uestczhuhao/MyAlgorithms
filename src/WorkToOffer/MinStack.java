package WorkToOffer;

import java.util.Stack;

/**
 * Created by zhuhao on 17-5-29.
 */
public class MinStack {

    Stack<Integer> dataStack = new Stack<> ();
    Stack<Integer> supStack = new Stack<> ();
    public void push(int node) {
        dataStack.push ( node );
        if (!supStack.isEmpty ()){
            if (node<supStack.peek ()){
                supStack.push ( node );
            } else
                supStack.push ( supStack.peek () );
        } else
            supStack.push ( node );
    }

    public void pop() {
        if (!dataStack.isEmpty () && !supStack.isEmpty ()){
            dataStack.pop ();
            supStack.pop ();
        }
    }

    public int top() {
        if (!dataStack.isEmpty ())
            return dataStack.peek ();
        else
            throw new Error ( "The Stack is null!" );

    }

    public int min() {
        if (!supStack.isEmpty ())
            return supStack.peek ();

        throw new Error ( "The Stack is null!" );
    }
}
