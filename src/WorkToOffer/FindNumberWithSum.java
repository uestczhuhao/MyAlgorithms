package WorkToOffer;

import java.util.ArrayList;

/**
 * Created by zhuhao on 17-6-17.
 */
public class FindNumberWithSum {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> re = FindContinuousSequence ( 9 );
        System.out.println (re);
    }
    public static ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<> (  );
        if (sum<=0)
            return result;

        int small=1,big=2;
        int sumTemp = small+big;
        while (small <(1+sum)/2 && big<=(1+sum)/2){
            if (sumTemp == sum){
                ArrayList<Integer> tmp = new ArrayList<> (  );
                for (int i=small;i<=big;i++)
                    tmp.add ( i );
                result.add ( tmp );
                big++;
                sumTemp+=big;
            } else if(sumTemp < sum){
                big++;
                sumTemp+=big;
            }
            else {
                sumTemp -= small;
                small++;
            }
        }
        return result;
    }
}
