package WorkToOffer1;

/**
 * 假设农场中成熟的母牛每年会生1头小母牛，并且永远不会死，
 * 第一年农场有1只成熟的母牛，从第二年开始，母牛开始生小母牛。每只小母牛3年后成熟，
 * 又可以生小母牛，给N，求出N年后牛的数量
 *
 * 假设N=6，第一年成熟母牛记为a，第二年a生了b，总牛数为2，第三年a生了c，总共3头
 * 第四年a生了d，总牛数为4
 * 第五年b成熟了，a和b分别生了新的小母牛，总数为6；
 * 第六年a、b和c分别生了新的母牛，总数为9
 *
 * 分析：所有的牛都不会死，则N-1年的牛都会活到第N年，同时，N-3年的所有牛都会生小母牛
 * 因此c[n]=c[n-1]+c[n-3]，初始条件为c[1]=1,c[2]=2,c[3]=3
 *
 *
 */
public class Cattle {
    public static void main(String[] args) {
        System.out.println(countCattle(6));
        System.out.println(countCattle1(7));
    }

    public static int countCattle(int N){
        if (N < 0)
            return 0;
        int[] c = new int[N+1];
        c[1] = 1;
        c[2] = 2;
        c[3] = 3;
        for (int n=4;n<=N;n++)
            c[n] = c[n-1]+c[n-3];

        return c[N];
    }

    public static int countCattle1(int N){
        if (N<1)
            return 0;
        if (N==1 || N==2 || N==3)
            return N;
        int res = 3;
        int pre = 2;
        int prepre = 1;
        int tmp1 = 0;
        int tmp2 = 0;
        for (int i=4;i<=N;i++){
            tmp1 = res;
            tmp2 = pre;
            res += prepre;
            pre = tmp1;
            prepre = tmp2;
        }
        return res;
    }
}
