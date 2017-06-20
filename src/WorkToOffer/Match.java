package WorkToOffer;

/**
 * Created by zhuhao on 17-6-19.
 */
public class Match {
    public boolean match(char[] str, char[] pattern)
    {
        if (str == null || pattern ==null)
            return false;

        int strIndex=0,patternIndex = 0;
        return matchCore ( str,strIndex,pattern,patternIndex );
    }

    /**
     当模式中的第二个字符不是“*”时：
     1、如果字符串第一个字符和模式中的第一个字符相匹配，那么字符串和模式都后移一个字符，然后匹配剩余的。
     2、如果字符串第一个字符和模式中的第一个字符相不匹配，直接返回false。

     而当模式中的第二个字符是“*”时：
     如果字符串第一个字符跟模式第一个字符不匹配，则模式后移2个字符，继续匹配。如果字符串第一个字符跟模式第一个字符匹配，可以有3种匹配方式：
     1、模式后移2字符，相当于x*被忽略；
     2、字符串后移1字符，模式后移2字符；
     3、字符串后移1字符，模式不变，即继续匹配字符下一位，因为*可以匹配多位；
     */
    public boolean matchCore(char[] str,int strIndex, char[] pattern,int patternIndex){
        //有效性检验：str到尾，pattern到尾，匹配成功
        if (strIndex == str.length && patternIndex == pattern.length) {
            return true;
        }

        //pattern先到尾，匹配失败
        if (strIndex != str.length && patternIndex == pattern.length) {
            return false;
        }

        //模式第2个是*，且字符串第1个跟模式第1个匹配,分3种匹配模式；如不匹配，模式后移2位
        if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
            if ((strIndex != str.length && pattern[patternIndex] == str[strIndex]) || (pattern[patternIndex] == '.' && strIndex != str.length)) {
                return matchCore(str, strIndex, pattern, patternIndex + 2)//模式后移2，视为x*匹配0个字符
                        || matchCore(str, strIndex + 1, pattern, patternIndex + 2)//视为模式匹配1个字符
                        || matchCore(str, strIndex + 1, pattern, patternIndex);//*匹配1个，再匹配str中的下一个
            } else {
                    return matchCore(str, strIndex, pattern, patternIndex + 2);
                }
        }

        //模式第2个不是*，且字符串第1个跟模式第1个匹配，则都后移1位，否则直接返回false

        if ((strIndex != str.length && pattern[patternIndex] == str[strIndex]) || (pattern[patternIndex] == '.' && strIndex != str.length)) {
            return matchCore(str, strIndex + 1, pattern, patternIndex + 1);
        }
    return false;
    }

    public boolean matchCore1(char[] str,int strIndex,char[] pattern,int patternIndex){
        //str和pattern都到最后，匹配成功
        if (strIndex == str.length && patternIndex==pattern.length)
            return true;

        //当pattern到末尾，str没有到末尾，则匹配失败
        if (strIndex != str.length && patternIndex == pattern.length)
            return false;

        //当pattern的第二个字符为'*'，分两种情况:
        //如果第一个字符不匹配，则pattern向后移动两个字符，str不动，继续匹配
        //如果第一个字符匹配，则分三种情况讨论，满足任一条件即可
        if (patternIndex+1 < pattern.length && pattern[patternIndex+1] =='*'){
            if (strIndex < str.length && (str[strIndex] == pattern[patternIndex] || pattern[patternIndex] == '.')) {
                return matchCore1 ( str,strIndex,pattern,patternIndex+2 )
                        || matchCore1 ( str,strIndex+1,pattern,patternIndex+2 )
                        || matchCore1 ( str,strIndex+1,pattern,patternIndex );
            } else {
                return matchCore1 ( str,strIndex,pattern,patternIndex+2 );
            }
        }

        //函数运行到这里，证明pattern的第二个字符不是"*"
        //此时判断二者的第一个字符是否匹配，若匹配则str和pattern都向后移动，继续匹配
        //否则直接返回false
        //注：此处不用考虑pattern会不会超出范围，因为多pattern到末尾而str未到末尾已经返回false了，不会运行到此处
        if (strIndex < str.length && (str[strIndex] == pattern[patternIndex] || pattern[patternIndex] == '.'))
            return matchCore1 ( str,strIndex+1,pattern,patternIndex+1 );

        return false;
    }
}

