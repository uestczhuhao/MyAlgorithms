package WorkToOffer;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * Created by zhuhao on 17-5-31.
 */
public class PrintFromTopToButtiom {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<> (  );
        if (root == null)
            return result;

        ArrayDeque<TreeNode> deque = new ArrayDeque<> (  );
        deque.add ( root);
        while (!deque.isEmpty ()){
            TreeNode tmp = deque.pop ();
            result.add ( tmp.val );
            if (tmp.left!=null)
                deque.add ( tmp.left );
            if (tmp.right != null)
                deque.add ( tmp.right );
        }

        return result;
    }
}
