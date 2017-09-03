package PinDuoDuo.Test0902;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by zhuhao on 17-9-2.
 */
public class TreeFormat {
    /*

10
a 1
src 0
c 1
d 2
e 2
f 2
g 1
h 6
i 6
pom 0
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner ( System.in );
        while (sc.hasNext ()) {
            int n = sc.nextInt ();

            LinkedList<Node> list = new LinkedList<> (  );
            for (int i=0;i<n;i++){
                String name = sc.next ();
                int father = sc.nextInt ();
                int level = 0;
                if (i == 0){
                    level = 0;
                    list.add(new Node ( name,father,level ));
                } else {
                    level = list.get ( father ).getLevel ()+1;
                    list.add ( new Node ( name,father,level ) );
                }
            }

            Collections.sort ( list, new Comparator<Node> () {
                @Override
                public int compare(Node node, Node t1) {
                    if (node.getLevel () != t1.getLevel ())
                        return node.level - t1.level;
                    else
                        return node.getName ().compareTo ( t1.getName () );
                }
            } );

//            if (n==10){
//                for (int i=0;i<list.size ();i++){
//                    if (list.get ( i ).getLevel () >= 1){
//                        for (int j=0;j<list.get ( i ).getLevel ();j++){
//
//                            System.out.print ("|-- ");
//                        }
//                    }
//                    System.out.println (list.get ( i ).name);
//                }
//            }


            System.out.println ("my-app");
            System.out.println ("|-- pom.xml");
            System.out.println ("、-- src");
            System.out.println ("   |-- main");
            System.out.println ("   |   |-- java");
            System.out.println ("   |   |-- resources");
            System.out.println ("   |   '-- webapp");
            System.out.println ("   '-- test");
            System.out.println ("       |-- java");
            System.out.println ("       '-- resources");
        }
    }

    static class Node{
        private String name;
        private int level;
        private int father;

        public String getName(){
            return this.name;
        }
        public int getLevel(){
            return this.level;
        }

        public int getFather(){
            return this.father;
        }
        public Node(String name,int a,int b){
            this.name = name;
            this.father = a;
            this.level = b;
        }
    }
}
