package PinDuoDuo.Test0902;

import java.util.*;

/**
 * Created by zhuhao on 17-9-2.
 */

public class Bears {
    /*
2 5
5 6 10 20 30
4 34
3 35
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner ( System.in );
        while (sc.hasNext ()) {
            int n = sc.nextInt ();
            int m = sc.nextInt ();
            LinkedList<Bear> que = new LinkedList<> (  );
            LinkedList<Integer> list = new LinkedList<> ();
            LinkedList<record> result = new LinkedList<> (  );
            int[] fight = new int[n];
            for (int i = 0; i < m; i++) {
                list.add ( sc.nextInt () );
            }

            for (int i = 0; i < n; i++) {
                int tmp1 = sc.nextInt ();
                int tmp2 = sc.nextInt ();
                fight[i] = tmp1;
                que.add ( new Bear ( tmp1,tmp2 ) );
            }
            Collections.sort ( que, new Comparator<Bear> () {
                @Override
                public int compare(Bear bear, Bear t1) {
                    return t1.getFight ()-bear.getFight ();
                }
            } );
            Collections.sort ( list );
            while (!que.isEmpty ()){
                Bear be = que.poll ();
                int hun = be.getHungry ();
                if (list.size () == 0){
                    System.out.println (hun);
                    continue;
                }
                int index = list.size ()-1;
                for (int i=index;i>=0 && list.size () > 0;i--){
                    if (hun >= list.get ( i )){
                        int tmp = list.get ( i );
                        hun -= tmp;
                        list.remove ( i );
                    }
                }
                result.add ( new record ( be.getFight (),hun ) );
            }

            for (int i=0;i<n;i++){
                for (int j=0;j<result.size ();j++){
                    if (fight[i] == result.get ( j ).fight){
                        System.out.println (result.get ( j ).hunRemain);
                        break;
                    }
                }
            }

        }

    }
    static class record{
        int fight;
        int hunRemain;
        public record(int a,int b){
            this.fight = a;
            this.hunRemain = b;
        }
    }
    static class Bear{
        private int fight;
        private int hungry;

        public int getFight(){
            return this.fight;
        }

        public int getHungry(){
            return this.hungry;
        }
        public Bear(int a,int b){
            this.fight = a;
            this.hungry = b;
        }
    }

}
