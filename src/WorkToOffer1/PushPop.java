package WorkToOffer1;

import java.util.Stack;

public class PushPop {
    public static void main(String[] args) {
        int[] push = {1,2,3,4,5};
//        int[] pop = {4,5,3,1,2};
        int[] pop = {1,2,3,4,5};
        System.out.println(isOrder(push,pop));
    }

    public static boolean isOrder(int[] push,int[] pop){
        boolean res = false;
        int n = push.length;
        if (pop.length != n)
            return res;

        int index =1;
        int index1 = 0;
        Stack<Integer> sta = new Stack<>();
        sta.push(push[0]);
        while (!sta.isEmpty() || index < n){
            while (sta.isEmpty() || (sta.peek() != pop[index1] && index < n)){
                sta.push(push[index]);
                index ++;
            }
            if (sta.peek() == pop[index1]){
                sta.pop();
                index1++;
            } else {
                break;
            }
        }
        if (sta.isEmpty() && index1 == n){
            res = true;
        }
        return res;
    }

}
