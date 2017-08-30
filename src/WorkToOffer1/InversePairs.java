package WorkToOffer1;

/**
 * Created by zhuhao on 17-8-30.
 */
public class InversePairs {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,0};
//        int[] nums = {7,5,6,4};
        int[] copy = new int[nums.length];
        System.out.println (countPairs ( nums,copy,0,nums.length-1 ));
    }

    public static int countPairs(int[] nums,int[] copy,int start,int end){
        if (start >= end){
            return 0;
        }
        int middle = (start+end)>>1;

        int left = countPairs ( nums,copy,start,middle );
        int right = countPairs ( nums,copy,middle+1,end );
        int count = 0;
        int p1 = middle,p2 = end;
        int p3 = end;
        while (p1 >= start && p2>= middle+1){
            if (nums[p1] > nums[p2]){
                count += p2-middle;
                copy[p3--] = nums[p1--];
                if (count >= 1000000007)
                    count%= 1000000007;
            } else{
                copy[p3--] =nums[p2--];
            }
        }

        for (;p2>=middle+1;p2--){
            copy[p3--] = nums[p2];
        }

        for (;p1>=start;p1--){
            copy[p3--] = nums[p1];
        }

        for (int i=start;i<=end;i++)
            nums[i] = copy[i];
        return (left+right+count)%1000000007;
    }
}
