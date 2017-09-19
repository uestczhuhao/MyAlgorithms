package XiaoMi.Test0918;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by zhuhao on 17-9-18.
 */
public class PathMatch {
    public static void main(String[] args) {
        Scanner sc = new Scanner ( System.in );
        ArrayList<String> input = new ArrayList<> (  );
        ArrayList<String> match = new ArrayList<> (  );
        boolean in = true;
        while (sc.hasNext ()){
            String tmp = sc.nextLine ();
            if (tmp.equals ( "-" )){
                in = false;
                continue;
            }
            if (in){
                input.add ( tmp );
            } else {
                match.add ( tmp );
            }
        }

        for (int j=0;j<match.size ();j++){
            int maxLen = 0;
            String id = "0";
            String ma = match.get ( j );
            for (int i=0;i<input.size ();i++){
                //regis[0]字符串，regis[1]为ID
                String[] regis = input.get ( i ).split ( " " );
                if (regis[0].length () > ma.length ()){
                    continue;
                } else {
                    int index = ma.indexOf ( regis[0],0 );
                    if (index != -1 && index+regis[0].length () > maxLen ){
                        if (ma.length () > index+regis[0].length () && ma.charAt ( index+regis[0].length () ) != '/'){
                            continue;
                        }
                        maxLen = index+regis[0].length ();
                        id = regis[1];
                    }
                }


            }
            System.out.println (id);
        }

//        System.out.println (input);
//        System.out.println (match);
    }
}
