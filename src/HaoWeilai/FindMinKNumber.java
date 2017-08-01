package HaoWeilai;

import java.util.Scanner;

/**
 * Created by zhuhao on 17-7-31.
 */
public class FindMinKNumber {
    public static void main(String[] args) {
        FindMinKNumber test = new FindMinKNumber ();

        Scanner in = new Scanner ( System.in );
        String str = in.nextLine ();
        String[] strs = str.split ( " " );

        int len = strs.length;
        //3 9 6 8 -10 7 -11 19 30 12 23 5
        int[] ints = new int[len-1];
        for (int i=0;i<len-1;i++){
            ints[i] = Integer.parseInt ( strs[i] );
        }
        int k = Integer.parseInt ( strs[len - 1] );
        int[] result = test.MinKNubmer ( ints,k );
        for (int i=0;i<result.length;i++){
            System.out.print (result[i]);
            if (i!=result.length-1)
                System.out.print (" ");
        }
    }

    public int[] MinKNubmer(int[] ints,int k){

        if (k<=0 || k>ints.length)
            return null;
        int[] result = new int[k];
        sort ( ints,0,ints.length-1 );
//        System.out.println (Arrays.toString ( ints ));
        System.arraycopy ( ints,0,result,0,k );
        return result;
    }

    public void sort(int[] ints,int low,int high){
        if (low==high)
            return;

//        System.out.println ("low = "+low+" high = "+high);
        int index = partition ( ints,low,high );
//        System.out.print (index+"  ");
        if (index>low)
            sort ( ints,low,index-1 );
        if (index<high)
            sort ( ints,index+1,high );
    }

    public int partition(int[] ints,int low,int high){
        if (low>=high){
            return low;
        }
//        Random ran = new Random (  );
//        int tmp = ints[low+ran.nextInt (high-low+1)];
//        System.out.println ("The Random is "+low+ran.nextInt (high-low+1));
        int tmp = ints[low];
        while (low<high){
            while (low<high && ints[high]>=tmp)
                high--;
            swap ( ints,low,high );

            while (low<high && ints[low]<=tmp)
                low++;
            swap ( ints,low,high );
        }
        return low;
    }

    public void swap(int[] ints, int sor,int des){
        int temp = ints[sor];
        ints[sor] = ints[des];
        ints[des] = temp;
    }


}
