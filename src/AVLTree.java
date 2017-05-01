/**
 * Created by zhuhao on 17-4-30.
 * 平衡二叉树的构建，包括左旋右旋等内容
 */
public class AVLTree {
    public static void main(String[] args) {
        System.out.println ();
    }

    /**
     * 平衡树的根结点
     */
    private BiTNode root;


    /**
     * @param p 最小旋转子树的根节点
     * 向左旋转之后p(A)移到p(A)的右结点B的左子树处，p(A)的右子树B变为此最小子树根节点，
     * B的左子树变为p(A)的右子树
     * 比如：     A(-2)                    B(1)
     *              \        左旋转       /    \
     *             B(0)     ---->       A(-1)  \
     *             /   \                   \    \
     *           BL(0)  BR(0)              BL(0) BR(0)
     *  旋转之后树的深度之差不超过1
     */
    private void remoteLeft(BiTNode p) {
        System.out.println ("绕"+p.data+"左旋");
        if (p != null){
            BiTNode r = p.rChild;
            p.rChild = r.lChild;            //把p右子树的左结点嫁接到p的右结点，如上图，把BL作为A的右子节
            if (r.lChild != null)           //如果B的左节点BL不为空，把BL的父节点设为A
                r.lChild.parent = p;
            r.parent = p.parent;            //A的父节点设为B的父节点
            if (p.parent == null)           //如果p是根结点
                root = r;                   //r变为父节点，即B为父节点
            else  if (p.parent.lChild == p) //如果p是左子结点
                p.parent.lChild = r;        //p的父节点的左子树为r
            else                            //如果p是右子节点
                p.parent.rChild = r;        //p的父节点的右子树为r
            r.lChild = p;                   //p变为r的左子树，即A为B的左子树
            p.parent = r;                   //同时更改p的父节点为r，即A的父节点为B
        }
    }

    /**
     * @param p 最小旋转子树的根节点
     * 向右旋转之后，p(A)移到p(A)的左结点B的右子结点处，p(A)的左子树B变为最小旋转子树的根节点
     * B的右子节点变为p的左节点
     * 例如:       A(2)                     B(-1)
     *            /         右旋转          /    \
     *          B(0)       ------>         /     A(1)
     *         /   \                      /      /
     *       BL(0) BR(0)                BL(0)  BR(0)
     */
    private void remoteRight(BiTNode p) {
        System.out.println ("绕"+p.data+"左旋");
        if(p != null){
            BiTNode l = p.lChild;
            p.lChild = l.rChild;            //把B的右节点BR作为A的左节点
            if (l.rChild != null){          //如果BR不为null，设置BR的父节点为A
                l.rChild.parent = p;
            }
            l.parent = p.parent;            //A的父节点赋给B的父节点
            if(p.parent == null){           //如果p(A)是根结点
                root = l;                   //B为根结点
            }
            else if (p.parent.lChild == p ){
                p.parent.lChild = l;        //如果A是其父节点的左子节点,B为A的父节点的左子树
            }
            else
                p.parent.rChild = l;        //如果A是其父节点的又子节点,B为A的父节点的右子树
            l.rChild = p;                   //A是B的右子树
            p.parent = l;                   //A的父结点为B
        }
    }









    /**
     * 内置类，表示树的结点
     * @ClassName BiTNode
     */
    public class BiTNode{
        private int data;
        private int bf; //结点的平衡因子
        private BiTNode parent;
        private BiTNode lChild;
        private BiTNode rChild;
        public BiTNode(){

        }
        public BiTNode(int data){
            this.data = data;
            this.lChild = null;
            this.rChild = null;
        }
    }
}
