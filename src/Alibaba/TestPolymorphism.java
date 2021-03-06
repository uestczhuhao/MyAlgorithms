package Alibaba;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by zhuhao on 17-7-12.
 */
public class TestPolymorphism {
    // 优先级排序：this.show(Object)  super.show(Object)
    // this.show(super(Object))  super.show(super(Object))
    public static void main(String[] args) {
        A a1 = new A();
        A a2 = new B();
        B b = new B();
        C c = new C();
        D d = new D();

        System.out.println("1--" + a1.show(b));     //A and A
        System.out.println("2--" + a1.show(c));     //A and A
        System.out.println("3--" + a1.show(d));     //A and D
        System.out.println("4--" + a2.show(b));     //B and A
        System.out.println("5--" + a2.show(c));     //B and A
        System.out.println("6--" + a2.show(d));     //A and D
        System.out.println("7--" + b.show(b));      //B and B
        System.out.println("8--" + b.show(c));      //B and B
        System.out.println("9--" + b.show(d));      //A and D

        B ttt = new B ();
        A tttt = new A ();
        System.out.println (ttt instanceof A);
        System.out.println (ttt.getClass ());
        System.out.println (tttt.getClass ());
        System.out.println (tttt.getClass () == ttt.getClass ());
        System.out.println (tttt.getClass ().equals ( ttt.getClass () ));
        ArrayList<Integer> aa = new ArrayList<> (  );
        int aaaaa[] = new int[1];
        System.out.println (aa.getClass ());
        System.out.println (aaaaa.getClass ());

        Random ran = new Random (  );
        System.out.println (ran.nextInt (9-7+1)+7);
    }
}

class A {
    public String show(D obj) {
        return ("A and D");
    }

    public String show(A obj) {
        return ("A and A");
    }



    public void test_0724(){
        System.out.println ("AAAAAA");
    }
    public void test_07241(){
        System.out.println ("afeawfwae");
    }

}

class B extends A{
    public String show(B obj){
        return ("B and B");
    }

    public String show(A obj){
        return ("B and A");
    }

    public void test_0724(){
        System.out.println ("BBBBBB");
    }
}

class C extends B{

}

class D extends B{

}


abstract class test_abstract{
    abstract void test();
    void test1(){
        System.out.println ();
    }
}

abstract class test11 extends test_abstract{
//    abstract void test();
    abstract void test1();
    public test11(){

    }
}

