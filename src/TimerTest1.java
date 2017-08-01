import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by zhuhao on 17-7-23.
 */
public class TimerTest1 {
    private static Timer timer = new Timer (  );
    private static int runCount = 0;
    static public class Mytask1 extends TimerTask{
        @Override
        public void run(){
            try {
                System.out.println ("1 begin 运行了！时间为："+new Date (  ));
                Thread.sleep ( 3000 );
                System.out.println ("1      end 运行了！时间为："+new Date (  ));
                runCount++;
                if (runCount == 5){
                    timer.cancel ();
                }
            } catch (InterruptedException e){
                e.printStackTrace ();
            }
        }
    }

    public static void main(String[] args) {
        try {
            Mytask1 task1 = new Mytask1 ();
            SimpleDateFormat sdf1 = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss" );
            String dataString1 = "2017-07-23 15:48:00";
            Date dateRef1 = sdf1.parse(dataString1);
            System.out.println ("字符串1时间： "+dateRef1.toLocaleString ()+"当前时间： "+new Date (  ).toLocaleString ());
            timer.schedule ( task1,dateRef1,4000 );
        } catch (ParseException e){
            e.printStackTrace ();
        }
    }
}
