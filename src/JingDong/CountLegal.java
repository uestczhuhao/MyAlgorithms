package JingDong;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class CountLegal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.nextLine();
            if (str.equals("")){
                System.out.println(0);
                return;
            }
            char[] chs = str.toCharArray();
            LinkedList<Integer> left = new LinkedList<>();
            LinkedList<Integer> right = new LinkedList<>();
            for (int i=0;i<chs.length;i++){
                if (chs[i] == '(')
                    left.add(i);
                else
                    right.add(i);
            }

            int res = 1;
            while (!left.isEmpty()){
                int index1 = 0;
                int rig = right.pollFirst();
                while (index1 < left.size()){
                    if (rig < left.get(index1))
                        break;
                    index1++;
                }
                left.pollFirst();
                res *= index1;
            }
            System.out.println(res);
        }
    }
}
