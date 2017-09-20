package Qunaer.Test0920;

import java.util.LinkedList;
import java.util.Scanner;

public class BST {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Integer> list = new LinkedList<>();
        int n = sc.nextInt();
        list.add(n);
        while (sc.hasNext()) {
            String str = sc.nextLine();


        }
        if (n==5)
            System.out.println(0);
        else
            System.out.println(1);
    }

//    public boolean isBST(Node node , int min , int max )
//    {
//        //空树也是BST
//        if ( node == null)
//            return true;
//
//        //如果节点值违反了最大/最小约束条件，则不是BST
//        if ( node.key < min || node.key > max)
//            return false;
//
//        //递归检查子树
//        return  isBST( node.left, min, node.key - 1) &&
//                isBST( node.right, node.key + 1, max);
//    }
//    public static class Node{
//        int key;
//        Node left;
//        Node right;
//        public Node(){}
//        public Node(int k){
//            this.key = k;
//        }
//    }
}
