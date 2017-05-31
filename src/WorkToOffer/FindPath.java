package WorkToOffer;

import java.util.ArrayList;

/**
 * Created by zhuhao on 17-5-31.
 */
public class FindPath {
    ArrayList<ArrayList<Integer>> resultsList = new ArrayList<ArrayList<Integer>>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>> (  );
        if (root == null)
            return result;

        ArrayList<Integer> path = new ArrayList<> (  );
        findPath(path,root,target,0);
        return resultsList;
    }

    public void findPath(ArrayList<Integer> path,TreeNode root,int target,int currSum){
        if (root == null)
            return;

        boolean isLeaf;
        isLeaf = ((root.left == null) && (root.right == null));

        currSum += root.val;
        path.add ( root.val);

        if (isLeaf){
            if (currSum == target){
                /*
                * 大坑在这，这里一定要copy一份出来，而且是copy的新对象
                * 因为java语法规定，path只是一个引用，
                * 而resultsList中保存的是一份引用值，当此引用path改变时，
                * 会连带着之前保存的老的path值也改变
                 */
                Object pathCopy = path.clone ();
                resultsList.add ( (ArrayList<Integer>) pathCopy );
            }
        }
        if (currSum < target && root.left != null)
            findPath ( path,root.left,target,currSum );
        if (currSum < target && root.right != null)
            findPath ( path,root.right,target,currSum );

        path.remove ( path.size ()-1 );
    }


}
