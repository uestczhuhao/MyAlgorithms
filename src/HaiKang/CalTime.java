package HaiKang;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class CalTime {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] strs = sc.nextLine().split(",");
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            ParsePosition pos = new ParsePosition(0);
            int n = Integer.parseInt(strs[0]);
            if (n < 3){
                System.out.println("incorrect data");
                return;
            }
            Date dateSta = formatter.parse(strs[1]);
            Date dateEnd = formatter.parse(strs[2]);


            long dif = (dateEnd.getTime()-dateSta.getTime())/1000/60;
            String[] res = new String[2];
            if (dif <= 15*n){
                res[0] = "1";

                long endP = dif/15;
                long r = dif%15;
                if (r<=5){
                    if (endP+1 == n){
                        endP =0;
                    }
                    res[1] = String.valueOf(endP+1)+"-"+String.valueOf(endP+1);
                } else {
                    if(endP+2 == n){

                        res[1] = String.valueOf(endP+1)+"-"+String.valueOf(1);
                    } else if (endP+1 == n){
                        res[1] = String.valueOf(1)+"-"+String.valueOf(2);
                    } else {
                        res[1] = String.valueOf(endP+1)+"-"+String.valueOf(endP+2);
                    }
                }
            }

            System.out.println(res[0]+";"+res[1]);

        }
    }
}
