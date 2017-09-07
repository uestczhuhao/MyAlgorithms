public class TestJoinMethod {
    public static void main(String[] args) {

        Thread tt = new Thread(new MyThread1());
        tt.start();

        try {
            //当join的时间大于tt线程sleep的时间时，Main先输出，证明主线程只等待join()方法括号中的时间
            tt.join(2000);
            System.out.println("Main!");
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}

class MyThread1 implements Runnable{
    @Override
    public void run(){
        try {
            System.out.println("MyThread start!");
            Thread.sleep(5000);
            System.out.println("MyThread end!");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
