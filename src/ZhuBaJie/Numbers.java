package ZhuBaJie;

import java.util.Scanner;

/**
 * 求f(n) = 2f(n-1)+f(n-2)的第k项模32767的值
 */
public class Numbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] arr = new int[n];

            for (int j =0;j<n;j++) {
                arr[j] = sc.nextInt();
            }
            for (int j=0;j<n;j++){
                int k = arr[j];
                int[] init = {1,2};
                if (k<=2){
                    System.out.println(init[k-1]);
                    continue;
                }
                long pre = init[1];
                long prepre = init[0];
                long res = 0;
                for (int i=3;i<=k;i++){
                    res = 2*pre+ prepre;
//                    if (res >= 1000000)
//                        res %= 1000000;
                    prepre = pre;
                    pre = res;
                }

                System.out.println( res%32767 );
            }
            }


    }
}
