/**
 * Created by zhuhao on 17-8-15.
 */
public class TestNewCoder {
    public static TestNewCoder t1 = new TestNewCoder();
    public static TestNewCoder t2 = new TestNewCoder();
    {
        System.out.println("构造块");
    }
    static
    {
        System.out.println("静态块");
    }
    public static void main(String[] args)
    {
        TestNewCoder t = new TestNewCoder();
    }
}
