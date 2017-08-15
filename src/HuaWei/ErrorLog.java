package HuaWei;

import java.util.*;

/**
 * Created by zhuhao on 17-8-15.
 * 开发一个简单错误记录功能小模块，能够记录出错的代码所在的文件名称和行号。
 处理:
 1.记录最多8条错误记录，对相同的错误记录(即文件名称和行号完全匹配)只记录一条，错误计数增加；(文件所在的目录不同，文件名和行号相同也要合并)
 2.超过16个字符的文件名称，只记录文件的最后有效16个字符；(如果文件名不同，而只是文件名的后16个字符和行号相同，也不要合并)
 3.输入的文件可能带路径，记录文件名称不能带路径

 输入描述:
 一行或多行字符串。每行包括带路径文件名称，行号，以空格隔开。

 文件路径为windows格式

 如：E:\V1R2\product\fpgadrive.c 1325


 输出描述:
 将所有的记录统计并将结果输出，格式：文件名代码行数数目，一个空格隔开，如: fpgadrive.c 1325 1

 结果根据数目从多到少排序，数目相同的情况下，按照输入第一次出现顺序排序。

 如果超过8条记录，则只输出前8条记录.

 如果文件名的长度超过16个字符，则只输出后16个字符

 输入例子1:
 E:\V1R2\product\fpgadrive.c 1325

 输出例子1:
 fpgadrive.c 1325 1
 */
public class ErrorLog {

    public static void main(String[] args) {
        Scanner sc = new Scanner ( System.in );
        HashMap<String,Integer> strs = new HashMap<> (  );
        while (sc.hasNext ()){
            String[] strTmp = sc.nextLine ().split ( "\\\\" );
            String str = strTmp[strTmp.length-1];
            if (strs.get ( str ) == null)
                strs.put ( str,1 );
            else
                strs.put ( str,strs.get(str)+1 );
        }

        List<Map.Entry<String,Integer>> list = new LinkedList<Map.Entry<String, Integer>> ( strs.entrySet () );
        Collections.sort ( list, new Comparator<Map.Entry<String, Integer>> () {
            @Override
            public int compare(Map.Entry<String, Integer> map1, Map.Entry<String, Integer> map2) {
                if (map2.getValue ()!=map1.getValue ())
                    return map2.getValue ()-map1.getValue ();
                else
                    return map1.getKey ().compareTo ( map2.getKey () );
            }
        } );

        int count=0;
//        System.out.println (list+" "+list.size ());
//        System.out.println (list);
        if (list.size ()>=8){
            for (int i=0;i<8;i++){
                Map.Entry<String,Integer> tmp = list.get ( i );
                System.out.println (tmp.getKey ()+" "+tmp.getValue ());
            }
        } else {
            for (int i=0;i<list.size ();i++){
                Map.Entry<String,Integer> tmp = list.get ( i );
                System.out.println (tmp.getKey ()+" "+tmp.getValue ());
            }
        }

//        for (Map.Entry<String,Integer> tmp:list){
////            String[] strT = tmp.getKey ().split ( " " );
////            if (strT[0].length ()>16)
////                System.out.println (strT[0].substring ( strT[0].length ()-16,strT[0].length () )+" "+strT[1]+" "+tmp.getValue ());
////            else
//                System.out.println (tmp.getKey ()+" "+tmp.getValue ());
////            count++;
////            if (count>=8)
////                break;
//        }
//        System.out.println ("Input Finish!");
    }
}
