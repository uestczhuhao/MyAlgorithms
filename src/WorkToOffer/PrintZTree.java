package WorkToOffer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by zhuhao on 17-6-21.
 */
public class PrintZTree {
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<> (  );

        if (pRoot == null)
            return result;
        Stack<TreeNode> oddLevel = new Stack<> ();
        Stack<TreeNode> evevLevel = new Stack<> ();
        oddLevel.add ( pRoot );
        int currLevel = 1;

        while((!oddLevel.isEmpty ()) || (!evevLevel.isEmpty ())){
            TreeNode pointer;
            ArrayList<Integer> temp = new ArrayList<> (  );
            //如果此时层数为偶，则打印输出evenLevel中的数据
            //把下一层的数据存入oddLevel中，反之亦然
            if ((currLevel & 1) == 0){
                while (!evevLevel.isEmpty ()){
                    pointer = evevLevel.pop ();
                    temp.add ( pointer.val );
                    if (pointer.right != null)
                        oddLevel.add ( pointer.right );
                    if (pointer.left != null)
                        oddLevel.add ( pointer.left );
                }

            } else{
                while (!oddLevel.isEmpty ()){
                    pointer = oddLevel.pop ();
                    temp.add ( pointer.val );
                    if (pointer.left != null)
                        evevLevel.add ( pointer.left );
                    if (pointer.right != null)
                        evevLevel.add ( pointer.right );
                }
            }
            result.add ( temp );
            currLevel++;
        }
        return result;
    }
}
