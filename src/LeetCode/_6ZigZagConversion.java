package LeetCode;

public class _6ZigZagConversion {
    public String convert(String s, int numRows) {
        if (numRows == 1 || s == null || s.length()<= numRows)
            return s;
        char[] chs = s.toCharArray();
        StringBuilder strB = new StringBuilder();

        int stepLen = 2*numRows-2;
        for (int i=0;i<numRows;i++){
            strB.append(chs[i]);
            int multi = 1;
            int index = i+multi*stepLen;
            if (i == 0 || i ==numRows-1) {
                while (index < s.length()){
                    strB.append(chs[index]);
                    multi++;
                    index = i+multi*stepLen;
                }
            } else {
                int tmp = index - i*2;
                while (tmp < s.length()){
                    strB.append(chs[tmp]);
                    if (index < s.length())
                        strB.append(chs[index]);
                    multi++;
                    index = i+multi*stepLen;
                    tmp = index - i*2;
                }
//                System.out.println(i);
            }

        }
        return strB.toString();
    }
}
