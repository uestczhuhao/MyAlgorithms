package LeetCode;

import WorkToOffer.TestBase;

/**
 * Created by zhuhao on 17-6-3.
 */
public class TestChild extends TestBase{
    //通过建立父类的对象测试
    public void testCrossPackage(){
        TestBase base = new TestChild ();
        //base.protectInt;  //跨包使用base中的protect实例变量失败
        //base.getPortectInt(); //跨包使用base中的protect方法失败
    }

    //直接通过继承Base的子类来测试
    public void testThroughClass(){
        protectInt = 666; //直接在类中访问正常
        System.out.println ("The protectInt now is "+getPortectInt ());
        super.protectInt = 777;//与上一行直接改变protectInt的值效果一样
        System.out.println ("The protectInt now is "+super.getPortectInt ());
    }

    //通过继承Base子类的对象做测试
    public void testThroughObject(){
        TestChild test = new TestChild ();
        test.protectInt =7676;  //通过TestChild的对象做测试，成功
        test.getPortectInt ();  //protected限定的实例变量和方法都通过测试
        System.out.println ("The protectInt now is "+getPortectInt ());
        //输出结果为1，表明父类没有受到影响
        System.out.println ("The protectInt now is "+test.getPortectInt ());
        //输出结果为7676,因为此实例变量的改变是绑定到对象test中的

    }


    public static void main(String[] args) {
        TestChild test = new TestChild ();
//        test.testThroughClass ();
        test.testThroughObject ();
    }
}
