package CVTE;

/**
 * Created by zhuhao on 17-9-2.
 */
public class Split {
    public static void main(String[] args) {
        System.out.println (splitNumber ( 654321,50 ));
        System.out.println (countLen ( 654321 ));
    }
    public static Integer splitNumber(Integer n,Integer m){
        int len1 = countLen ( n );
        int len2 = countLen ( m );
        if (len2 > len1)
            return n;

        char[] nChs = String.valueOf ( n ).toCharArray ();

        int max = Integer.MIN_VALUE;
        for (int i=1;i<=len2;i++){
            int tmp = maxLessThanM ( nChs,i,m );
            if (tmp > max)
                max = tmp;
        }
        return max;
    }

    //返回切割chs的最大长度不超过len的值（转化为int类型），且其和只不超过M
    public static int maxLessThanM(char[] chs,int len,int M){
        int total = chs.length;
        return 0;
    }
    public static int countLen(Integer m){
        int count = 0;
        while (m!=0){
            count++;
            m = m/10;
        }


        return count;
    }
}
