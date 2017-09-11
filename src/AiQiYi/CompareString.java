package AiQiYi;

import java.util.Scanner;

public class CompareString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            long x1 = sc.nextInt();
            int k1 = sc.nextInt();
            long x2 = sc.nextInt();
            int k2 = sc.nextInt();

            int len1 = countLen(x1);
            int len2 = countLen(x2);
            if (len1 * k1 > len2*k2){
                System.out.println("Greater");
            } else if (len1*k1 < len2*k2){
                System.out.println("Less");
            } else {
                String s1 = String.valueOf(x1);
                String s2 = String.valueOf(x2);
                StringBuilder ss1 = new StringBuilder();
                StringBuilder ss2 = new StringBuilder();
                for (int i=0;i<k1;i++)
                    ss1.append(s1);
                for (int i=0;i<k2;i++)
                    ss2.append(s2);
                int res = ss1.toString().compareTo(ss2.toString());
                if (res < 0 ){
                    System.out.println("Less");
                } else if(res>0){
                    System.out.println("Greater");
                } else {
                    System.out.println("Equal");
                }

            }
        }
    }

    public static int countLen (long n){
        int res = 0;
        while (n!=0){
            res++;
            n /=10;
        }
        return res;
    }
}
