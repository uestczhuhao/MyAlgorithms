package YuanjingNengyuan;

/**
 * Created by zhuhao on 17-9-17.
 */
import java.util.*;
public class Test2 {
    public static void main(String[] args) {
        
    }

    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        result.add(new ArrayList<Integer>());

        int length = num.length;
        for (int i = 0; i < length; i++) {
            Set<ArrayList<Integer>> curr = new HashSet<ArrayList<Integer>>();
            for (List<Integer> list : result) {
                for (int j = 0; j < list.size() + 1; j++) {
                    list.add(j, num[i]);
                    ArrayList<Integer> T = new ArrayList<Integer>(list);
                    list.remove(j);
                    curr.add(T);
                }
            }
            result = new ArrayList<ArrayList<Integer>>(curr);
        }

        return result;
    }
}
