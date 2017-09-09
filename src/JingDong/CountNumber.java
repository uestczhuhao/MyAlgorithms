package JingDong;

import java.util.*;

/**
 * 对于1<=a,b,c,d<=n，求满足a^b = c^d的个数
 * 如：n=2时，1^1 = 1^1  1^1 = 1^2  1^2 = 1^1  1^2 = 1^1  2^1 = 2^1  2^2 = 2^2
 * 输出为6
 */
public class CountNumber {
    /*
    作者：牛妹
    链接：https://www.nowcoder.com/discuss/38889
    来源：牛客网

    我们考虑去枚举n范围内的所有i,然后处理出i的幂那些数。
    考虑对于i ^ x, 我们需要计算满足 (i ^ x) ^ c = (i ^ y) ^ d的数量,
    其中i ^ x, i ^ y <= n. 这些我们可以通过预处理出来。

    然后对于(i ^ x) ^ c = (i ^ y) ^ d 其实意味着x c = y d, 意味着(x / y) = (d / c),
    其中x, y我们可以在预处理之后枚举出来,于是我们就可以借此计算出n范围内有多少不同这种c和d去满足等式。

    其实就等于 n / max(x / gcd(x, y), y / gcd(x, y)),然后都累加进答案。gcd()表示最大公约数。
    中间可能产生重复枚举,我们用一个set或者hash容器标记一下就好。

    以上枚举对于2~sqrt(n)。最后对于大于sqrt(n)的部分,每个的贡献都是n。
     */
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            long n = in.nextInt();
            //底数为1时，有n*n个，底数为2-n时，每个有n个，即2^1=2^1  2^2=2^2 ... 2^n=2^n
            long ans = (long) 1 * n * (n * 2 - 1) % MOD;
            Set<Integer> set = new HashSet<>();
            for (int i = 2; i * i <= n; i++) {
                if (set.contains(i)) continue;
                long tmp = i;
                int cnt = 0;

                while (tmp <= n) {
                    set.add((int) tmp);
                    tmp = tmp * i;
                    cnt++;
                }

                for (int k = 1; k <= cnt; k++) {
                    for (int j = k + 1; j <= cnt; j++) {
                        ans = (ans + n / (j / gcd(k, j)) * (long) 2) % MOD;
                    }
                }

            }
            System.out.println(ans);
        }

    }

    public final static long MOD = 1000000000 + 7;

    public static int max(int a, int b){
        return (a>b) ? a : b;
    }

    public static long gcd(long a,long b){
        return (a % b == 0) ? b : gcd(b,a%b);
    }
}
