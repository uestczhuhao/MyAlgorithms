import java.util.BitSet;
/**
 * Created by zhuhao on 17-4-25.
 * 二叉排序树
 * 特点：根结点比左子树的所有结点都大；比又结点所有结点都小；左右子树也都是二叉树
 */
public class BinarySortTree {

    public static void main(String[] args) {
        int i;
        int[] a = {62,88,58,47,35,73,51,99,37,93};
        BinarySortTree testTree = new BinarySortTree ();
        for (i=0;i<10;i++){
            testTree.insertBST(a[i]);
        }
        testTree.PreOrderTraverse(testTree.root);
        System.out.println ();
        testTree.InOrderTraverse (testTree.root);
        System.out.println ();
        testTree.PostOrderTraverse (testTree.root);
    }

    /**
     * 初始化的空根结点
     */
    private BiTNode root;

    /**
     * 二叉排序树的点的个数
     */
    private int size =-1;
    /**
     * 返回二叉树的根结点
     */
    public BiTNode getRoot(){
        return this.root;
    }

    public BinarySortTree() {
    }
    /**
     * 前序遍历算法
     */
    public void PreOrderTraverse(BiTNode node) {
        if (node == null){
            return;
        }

        System.out.print (node.data+" ");
        PreOrderTraverse ( node.lChild );
        PreOrderTraverse ( node.rChild );
    }

    /**
     * 中序遍历算法
     */
    public void InOrderTraverse(BiTNode node) {
        if (node == null){
            return;
        }

        InOrderTraverse ( node.lChild );
        System.out.print (node.data+" ");
        InOrderTraverse ( node.rChild );
    }

    /**
     * 后序遍历算法
     */
    public void PostOrderTraverse(BiTNode node) {
        if (node == null){
            return;
        }

        PostOrderTraverse ( node.lChild );
        PostOrderTraverse ( node.rChild );
        System.out.print (node.data+" ");
    }

    /**
     * 递归查找二叉排序树T中是否存在key
     * @param current 初始调用值为二叉树的根结点
     * @param key 要查找的关键字
     * @return 找到对应的关键字则返回对应的结点，否则返回null（树为空时也返回null，要注意区分）
     */
    public BiTNode searchBST(BiTNode current, int key) {
        if (current == null)
            return null;
        else if(key == current.data)
            return current;
        else if(key < current.data)
            return searchBST ( current.lChild,key );
        else
            return searchBST ( current.rChild,key );
    }

    /**
     * 插入新结点
     * @param key 插入的新结点的数据值
     * @return 插入成功返回true，否则返回false
     */
    public boolean insertBST (int key){
        //如果树为空，则新结点为根结点
        if (this.root == null) {
            BiTNode newNode = new BiTNode (  );
            newNode.data = key;
            newNode.lChild = newNode.rChild = null;
            root = newNode;
            return true;
        }
        else {
            BiTNode serNode = this.root;
            BiTNode parentNode = new BiTNode (  );
            //while循环定位插入地点
            while (serNode != null){
                parentNode = serNode;
                if (key == serNode.data){
                    return false;
                }
                else if (key < serNode.data){
                    serNode = serNode.lChild;
                }
                else{
                    serNode = serNode.rChild;
                }
            }
            BiTNode newNode = new BiTNode (  );
            newNode.data = key;
            newNode.lChild = newNode.rChild = null;
            if (key > parentNode.data){
                parentNode.rChild = newNode;
                return true;
            }
            else {
                parentNode.lChild = newNode;
                return true;
            }
        }
    }
    /**
     * 返回二叉树是否为空树
     * @return 为空则返回true，否则返回false
     */
    public boolean isEmpty(){
        return size==-1;
    }
    /**
     * 内置类，表示树的结点
     * @ClassName BiTNode
     */
    public class BiTNode{
        private int data;
        private BiTNode lChild;
        private BiTNode rChild;
        public int getData(){
            return this.data;
        }
        public BiTNode getlChild(){
            return this.lChild;
        }
        public BiTNode getrChild(){
            return this.rChild;
        }
        public BiTNode(){

        }
        public BiTNode(int data){
            this.data = data;
            this.lChild = null;
            this.rChild = null;
        }
    }
}
