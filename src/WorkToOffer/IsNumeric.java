package WorkToOffer;

/**
 * Created by zhuhao on 17-6-19.
 * 在每一次index[0]++之后都要检查是否越界
 */
public class IsNumeric {
    public static void main(String[] args) {
//        IsNumeric test = new IsNumeric ();
//        String str = "1.2.3";
//        System.out.println ("Test is numeric or not： "+test.isNumeric ( str.toCharArray () ));

        System.out.println ((int)Character.MAX_VALUE);
        System.out.println ((int)Character.MIN_VALUE);

        try {
            for (int i=0;i<=65535;i++){
                char c = (char) i;
                System.out.print (c+" ");
                if (i %100 ==0)
                    System.out.println ();
            }
        } catch (Exception e){
            e.printStackTrace ();
        }

    }
    public boolean isNumeric(char[] str) {
        if (str == null || str.length ==0)
            return false;
        if (str[0] == '+' || str[0]=='-'){
            if (str.length == 1)
                return false;
        }

        boolean isNumbewric = true;
        int[] index = new int[1];
        index[0] = 0;
        if (str[0] == '+' || str[0]=='-'){
            index[0] = 1;
        }
        scanDigit(str,index);

        if (index[0] < str.length){
            if (str[index[0]] == '.'){
                index[0]++;
                scanDigit ( str,index );
                if ( index[0]<str.length  &&(str[index[0]] == 'e' || str[index[0]] == 'E'))
                {
                    index[0]++;
                    isNumbewric = isExponential ( str,index );
                }
            } else if (index[0]<str.length  && (str[index[0]] == 'e' || str[index[0]] == 'E')){
                index[0]++;
                isNumbewric = isExponential ( str,index );
            } else
                isNumbewric =false;
        }
        System.out.println (isNumbewric);
        System.out.println (index[0] != str.length);
        if (index[0] != str.length)
            isNumbewric=false;
        return isNumbewric;
    }

    public void scanDigit(char[] str,int[] index){
        while (index[0] < str.length && str[index[0]] >='0' && str[index[0]] <='9')
            index[0]++;
    }

    public boolean isExponential(char[] str,int[] index){
        if (index[0] < str.length){
            if (index[0]+1 < str.length){
                if (str[index[0]] == '+' || str[index[0]] == '-')
                    index[0]++;

                scanDigit ( str,index );
                if (index[0] == str.length)
                    return true;
                else
                    return false;
            } else if (str[index[0]] >= '0' && str[index[0]] <= '9'){
                index[0] ++;
                return true;
            }
            else
                return false;
        }
        else
            return false;
    }
}

