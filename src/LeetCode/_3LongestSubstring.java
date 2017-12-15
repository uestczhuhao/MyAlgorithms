package LeetCode;

import java.util.HashMap;

/*
    原注释：
    the basic idea is, keep a hashmap which stores the characters in
    string as keys and their positions as values,
    and keep two pointers which define the max substring.

    move the right pointer to scan through the string ,
    and meanwhile update the hashmap.

    If the character is already in the hashmap,
    then move the left pointer to the right of the same
    character last found.

    Note that the two pointers can only move forward.
 */
public class _3LongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        int max = 0;

        char[] chs = s.toCharArray();
        //map保存字母和其所在下标位置
        HashMap<Character,Integer> map = new HashMap<>();
        //
        for (int right=0,left=0;right<chs.length;right++){
            if (map.containsKey(chs[right])){
                left = Math.max(left,map.get(chs[right])+1);
            }
            map.put(chs[right],right);
            max = Math.max(max,right-left+1);
        }
        return max;
    }
}
