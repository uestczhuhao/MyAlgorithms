package LeetCode;

/**
 * Created by zhuhao on 17-5-18.
 *
 * There are N children standing in a line.
 * Each child is assigned a rating value.
 * You are giving candies to these children
 * subjected to the following requirements:
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 */
public class Candy {

    public int candy(int[] ratings){
        int count = 0;
        int[] candyNum = new int[ratings.length];
        candyNum[0]=1;
        for(int i=1;i<ratings.length;i++){
            candyNum[i] = 1;
            if (ratings[i]>ratings[i-1])
                candyNum[i] =candyNum[i-1]+1;
        }
        for(int j=ratings.length-1;j>0;j--){
            if(ratings[j-1]>ratings[j]){
                if(j-2 >=0 && ratings[j-1]>ratings[j-2]){
                    int tmp = candyNum[j]+1;
                    candyNum[j-1] = Math.max ( tmp,candyNum[j-1] );
                } else candyNum[j-1] = candyNum[j]+1;
            }
        }
        for (int k=0;k<ratings.length;k++){
//            System.out.println (candyNum[k]);
            count+=candyNum[k];
        }

        return count;
    }
}
