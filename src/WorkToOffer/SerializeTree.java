package WorkToOffer;

import sun.reflect.generics.tree.Tree;

import java.util.Arrays;

/**
 * Created by zhuhao on 17-6-21.
 */
public class SerializeTree {
    StringBuffer serial = new StringBuffer (  );
    String Serialize(TreeNode root) {
        String result = "";
        if (root == null)
            return result;

        doSerialize ( root );
        serial.deleteCharAt ( 0 );
        result = serial.toString ();
        return result;
    }
    TreeNode Deserialize(String str) {
        if (str == "")
            return null;
        String[] strings = str.split ( "," );
        int[] index = new int[1];
        index[0] = 0;
        TreeNode root = doDeserialize(strings,index);

        return root;
    }

    public void doSerialize(TreeNode root){
        if (root == null){
            serial.append ( ',' );
            serial.append ( '$' );
            return;
        }
        serial.append ( ',' );
        serial.append ( root.val );
        doSerialize ( root.left );
        doSerialize ( root.right );
    }

    public TreeNode doDeserialize(String[] strings,int[] index){
        if (!strings[index[0]].equals ( "$" ) ){
            TreeNode root = new TreeNode ( 0 );
            root.val = Integer.parseInt ( strings[index[0]] );
            index[0]++;
            root.left = doDeserialize ( strings,index );
            root.right = doDeserialize ( strings,index );
            return root;
        } else {
            index[0]++;
        }
        return null;
    }
}
