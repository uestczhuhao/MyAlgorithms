package ZhongGuoDianxin;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class SplitAndCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.nextLine();
            LinkedList<String> list = new LinkedList<>();
            int i=0;
            char[] chs = str.toCharArray();
            while (i<str.length()){
                int index = i;
                while (chs[i] != ',' && chs[i] != '.' && chs[i] != ' '){
                    i++;
                }
                list.add(str.substring(index,i));
                i++;
            }
            while (list.size()>1){
                String tmp = list.pollFirst();
                if (tmp.length()!=0)
                    System.out.print(tmp.length()+" ");
            }
            System.out.println(list.poll().length());
        }
    }
}
