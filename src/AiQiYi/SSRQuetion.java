package AiQiYi;

import java.util.Scanner;

/**
 * 平方根的和的平方SSR (Squared Sum of square Roots)，是一个函数：

 SSR(A, B) = (sqrt(A)+sqrt(B))^2。

 给出整数N，M。求有序对(A,B)的数量，满足1 <= A <= N, 1 <= B <= M 并且SSR(A, B) 是整数。

 Input
 第一行为数据组数。

 接下来每行是一组数据，有两个数N，M。都在1和10^5之间。

 Output
 每组数据一行，你的答案。数据保证答案用带符号32位整数可以正确储存。

 Sample Input
 1
 2 2
 Sample Output
 2
 */
public class SSRQuetion {
    public static int maxn = 100001;
    public static int num,n,m;
    public static int[] dp = new int[maxn];
    public static int[] p = new int[maxn];
    public static boolean s[] = new boolean[maxn];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            init();
            prime();
            int sum = dp[m];
            for (int i = 2; i <= n; i++) {
                if (!s[i]) {
                    if (i > m) continue;//////
                    sum += dp[m / i];
                    continue;
                }
                int d = i, r = 1;
                for (int j = 0; p[j] * p[j] <= d; j++) {
                    int f = 0;
                    while (d % p[j] == 0) {
                        f++;
                        d /= p[j];
                    }
                    if (f % 2 == 1) r *= p[j];
                }
                if (d > 1) r *= d;
                if (r > m) continue;
                sum += dp[m / r];
            }
            System.out.println(sum);
        }
    }

    public static void prime(){
        for(int i=0;i<maxn;i++) s[i]=false;
        for(int i=2;i*i<maxn;i++){
            if(!s[i]){
                for(int j=2;j*i<maxn;j++ )
                    s[i*j]=true;
            }
        }
        num=0;
        for(int i=2;i<maxn;i++)
            if(!s[i]) p[num++]=i;
    }

    public static void init(){
        dp[1]=1; dp[0]=0;
        for(int i=2;i<maxn;i++){// 对平方和数进行打表
            dp[i]=0;
            double m=(double)i;
            double k= (int)(Math.pow(m,1.0/2) + 0.5);
            if(Math.pow(k,2.0)==m) dp[i]=1;
            dp[i]+=dp[i-1];
        }
    }
}
