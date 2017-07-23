/**
 * Created by zhuhao on 17-4-18.
 */


import java.util.Arrays;

/**
 * 定义接口，下面的Class继承并实现
 */
interface StringMatch{
    /**
     * 从source字符串中找到substr字符串
     * @param source 原字符串
     * @param substr 子字符串
     * @return index 返回子串第一次出现的位置，若不存在返回-1
     */
    int indexOf(String source,String substr);
}
public class KMPMatch implements StringMatch{

    @Override
    public int indexOf(String source,String substr){
        int i=0,j=0;
        char[] src = source.toCharArray ();
        char[] sub = substr.toCharArray ();
        int srcLength = src.length;
        int subLength = sub.length;
        int[] next = getNextVal ( substr );
        while(i<srcLength && j<subLength){
            //当前字符匹配时或j==-1时都让i和j加1
            //为什么j == -1时要i和j都要加1？
            //当j==-1时，表明上次对比的i值对应主串的字符和j对应的字符不等，因此j才会回退到-1
            //再次比较时，子串从头开始匹配，而当前字串的字符和首项相等，
            // 因此与i值对应主串的字符不相等，因此i++，而j++显然是把子串指针指到子串首

            if (j ==-1 || src[i] == sub[j]){
                i++;
                j++;
            } else {
                //当前字符不匹配，且j!=-1，则i不变，j=next[j]
                //其效果即为让substr右移j-next[j]个单位
                j=next[j];
            }
        }
            if(j == subLength)
                return i-j;
        return -1;

    }

    /**
     * 用递归的方法求next数组
     * @param substr 传入子串
     * @return 返回求得的next数组
     */
    public int[] getNext(String substr){
        /*
        * 若已知next[j] = k,如何求得next[j+1]？
        * 1.如果p[j] = p[k], 则next[j+1] = next[k] + 1;
        * 2.如果p[j] != p[k], 则令k=next[k],如果此时p[j]==p[k],则next[j+1]=k+1,
        *  如果不相等,则继续递归前缀索引,令 k=next[k],继续判断,
        *  直至k=-1(即k=next[0])或者p[j]=p[k]为止
         */
        int length = substr.length ();
        char[] p =substr.toCharArray ();
        int[] next= new int[length];
        int k = -1,j = 0;
        next[0]=-1; //next数组的首项为-1
        while (j<length-1){

            if (k==-1 || p[j]==p[k]){
                k++;j++;
                next[j]=k;
            } else {
                k=next[k];
            }

        }
        return next;

    }

    /**
     * 对getNext方法进行改进
     * @param substr 传入子串
     * @return 返回求得的next数组
     */
    public int[] getNextVal(String substr) {
        int length = substr.length ();
        char[] p =substr.toCharArray ();
        int[] next= new int[length];
        int k = -1,j = 0;
        next[0]=-1; //next数组的首项为-1

        while (j<length-1){

            if (k==-1 || p[j]==p[k]){
                k++;j++;
                //修改next数组求法
                if(p[j]!=p[k]){
                    next[j]=k;
                } else {
                    //不能出现p[j] = p[next[j]],所以如果出现这种情况则继续递归,
                    // 如 k = next[k],k = next[[next[k]]
                    next[j]=next[k];
                }
            } else {
                k=next[k];
            }
            System.out.println ("k= "+k);
            System.out.println ("j= "+j);
            System.out.println (Arrays.toString ( next ));
        }
        return next;
        }

    public static void print(){
        System.out.println ("This is KMPMatch!");
    }
}


/**
 * 朴素的模式匹配算法
 * 最坏的情况下时间复杂度为O((n-m+1)*m)
 * 例：source="0000...1" 长度为n
 * sunstr="000...1" 长度为m
 * 则在前面n-m+1次的比对中，每次都需要比对m次，总共需要比对(n-m+1)*m次
 */
class VoilentMatch implements StringMatch {

    @Override
    public int indexOf(String source, String substr) {
        int length = source.length ();
        int sub_length = substr.length ();
        int i = 0, j = 0;
        char[] src = source.toCharArray ();
        char[] sub = substr.toCharArray ();
        while (i < length && j < sub_length) {
            if (src[i] == sub[j]) {
                //当前字符匹配则继续向后匹配
                i++;
                j++;

            } else {
                //当前字符不匹配，则i回退到开始处+1
                //j回退到0
                i = i - j + 1;
                j = 0;
            }

        }
        if (j == sub_length) {
            return i - j;
        } else {
            return -1;
        }

    }
}
