package LeXin;

import java.util.ArrayList;
import java.util.*;

public class CuXiao {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        LinkedList<Double> que = new LinkedList<>();
        while (sc.hasNext()){
            que.add(sc.nextDouble());
        }

        Collections.sort(que, new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                if (o1-o2 <0.0)
                    return -1;
                else if (o1-o2 > 0.0)
                    return 1;
                else
                    return 1;
            }
        });
        double sum = 0;
        while (!que.isEmpty()){
            sum+= que.pollLast();
            que.pollLast();
        }

        System.out.println(String.format("%.2f",sum));
    }
}
