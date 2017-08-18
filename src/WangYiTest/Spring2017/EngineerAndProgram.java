package WangYiTest.Spring2017;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by zhuhao on 17-8-18.
 * 现在有n位工程师和6项工作(编号为0至5)，现在给出每个人能够胜任的工作序号表(用一个字符串表示，比如：045，表示某位工程师能够胜任0号，4号，5号工作)。现在需要进行工作安排，每位工程师只能被安排到自己能够胜任的工作当中去，两位工程师不能安排到同一项工作当中去。如果两种工作安排中有一个人被安排在的工作序号不一样就被视为不同的工作安排，现在需要计算出有多少种不同工作安排计划。
 输入描述:

 输入数据有n+1行：
 第一行为工程师人数n(1 ≤ n ≤ 6)
 接下来的n行，每行一个字符串表示第i(1 ≤ i ≤ n)个人能够胜任的工作(字符串不一定等长的)


 输出描述:

 输出一个整数，表示有多少种不同的工作安排方案
 示例1
 输入

 6
 012345
 012345
 012345
 012345
 012345
 012345
 输出

 720
 */
public class EngineerAndProgram {
    public static int cases = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner ( System.in );
        while (sc.hasNext ()){
            int n = sc.nextInt ();
            String[] works = new String[n];
            for (int i=0;i<n;i++)
                works[i] = sc.next ();

            countCore ( works,0,new HashSet<Integer> (  ) );
            System.out.println (cases);
        }
    }
    //回溯法：找到一种可行性方案后case+1
    //用set而不是其他，证明了每个工作的互异性，即每个人做不同的工作
    public static void countCore(String[] works, int index, HashSet<Integer> set){

        if (index>=works.length){
            cases++;
            return;
        }

        String able = works[index];
        for (int i=0;i<able.length ();i++){
            int work = able.charAt ( i )-'0';
            if (!set.contains ( work )){
                set.add ( work );
                countCore ( works,index+1,set );
                set.remove ( work );
            }
        }
    }
}
