package Meituan.Test0914;

import java.util.Scanner;

public class Divide7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            sc.nextLine();
            String[] arrs = sc.nextLine().split(" ");;

            long res = n*(n-1);
            for (int i=0;i<arrs.length-1;i++){
                for (int j=i+1;j<arrs.length;j++){
                    long ttmp1 = Long.parseLong(arrs[i] + arrs[j]);
                    long ttmp2 = Long.parseLong(arrs[j] + arrs[i]);
                    if (ttmp1 % 7 !=0){
                        res--;
                    }
                    if (ttmp2 % 7 !=0){
                        res--;
                    }
                }
            }
            System.out.println(res);
        }
    }
}
