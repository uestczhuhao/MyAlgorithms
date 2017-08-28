package ZhongXing;
import java.util.*;
/**
 * Created by zhuhao on 17-8-28.
 */
// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class StringArray {

    public static void main(String[] args) {
        String[] arr = {"aba","ada","afa","aha"};
        System.out.println (canArrangeWords ( arr ));
    }
    //METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public static int canArrangeWords(String arr[])
    {
        int n = arr.length;
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        for (int i=0;i<n ;i++ ){
            String tmp = arr[i];
            char start = tmp.charAt(0);
            char end = tmp.charAt(tmp.length()-1);
            if(map.get(start) == null){
                map.put(start,1);
            } else {
                map.put(start,map.get(start)+1);
            }

            if(map.get(end) == null){
                map.put(end,1);
            } else {
                map.put(end,map.get(end)+1);
            }
        }

        int count = 0;
        for(Map.Entry<Character,Integer> tmp:map.entrySet()){
            if(tmp.getValue () % 2 ==1){
                count++;
            }
        }

        if(count == 2 || count==0){
            return 1;
        }

        return -1;
        // INSERT YOUR CODE HERE

    }
}




