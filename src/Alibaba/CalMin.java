package Alibaba;

/**
 * Created by zhuhao on 17-7-7.
 * 测试输入：
 1 0 2
 2 0 3
 3 1 2
 4 1 3
 0
 */
import java.util.*;

public class CalMin {
    public static void main(String[] args) {

        ArrayList<Integer> _ids = new ArrayList<Integer>();
        ArrayList<Integer> _parents = new ArrayList<Integer>();
        ArrayList<Integer> _costs = new ArrayList<Integer>();

        Scanner in = new Scanner(System.in);
        String line = in.nextLine();

        while(line != null && !line.isEmpty()) {
            if(line.trim().equals("0")) break;
            String []values = line.trim().split(" ");
            if(values.length != 3) {
                break;
            }
            _ids.add(Integer.parseInt(values[0]));
            _parents.add(Integer.parseInt(values[1]));
            _costs.add(Integer.parseInt(values[2]));
            line = in.nextLine();
        }
        int res = resolve(_ids, _parents, _costs);

        System.out.println(String.valueOf(res));
    }

    // write your code here
    public static int resolve(ArrayList<Integer> ids, ArrayList<Integer> parents, ArrayList<Integer> costs) {
        if (ids.isEmpty () || parents.isEmpty () || costs.isEmpty ())
            return 0;
        int len1=ids.size (),len2=parents.size (),len3=costs.size ();
        if (len1 != len2 || len1!=len3 || len2!=len3)
            return 0;

        int[] root = new int[len1];
        int i=0,j=0;
        ArrayList<Integer> count = new ArrayList<> (  );

        for (i=0;i<len1;i++){
            if (parents.get ( i ) == 0){
                root[j++] = i+1;
            }
        }
        for (i=0;i<root.length;i++){
            if (root[i] == 0){
                break;
            }
        }
        int rootLen = i;
        for (i=0;i<rootLen;i++){
//            ArrayList tmp = new ArrayList (  );
//            tmp.add ( costs.get ( root[i]-1 ) );
            count.add(costs.get ( root[i]-1 ));
        }

        System.out.println ( count );
        return 0;
    }
}
