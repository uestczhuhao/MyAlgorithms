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

    //平衡因子的三种可能值，LH代表左高右低，EH代表左右高度相等，RH代表右高左低
    private static final int LH=1;
    private static final int EH=0;
    private static final int RH=-1;


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
    private void rotateLeft(BiTNode p) {
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
    private void rotateRight(BiTNode p) {
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
     * 左子树高度大于右子树时调用
     * 做左平衡处理
     * 平衡因子的调整如图：
     *         t                       rd
     *       /   \                   /    \
     *      l    tr   左旋后右旋    l       t
     *    /   \       ------->    /  \       \
     *  ll    rd                ll   rdl     tr
     *       /
     *     rdl
     *
     *   情况1(rd的BF为1)
     *
     *
     *         t                       rd
     *       /   \                   /    \
     *      l    tr   左旋后右旋    l       t
     *    /   \       ------->    /  \    /  \
     *  ll    rd                ll   rdl rdr  tr
     *       /   \
     *     rdl  rdr
     *
     *   情况2(rd的BF为0)
     *
     *
     *         t                       rd
     *       /   \                   /    \
     *      l    tr   左旋后右旋    l       t
     *    /   \       ------->    /       /  \
     *  ll    rd                ll       rdr  tr
     *           \
     *          rdr
     *
     *   情况3(rd的BF为-1)
     *
     *
     *         t                         l
     *       /       右旋处理          /    \
     *      l        ------>          ll   t
     *    /   \                            /
     *   ll   rd                          rd
     *   情况4(L等高)
     */
    private boolean leftBalance(BiTNode t){
        boolean heightLower = true;
        BiTNode l = t.lChild;
        switch (l.bf){
            case LH:    //左高，做右旋调整，旋转后树的高度减小
                t.bf = l.bf = EH;
                rotateRight ( t );
                break;
            case RH:    //右高，分情况讨论
                BiTNode rd = l.rChild;
                switch (rd.bf) {
                    case LH:    //情况1
                        t.bf = RH;
                        l.bf = EH;
                        break;
                    case EH:    //情况2
                        t.bf = l.bf = EH;
                        break;
                    case RH:    //情况3
                        t.bf = EH;
                        l.bf = LH;
                        break;
                }
                rd.bf = EH;
                rotateLeft ( t.lChild );
                rotateRight ( t );
                break;
            case EH:    //特殊情况4,这种情况在添加时不可能出现，只在移除时可能出现，旋转之后整体树高不变
                l.bf = RH;
                t.bf = LH;
                rotateRight ( t );
                heightLower = false;
                break;
        }
        return heightLower;
    }

    /**
     * 右子树高度大于左子树时调用
     * 做右平衡处理
     * 平衡因子的调整如图：
     * 做右平衡处理
     * 平衡因子的调整如图：
     * 注：
     *           t                               ld
     *        /     \                          /     \
     *      tl       r       先右旋再左旋     t       r
     *             /   \     -------->      /   \       \
     *           ld    rr                 tl   ldl      rr
     *          /
     *       ldl
     *       情况1(ld的BF为1)
     *
     *
     *           t                               ld
     *        /     \                          /     \
     *      tl       r       先右旋再左旋     t       r
     *             /   \     -------->      /   \    /  \
     *           ld    rr                 tl   ldl  ldr rr
     *          /  \
     *       ldl  ldr
     *       情况2(ld的BF为0)
     *
     *
     *           t                               ld
     *        /     \                          /     \
     *      tl       r       先右旋再左旋     t       r
     *             /   \     -------->      /        /  \
     *           ld    rr                 tl        ldr rr
     *             \
     *             ldr
     *       情况3(ld的BF为-1)
     *
     *           t                                  r
     *             \          左旋                /   \
     *              r        ------->           t      rr
     *            /   \                          \
     *           ld   rr                         ld
     *        情况4(r的BF为0)
     *           t                               ld
     *        /     \                          /     \
     *      tl       r       先右旋再左旋     t       r
     *             /   \     -------->      /   \       \
     *           ld    rr                 tl   ldl      rr
     *          /
     *       ldl
     *       情况1(ld的BF为1)
     *
     *           t                               ld
     *        /     \                          /     \
     *      tl       r       先右旋再左旋     t       r
     *             /   \     -------->      /        /  \
     *           ld    rr                 tl        ldr rr
     *             \
     *             ldr
     *       情况3(ld的BF为-1)
     *
     *           t                                  r
     *             \          左旋                /   \
     *              r        ------->           t      rr
     *            /   \                          \
     *           ld   rr                         ld
     *        情况4(r的BF为0)
     */
    private boolean rightBalance(BiTNode t) {
        boolean heightLower = true;
        BiTNode r = t.rChild;
        switch (r.bf){
            case LH:    //左高，分情况讨论
                BiTNode ld = r.lChild;
                switch (ld.bf){     //先调整各结点的bf，再旋转
                    case LH:    //情况1
                        t.bf = EH;
                        r.bf = RH;
                        break;
                    case EH:    //情况2
                        t.bf=r.bf = EH;
                        break;
                    case RH:    //情况1
                        t.bf = LH;
                        t.bf = EH;
                        break;
                }
                ld.bf = EH;
                rotateRight ( t.rChild );
                rotateLeft ( t );
                break;
            case RH:    //右高，左旋调整
                t.bf = r.bf = EH;
                rotateLeft ( t );
                break;
            case EH:    //特殊情况4
                r.bf = LH;
                t.bf = RH;
                rotateLeft ( t );
                heightLower = false;
                break;
        }
        return heightLower;
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
