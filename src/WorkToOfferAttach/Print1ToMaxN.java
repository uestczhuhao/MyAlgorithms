package WorkToOfferAttach;

/**
 * Created by zhuhao on 17-6-24.
 */
public class Print1ToMaxN {
    public static void main(String[] args) {
        Print1ToMaxN test = new Print1ToMaxN ();
        test.print1ToMaxN ( 2);
    }
    public void print1ToMaxN(int n){
        if (n <= 0 )
            return;

        char[] nums = new char[n];
        for (int i=0;i<n;i++)
            nums[i] = '0';

        printCore ( nums,n,0 );
    }

    public void printCore(char[] nums,int length,int index){
        if (index == length){
            printNum ( nums );
            return;
        }

        for (int i=0;i<10;i++){
            nums[index] = (char) (i+48);
            printCore ( nums,length,index+1 );
        }
    }

    public void printNum(char[] nums){
        if (nums==null || nums.length==0)
            return;

        int i =0;
        for (;i<nums.length;i++){
            if (nums[i] != '0')
                break;
        }
        char[] tmp = new char[nums.length-i];
        System.arraycopy ( nums,i,tmp,0,tmp.length );
        String outPut = String.valueOf ( tmp );
        System.out.print (outPut+" ");
    }
}
