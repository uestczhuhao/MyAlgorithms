package Qunaer;

import java.util.*;

/**
 * Created by zhuhao on 17-8-28.
 * 请设计一个高效算法，再给定的字符串数组中，找到包含"Coder"的字符串(不区分大小写)，并将其作为一个新的数组返回。结果字符串的顺序按照"Coder"出现的次数递减排列，若两个串中"Coder"出现的次数相同，则保持他们在原数组中的位置关系。
 给定一个字符串数组A和它的大小n，请返回结果数组。保证原数组大小小于等于300,其中每个串的长度小于等于200。同时保证一定存在包含coder的字符串。
 测试样例：
 ["i am a coder","Coder Coder","Code"],3
 返回：["Coder Coder","i am a coder"]
 */
public class Coder {
    public static void main(String[] args) {
        String[] ss = {"i am a coder","Coder Coder","Code"};
        Coder r =new Coder ();
        System.out.println (Arrays.toString ( r.findCoder ( ss,3 ) ));
    }

    public String[] findCoder(String[] A, int n) {
        // write code here
        ArrayList<Statis> arr = new ArrayList<> (  );
        for (int i=0;i<n;i++){
            String words = A[i].toLowerCase ();
            if (words.contains ( "coder" )){
                int count = 0;
                int start = 0;
                //遍历a查找"coder"
                //对String类的灵活运用
                while (words.indexOf("coder", start) >= 0 && start < words.length()) {
                    count++;
                    start = words.indexOf("coder", start) + "coder".length();
                }
                if (count != 0){
                    arr.add ( new Statis (A[i],i,count) );
                }
            }
        }
        Collections.sort ( arr, new Comparator<Statis> () {
            @Override
            public int compare(Statis t0, Statis t1) {
                if (t0.coderCount != t1.coderCount){
                    return t1.coderCount - t0.coderCount;
                } else {
                    return t0.firstAppear - t1.firstAppear;
                }
            }
        } );
        int outSize = arr.size ();
        String[] result = new String[outSize];
        for (int i=0;i<outSize;i++){
            result[i] = arr.get ( i ).sentence;
        }
        return result;
    }

    static class Statis{
        String sentence;
        int firstAppear;
        int coderCount;
        public Statis(String str,int a,int b){
            this.sentence = str;
            this.firstAppear = a;
            this.coderCount = b;
        }
    }
}
