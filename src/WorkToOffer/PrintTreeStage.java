package WorkToOffer;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * Created by zhuhao on 17-6-20.
 */
public class PrintTreeStage {
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<> (  );

        if (pRoot == null){
            return result;
        }

        TreeNode pointer = pRoot;
        ArrayDeque<TreeNode> currLevel = new ArrayDeque<> (  );
        currLevel.add ( pointer );
        int toBePrint = 1,nextPrint = 0;
        ArrayList<Integer> temp = new ArrayList<> (  );

        while (!currLevel.isEmpty ()){
            pointer = currLevel.pop ();
            System.out.println ("Pointer = "+pointer.val);
            if (pointer.left != null){
                nextPrint ++;
                currLevel.add ( pointer.left );
            }
            if (pointer.right != null){
                nextPrint ++;
                currLevel.add ( pointer.right );
            }
            temp.add ( pointer.val );
            --toBePrint;
            if (toBePrint == 0){
                result.add ( temp );
                toBePrint = nextPrint;
                nextPrint = 0;
                temp = new ArrayList<> (  );
            }
        }

        return result;
    }
}
