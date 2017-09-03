package WorkToOffer1;

/**
 * Created by zhuhao on 17-9-3.
 * 打印从1到最大的n位数
 */
public class Print1ToN {
    public static void main(String[] args) {
        int n = 3;
        char[] chs = new char[n];
        print ( n,chs,0 );
//        System.out.println ();
    }

    private static void print(int n,char[] chs,int index){
        if (index == n){
            int i;
            for (i=0;i<index;i++){
                if (chs[i] != '0')
                    break;
            }
            for (;i < index;i++)
                System.out.print (chs[i]);
            System.out.print (" ");
            return;
        }

        for (int i=0;i<=9;i++){
            chs[index] = (char) ('0' + i);
            print ( n,chs,index+1 );
        }
    }
}
