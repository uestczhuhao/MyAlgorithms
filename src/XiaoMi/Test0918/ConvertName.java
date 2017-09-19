package XiaoMi.Test0918;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by zhuhao on 17-9-18.
 */
public class ConvertName {
    public static void main(String[] args) {
        Scanner sc = new Scanner ( System.in );
        while (sc.hasNext ()){
            String str = sc.nextLine ();
            char[] chs = str.toCharArray ();
            ArrayList<String> res = new ArrayList<> (  );
            int begin = 0;
            int end = begin;
            while (begin<str.length ())
            {
                while (end<str.length() && ((chs[end] >= 'a' && chs[end] <= 'z') || (chs[end] >= 'A' && chs[end] <= 'Z')))
                {
                    end++;
                }
                if (begin != end)
                {
                    String temp;
                    temp = str.substring (begin, end-begin);
                    temp = temp.toUpperCase ();
                    res.add(temp);
                    begin = end;

                }
                if (end <str.length () && chs[end] == '.')
                {
                    end++;
                    begin = end;
                }

                while (end<str.length() && chs[end] >= '0' &&chs[end] <= '9')
                    end++;
                if (begin != (end))
                {
                    String temp;
                    temp = str.substring(begin, end - begin);
                    res.add (temp);
                    begin = end;
                }
            }
            StringBuffer out = new StringBuffer (  );
            for (int i = 0; i<res.size (); i++)
            {
                String temp = '_' + res.get ( i );
                out.append ( temp );
            }
            out.append ( '_' );
            System.out.println (out.toString ());
        }
    }


}


