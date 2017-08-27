package XiaoMi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by zhuhao on 17-8-27.
 * 链接：https://www.nowcoder.com/questionTerminal/84addf13322a42ad80da5fc89e784ea1
 来源：牛客网

 You class are planning for a spring outing. N people are voting for a destination out of K candidate places.
 The voting progress is below:
 First the class vote for the first candidate place. If more than half of the class agreed on the place, the place is selected. The voting ends.
 Otherwise they vote for the second candidate place. If more than half of the class agreed on the place, the place is selected. The voting ends.
 Otherwise they vote for the third candidate place in the same way and go on.
 If no place is selected at last there will be no spring outing and everybody stays at home.
 Before the voting, the Chief Entertainment Officer did a survey, found out every one's preference which can be represented as a permutation of 0, 1, ... K. (0 is for staying at home.) For example, when K=3, preference "1, 0, 2, 3" means that the first place is his first choice, staying at home is the second choice, the second place is the third choice and the third place is the last choice.
 The Chief Entertainment Officer sends the survey results to the class. So everybody knows the others' preferences. Everybody wants his more prefered place to be selected. And they are very smart, they always choose the optimal strategy in the voting progress to achieve his goal.
 Can you predict which place will be selected?

 输入描述:

 The first line contains two integers, N and K, the number of people in your class and the number of candidate places.
 The next N lines each contain a permutation of 0~K, representing someone's preference.
 For 40% of the data, 1 <= N, K <= 10
 For 100% of the data, 1 <= N, K <= 1000


 输出描述:

 Output the selected place. Or "otaku" without quotes if no place is selected.

 In the sample case, if the second peoson vote against the first place, no place would be selected finally because the first person must vote against the second place for his own interest. Considering staying at home is a worse choice than the first place, the second person's optimal strategy is voting for the first place. So the first place will be selected
 示例1
 输入

 2 2
 1 0 2
 2 1 0
 输出

 1
 */
public class VoteQues {
    /**
     6 5
     4 3 5 2 1 0
     4 1 5 0 2 3
     3 1 5 4 0 2
     3 1 2 4 0 5
     5 1 2 0 4 3
     0 3 2 4 1 5
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner ( System.in );
        while (sc.hasNext ()){
            int n = sc.nextInt ();
            int k = sc.nextInt ();
            //favor[i][j]表示第i個人对第j个景点的喜欢程度，值越小表示越喜欢，因为越小代表越靠前
            int[][] favor = new int[n][k+1];
            sc.nextLine ();
            for (int i=0;i<n;i++){
                for (int j=0;j<=k;j++){
                    int tmp = sc.nextInt ();
                    favor[i][tmp] = j;
                }
            }

            System.out.println (Arrays.deepToString ( favor ));
            //从最后一轮投票开始往回找，因为到了后面没有别的选择了，每个人可以清楚自己是否投票，有点递归的思想
            int votes = 0,finalChoice = 0;
            for (int j=k;j>=1;j--){
                votes = 0;
                for (int i=0;i<n;i++){
                    //比较每一个人对当前方案和下一方案的喜欢程度，来决定是否投票
                    if (favor[i][j] < favor[i][finalChoice])
                        votes++;
                }
                if (votes > n-votes)
                    finalChoice = j;
            }

            if (finalChoice == 0)
                System.out.println("otaku");
            else
                System.out.println (finalChoice);
        }
    }
}
