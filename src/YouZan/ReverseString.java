package YouZan;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.nextLine();
            StringBuilder sb = new StringBuilder(str);
            sb = sb.reverse();
            char[] chs = sb.toString().toCharArray();
            int index = 0;
            StringBuilder res = new StringBuilder();
            while (index<chs.length){
                if ((chs[index] >= 'A' && chs[index] <= 'Z') || (chs[index] >= 'a' && chs[index] <= 'z')){
                    int start = index;
                    index++;
                    while (index < chs.length && ((chs[index] >= 'A' && chs[index] <= 'Z') || (chs[index] >= 'a' && chs[index] <= 'z'))){
                        index++;
                    }
                    StringBuilder tmp = new StringBuilder(sb.substring(start,index));
                    tmp= tmp.reverse();
                    res.append(tmp);
                } else {
                    res.append(chs[index]);
                    index++;
                }

            }
            System.out.println(res.toString());
        }
    }

}
