package HuaWei;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by zhuhao on 17-8-15.
 * 扑克牌游戏大家应该都比较熟悉了，一副牌由54张组成，含3~A，2各4张，小王1张，大王1张。牌面从小到大用如下字符和字符串表示（其中，小写joker表示小王，大写JOKER表示大王）:)
 3 4 5 6 7 8 9 10 J Q K A 2 joker JOKER
 输入两手牌，两手牌之间用“-”连接，每手牌的每张牌以空格分隔，“-”两边没有空格，如：4 4 4 4-joker JOKER
 请比较两手牌大小，输出较大的牌，如果不存在比较关系则输出ERROR

 基本规则：
 （1）输入每手牌可能是个子，对子，顺子（连续5张），三个，炸弹（四个）和对王中的一种，不存在其他情况，由输入保证两手牌都是合法的，顺子已经从小到大排列；
 （2）除了炸弹和对王可以和所有牌比较之外，其他类型的牌只能跟相同类型的存在比较关系（如，对子跟对子比较，三个跟三个比较），不考虑拆牌情况（如：将对子拆分成个子）
 （3）大小规则跟大家平时了解的常见规则相同，个子，对子，三个比较牌面大小；顺子比较最小牌大小；炸弹大于前面所有的牌，炸弹之间比较牌面大小；对王是最大的牌；
 （4）输入的两手牌不会出现相等的情况。

 答案提示：
 （1）除了炸弹和对王之外，其他必须同类型比较。
 （2）输入已经保证合法性，不用检查输入是否是合法的牌。
 （3）输入的顺子已经经过从小到大排序，因此不用再排序了.

 输入描述:

 输入两手牌，两手牌之间用“-”连接，每手牌的每张牌以空格分隔，“-”两边没有空格，如4 4 4 4-joker JOKER。


 输出描述:

 输出两手牌中较大的那手，不含连接符，扑克牌顺序不变，仍以空格隔开；如果不存在比较关系则输出ERROR。
 示例1
 输入

 4 4 4 4-joker JOKER
 输出

 joker JOKER
 */
public class PlayCard {
    public static void main(String[] args) {
        Scanner sc = new Scanner ( System.in );
        while (sc.hasNext ()){
            String[] strs = sc.nextLine ().split ( "-" );
            int type1 = deterType ( strs[0] );
            int type2 = deterType ( strs[1] );
            if (type1 == type2){
                int res = compare ( strs[0],strs[1],type1 );
                if (res > 0)
                    System.out.println (strs[0]);
                else System.out.println (strs[1]);
            } else if (type1 == 6 || type2 == 6){
                if (type1 == 6)
                    System.out.println (strs[0]);
                else System.out.println (strs[1]);
            } else if (type1 == 4 || type2 == 4){
                if (type1 == 4)
                    System.out.println (strs[0]);
                else System.out.println (strs[1]);
            } else {
                System.out.println ("ERROR");
            }
//            System.out.println (type1);
//            System.out.println (type2);
        }

//        System.out.println (compare ( "10","3",1 ));
    }

    private static int deterType(String str){
        ///type=1代表个，2代表对子，3代表3个，4代表炸弹，5代表顺子，6代表王炸
        int type;
        String[] strs = str.split ( " " );
        if (strs.length ==1){
            type = 1;
        } else if (strs.length == 2 && strs[0].equals ( strs[1] )){
            type = 2;
        } else if (strs.length == 3){
            type = 3;
        } else if (strs.length == 4){
            type =4;
        } else if (strs.length == 5){
            type =5;

        } else
            type = 6;

        return type;
    }

    private static int compare(String str1,String str2,int type){
        int res=0;
        ///type=1代表个，2代表对子，3代表3个，4代表炸弹，5代表顺子，6代表王炸
        if (type == 1){
            if (dertIndex ( str1 ) < dertIndex ( str1 ))
                res = -1;
            else res = 1;
        } else {
            String[] tmp1 = str1.split ( " " );
            String[] tmp2 = str2.split ( " " );
            String str1Tmp = tmp1[0];
            String str2Tmp = tmp2[0];
            if (dertIndex ( str1Tmp ) < dertIndex ( str2Tmp ))
                res = -1;
            else res = 1;
        }

        return res;
    }

    private static int dertIndex(String str) {
        return "345678910JQKA2jokerJOKER".indexOf ( str );
    }
}
