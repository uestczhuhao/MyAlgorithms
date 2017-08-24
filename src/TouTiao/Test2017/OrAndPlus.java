package TouTiao.Test2017;

import java.util.Scanner;

/**
 * Created by zhuhao on 17-8-24.
 */
public class OrAndPlus {
    /**
     * 链接：https://www.nowcoder.com/questionTerminal/729f5e6e2acc4f3cb14a2262888f86fb
     来源：牛客网

     -----解法说明------
     x+y=x|y

     这里可以推出一个结论，x&y=0。也就是说，在二进制上看，x取1的地方，y必定不能取1。从最低位考虑，若x与y在某一位上同时取1，则x+y在该位上为0，x|y在该位上为1，前面说这是最低一位x
     y同时取1，也就是说没有更低位加法的进位，所以这里两个结果不相等，出现了矛盾。
     例子：
     x = 001010
     y = 110110
     x + y =  1000000
     x | y = 111110
     偏差产生的原因是倒数第二位，x+y=0 x|y=1 且倒数第一位加法没有进位
     结论：x在二进制取1的位上，y不能做出改变，只能取0


     ----方法----


     有了上述结论，可以进一步推出只要在x取0的地方，y可以做出改变


     例如


     x = 10010010011


     y = 00000000(0)00   k = 0


     y = 00000000(1)00   k = 1


     y = 0000000(1)(0)00 k = 2


     y = 0000000(1)(1)00 k = 3


     y = 00000(1)0(0)(0)00 k = 4


     y = 00000(1)0(0)(1)00 k = 5


     ...


     注意观察括号里的数，为x取0的比特位，而如果把括号里的数连起来看，正好等于k。


     得出结论，把k表示成二进制数，填入x取0的比特位，x取1的比特位保持为0，得到y。


     ---代码说明---

     思路有了，接着就是代码，显然用位操作是最合适的方式。
     循环的思想是每次取得k的最低一位，填入到低位开始，x中比特位为0的位置上。
     所以用while来判断k是否大于0，若是，说明k还未完全填完
     循环体内，需要找到x当前可以填的位置，我们用bitNum来从右往左扫描x的每一位

     (x & bitNum) == 0 说明x该位为0,可以把k的当前最后一位填入，用 (k & 1) 取出最后一位，用 ans += (bitNum * (k & 1)) 把k的最后一位填入到当前bitNum指向的位置。
     填完后，k右移一位，去掉已经被填过的最后一位，bitNum也向左走一位，避免重复填入x的某个位置。
     若x的某个位置为1，则跳过该位置，向左走一位并观察是否可以填入。
     两次bitNum向左走一位，合并成一句 bitNum <<= 1;
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner ( System.in );
        while (sc.hasNext ()){
            long x,k;
            x = sc.nextInt ();
            k = sc.nextInt ();
            long bitNum = 1;
            long ans = 0;
            //目标是把k的各位依次填在x中是0的位上
            //bitNum用来移动到x中零的位置，然后把k的最低位放在x的零位上, k左移，将下一位变成最低位,bitNum一直左移，知道x中的下一个为0的位上。
            while (k>0){
                if ((x & bitNum) == 0){
                    //k&1是将k的最低位取出来, bitNum*(k&1)的结果就是得到bitNum位和当前k的最低位一样的一个数,而其它位都是0
                    ans += (bitNum*(k & 1));
                    //而ans原来的bitNum为肯定为0，ans+(bitNum*(k&1)) 就将k的最低位放在x的这个零上了。
                    k >>= 1;
                }
                bitNum<<=1;
            }
            System.out.println (ans);
        }
    }
}
