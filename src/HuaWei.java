import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by zhuhao on 17-8-15.
 */
public class HuaWei {
    public static void main(String[] args) {
        Scanner sc = new Scanner ( System.in );
        while (sc.hasNext ()){
            int n = sc.nextInt ();
            if (n==0)
                return;
            int count = 0,tmp = n;
            while (tmp/3 != 0){
                int rem = tmp % 3;
                tmp = tmp/3;
                count += tmp;
                tmp += rem;
                if (tmp == 2)
                    count++;
            }
            System.out.println (count);
        }
    }
}
