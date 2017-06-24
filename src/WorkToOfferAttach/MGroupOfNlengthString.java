package WorkToOfferAttach;

import java.util.TreeSet;

/**
 * Created by zhuhao on 17-6-23.
 */
public class MGroupOfNlengthString {

    /**
     * 不是求字符串的排列，而是组合，例如abc的组合为a,b,c,ab,ac,bc,abc
     * 其中ab和ba是不同的排列，但属于同一种组合
     */
    private TreeSet<String> group = new TreeSet<> (  );
//    public char[] comb = new char[];
    StringBuffer combing = new StringBuffer (  );
    public TreeSet<String> mGroupOfNlengthString(String str){
        if (str==null || str.length ()==0)
            return group;

        char[] chs = str.toCharArray ();
        for (int i=1;i<=str.length ();i++)
            GroupCore ( chs,0,i );
//            GroupCore ( chs,0,3 );

        System.out.println (group);
        return group;
    }

    public void GroupCore(char[] chs,int begin,int m){
        if (combing.length () == m){
            group.add ( combing.toString () );
//            combing.delete ( 0,combing.length ()-1 );
            return;
        }
        if (begin < chs.length){
            combing.append ( chs[begin] );
            GroupCore ( chs,begin+1,m );
            if (combing.length ()-1 >=0)
                combing.deleteCharAt ( combing.length ()-1 );
            GroupCore ( chs,begin+1,m );

        }
    }
}
