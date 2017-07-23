import java.util.Arrays;

/**
 * Created by zhuhao on 17-7-20.
 */
public class TestMultiThread {
    public static void main(String[] args) {
        try{
            MyThread thread = new MyThread ();
            thread.start ();
            Thread.sleep ( 1000 );
            thread.interrupt ();
            System.out.println ("是否停止1？ ="+thread.isInterrupted ());
            System.out.println ("是否停止2？ ="+thread.interrupted ());
        } catch (InterruptedException e){
            System.out.println ("main catch");
            e.printStackTrace ();
        }
        System.out.println ("end!");
    }

}

class MyThread extends Thread {
    @Override
    public void run() {
        super.run ();
        for (int i=0;i<50000+1;i++){
            System.out.println ("i= "+i);
        }
    }
}

interface teste {
    default void test1(){
        System.out.println ("afe");
    }
    default void test2(){
        System.out.println ("afaefa");
    }
}
