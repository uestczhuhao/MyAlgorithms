package WorkToOffer1;

public class IsSubtree {
    public static void main(String[] args) {
        Node rootA = new Node(8);
        Node node1 = new Node(8);
        Node node2 = new Node(7);
        Node node3 = new Node(9);
        Node node4 = new Node(2);
        Node node5 = new Node(4);
        Node node6 = new Node(7);
        rootA.left = node1;
        rootA.right = node2;
        node1.left = node3;
        node1.right = node4;
        node4.left = node5;
        node4.right = node6;

        Node rootB = new Node(8);
        Node node7 = new Node(9);
        Node node8 = new Node(2);
        rootB.left = node7;
        rootB.right = node8;
        System.out.println(isSub(rootA,rootB));
    }

    public static boolean isSub(Node root1,Node root2){

        boolean result = false;

        if (root1 != null && root2!=null){

            if (root1.data == root2.data){
                result = hasSub(root1,root2);
            }
            if (!result){
                result = isSub(root1.left,root2);
            }
            if (!result) {
                result = isSub(root1.right,root2);
            }
        }

        return result;
    }

    public static boolean hasSub(Node root1,Node root2){
        if (root2 == null)
            return true;
        if (root1 == null)
            return false;

        if (root1.data != root2.data)
            return false;

        return hasSub(root1.left,root2.left)&& hasSub(root1.right, root2.right);
    }

    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int a){
            this.data =a;
        }
    }
}
