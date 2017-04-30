import java.util.BitSet;
/**
 * Created by zhuhao on 17-4-25.
 * 二叉排序树
 * 特点：根结点比左子树的所有结点都大；比又结点所有结点都小；左右子树也都是二叉树
 */
public class BinarySortTree {

    public static void main(String[] args) {
        int i;
//        int[] a = {62,88,58,47,35,73,51,99,37,93};
        int[] b = {62,88,58,47,35,73,51,99,37,93,29,36,48,49,56,50};
        BinarySortTree testTree = new BinarySortTree ();
        for (i=0;i<16;i++){
            testTree.insertBST(b[i]);
        }
        testTree.PreOrderTraverse(testTree.root);
        System.out.println ();
//        testTree.InOrderTraverse (testTree.root);
//        System.out.println ();
//        testTree.PostOrderTraverse (testTree.root);
        testTree.deleteBST ( 50 );
        testTree.PreOrderTraverse(testTree.root);

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
     * 从二叉排序树中删除key，并保证删除后的树还是一棵二叉排序树
     * 对删除的结点有以下三种情况：
     * 1.叶子结点
     * 2.仅有左或右子树的结点
     * 3.左右子树都有的结点
     * @param key 要删除的关键字key
     * @return 删除成功返回true，否则返回false
     */
    public boolean deleteBST(int key) {
        BiTNode p =root;
        BiTNode parent = root;
        if (p == null)
            return false;
        else{
            //while循环是为了找到关键字对应的结点p，并同时把其双亲结点保存下来（后面的功能更重要）
            boolean isLeft = false;
            //isLeft存储要删除的结点p是其双亲结点的左孩子还是右孩子，以便恢复二叉树结构时出错
            while (p.data != key){
                parent = p;
                if (key <p.data){
                    isLeft = true;
                    p = p.lChild;
                }
                else {
                    isLeft = false;
                    p = p.rChild;
                }

                if (p == null)
                    return false;
            }
            BiTNode temp = null;
            if (p.rChild == null){
                if (p.lChild == null)
                    System.out.println ("This Node has no Child!");
                else
                    System.out.println ("This Node Only has Left Child!");
                p = p.lChild;
                if (isLeft)
                    parent.lChild = p;
                else parent.rChild = p;
            }
            else if(p.lChild == null){
                System.out.println ("This Node Only has Right Child!");
                p = p.rChild;
                if (isLeft)
                    parent.lChild = p;
                else parent.rChild = p;
            }
            else {
                System.out.println ("This Node has Left and Right Child!");
                temp = p;
                BiTNode s = p.lChild;
                /**转向左子树，然后向右走到“尽头”*/
                while(s.rChild != null){
                    temp = s;
                    s = s.rChild;
                }
                p.data= s.data;
                if(temp != p){
                    temp.rChild = s.lChild;
                }
                else{
                    temp.lChild = s.lChild;
                }
                s = null;
            }
            return true;

//            if (p.data == key){
//
//                return delete ( p );
//            }
//            else if (key < p.data){
//                return deleteBST ( p.lChild,key );
//            }
//            else
//                return deleteBST ( p.rChild,key );
        }
    }

    public boolean delete (BiTNode node,BiTNode parent){
        BiTNode temp = null;

        return true;
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
