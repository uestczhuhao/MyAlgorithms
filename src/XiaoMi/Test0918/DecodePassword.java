package XiaoMi.Test0918;

import java.util.*;

/**
 * Created by zhuhao on 17-9-18.
 */
public class DecodePassword {
    public static Character[] init = {'0','a','b','c','d','e','f','g',
                                        'h','i','j','k','l','m','n',
                                        'o','p','q','r','s','t',
                                        'u','v','w','x','y','z'};
    public static void main(String[] args) {
        Scanner sc = new Scanner ( System.in );
        while (sc.hasNext ()){
            String input = sc.nextLine ();
            char[] chs = input.toCharArray ();
            TreeSet<String> set = new TreeSet<> ( new Comparator<String> () {
                @Override
                public int compare(String s, String t1) {
                    return s.compareTo ( t1 );
                }
            } );
            String res = "";
            for (int i=0;i<chs.length;i++){
                int tmp = chs[i]-'0';
                res += init[tmp];
            }
            set.add ( res );
            for (int i=1;i<chs.length;i++){
                res = "";
                int index = i;
                boolean isLegal = true;
                int tmpt = (chs[index-1]-'0')*10+ chs[index]-'0';
                if (tmpt > 26)
                    continue;
                for (int j=0;j<chs.length && isLegal;j++){
                    if (j != index-1 && j!=index){
                        int tmp = chs[j]-'0';
                        res += init[tmp];
                    } else if (j == index-1){
                        continue;
                    } else {
                        res += init[tmpt];
                    }
                }
                set.add ( res );

            }
            String last = set.pollLast ();
            for (String t:set){
                System.out.print (t+" ");
            }
            System.out.println (last);
        }
    }
}
