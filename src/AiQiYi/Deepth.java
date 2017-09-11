package AiQiYi;

import java.util.Scanner;
import java.util.Stack;

public class Deepth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str= sc.nextLine();
            System.out.println(longestValueParenthese(str));
        }
    }

    public static int longestValueParenthese(String s){
        Stack<Character> sta = new Stack<>();
        int max = 0;
        char[] chs = s.toCharArray();
        for (int i=0;i<chs.length;i++){
            if (chs[i] == '('){
                sta.push(chs[i]);
                if (sta.size() > max)
                    max = sta.size();
            }
            if (chs[i] == ')'){
                sta.pop();
            }
        }
        return max;
    }
}
