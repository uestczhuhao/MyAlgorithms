package WangYiTest.Spring2017;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by zhuhao on 17-8-17.
 * 小易参与了一个记单词的小游戏。游戏开始系统提供了m个不同的单词，小易记忆一段时间之后需要在纸上写出他记住的单词。小易一共写出了n个他能记住的单词，如果小易写出的单词是在系统提供的，将获得这个单词长度的平方的分数。注意小易写出的单词可能重复，但是对于每个正确的单词只能计分一次。
 输入描述:
 输入数据包括三行：

 第一行为两个整数n(1 ≤ n ≤ 50)和m(1 ≤ m ≤ 50)。以空格分隔

 第二行为n个字符串，表示小易能记住的单词，以空格分隔，每个单词的长度小于等于50。

 第三行为m个字符串，系统提供的单词，以空格分隔，每个单词的长度小于等于50。


 输出描述:
 输出一个整数表示小易能获得的分数

 输入例子1:
 3 4
 apple orange strawberry
 strawberry orange grapefruit watermelon

 输出例子1:
 136
 */
public class RememberWord {
    public static void main(String[] args) {
        Scanner sc= new Scanner ( System.in );
        while (sc.hasNext ()){
            int n = sc.nextInt ();
            int m = sc.nextInt ();
            HashMap<String,Integer> remb = new HashMap<> (  );
            HashMap<String,Integer> sys = new HashMap<> (  );
            for (int i=0;i<n;i++)
                remb.put ( sc.next (),1 );
            for (int i=0;i<m;i++){
                String tmp = sc.next ();
                int len = (int)Math.pow ( tmp.length (),2 );
                sys.put ( tmp,len );
            }

            int sum = 0;
            for (Map.Entry<String,Integer> word:remb.entrySet ()){
                String str = word.getKey ();
                if (sys.get ( str )!=null){
                    sum += sys.get ( str );
                }
            }
            System.out.println (sum);
        }
    }

}
