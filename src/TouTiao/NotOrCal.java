package TouTiao;

import java.util.Scanner;

/**
 * Created by zhuhao on 17-8-22.
 */
public class NotOrCal {
    ///暴力枚举超时，用字典树对搜索进行优化。
//    public static void main(String[] args) {
//        Scanner sc = new Scanner ( System.in );
//        while (sc.hasNext ()){
//            int n = sc.nextInt ();
//            int m = sc.nextInt ();
//            int[] in = new int[n];
//            for (int i=0;i<n;i++)
//                in[i] = sc.nextInt ();
//
//            int count = 0;
//            for (int i=0;i<n;i++){
//                for (int j=i+1;j<n;j++){
//                    if ((in[i]^in[j])>m)
//                        count++;
//                }
//            }
//            System.out.println (count);
//        }
//    }

    /*

    直接计算肯定是超时的，所以这问题不能使用暴力破解，考虑到从高位到地位，依次进行位运算，
    如果两个数异或结果在某高位为1，而m的对应位为0，则肯定任何这两位异或结果为1的都会比m大。

    由此，考虑使用字典树（TrieTree）从高位到第位建立字典，再使用每个元素依次去字典中查对应高位异或为1，
    而m为0的数的个数，相加在除以2既是最终的结果；直接贴出代码如下，非原创，欢迎讨论；

    补充：queryTrieTree在搜索的过程中，是从高位往低位搜索，
    那么，如果有一个数与字典中的数异或结果的第k位大于m的第k位，那么该数与对应分支中所有的数异或结果都会大于m，
    否则，就要搜索在第k位异或相等的情况下，更低位的异或结果。

    queryTrieTree中四个分支的作用分别如下：

    1. aDigit=1， mDigit=1时，字典中第k位为0，异或结果为1，需要继续搜索更低位，第k位为1，
    异或结果为0，小于mDigit，不用理会；

    2. aDigit=0， mDigit=1时，字典中第k位为1，异或结果为1，需要继续搜索更低位，第k位为0，
    异或结果为0，小于mDigit，不用理会；

    3. aDigit=1， mDigit=0时，字典中第k位为0，异或结果为1，与对应分支所有数异或，
    结果都会大于m，第k位为1，异或结果为0，递归获得结果；

    4. aDigit=0， mDigit=0时，字典中第k位为1，异或结果为1，与对应分支所有数异或，
    结果都会大于m，第k位为0，异或结果为0，递归获得结果；
     */

    // 参考：https://www.nowcoder.com/questionTerminal/fc05f68c5f47438db54c6923ef23cf4a
    public static void main(String[] args) {

//        Scanner sc = new Scanner ( System.in );
//        while (sc.hasNext ()) {
//            int n = sc.nextInt ();
//            int m = sc.nextInt ();
//            int[] in = new int[n];
//            for (int i=0;i<n;i++){
//                in[i] = sc.nextInt ();
//                insert(root,)
//            }
//        }
    }


}

