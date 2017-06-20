package WorkToOffer;

import java.util.Scanner;

/**
 * Created by zhuhao on 17-6-20.
 */
public class FirstAppearOnce {

    public static void main(String[] args) {
        Scanner in = new Scanner ( System.in );
        while (in.hasNext ()){
            int a = in.nextInt ();
            System.out.println (a);
        }

    }

    public int[] chs = new int[256];
    public int index = 1;

    //Insert one char from stringstream
    public void Insert(char ch)
    {
        if (chs[ch] == 0)
            chs[ch] = index;
        else
            chs[ch] = -1;
        index++;
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        int tmp = Integer.MAX_VALUE;
        char ch = '#';
        for (int i=0;i<256;i++){
            if (chs[i] != 0 && chs[i] != -1 && chs[i] < tmp){
                tmp = chs[i];
                ch = (char)i;
            }
        }

        return ch;
    }
}
