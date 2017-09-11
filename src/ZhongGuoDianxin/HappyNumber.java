package ZhongGuoDianxin;

import java.util.*;

/**
 * 设计一个算法，判断一个数字是否“快乐”。
 *
 * 快乐数可以被如下流程定义：一个正整数，计算出它各位数字的平方和，
 * 得到一个新的数字，再对这个新的数字重复这一过程，
 * 直到最后得到数字1或是其他某几个数字的无限循环。
 *
 * 在这些数字中，经过上述流程最终能得到数字1的数字，被称为“快乐数”。

 */
public class HappyNumber {
    public static ArrayList<Integer> result = new ArrayList<Integer>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            for (int i=1;i<=n;i++){
                if (isHappy(i)){
                    result.add(i);
                }
            }
            int sum=0;
            for (int i=0;i<result.size();i++){
                sum+=result.get(i);
            }
            System.out.println(sum);
        }
    }

    public static boolean isHappy(int n) {

        int temp = n;
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        linkedList.add(temp);
        while (true) {
            temp = getNext(temp);
            if (temp == 1) {
                return true;
            } else if (linkedList.contains(temp)) {
                return false;
            }
            linkedList.add(temp);
        }

    }

    /**
     * 获取下一个快乐的数
     * @param num
     * @return
     */
    private static int getNext(int num) {
        int result = 0;
        while (num > 0) {
            result += (num % 10) * (num % 10);
            num = num / 10;
        }
        return result;
    }
}


