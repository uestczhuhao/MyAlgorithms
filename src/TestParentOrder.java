/**
 * Created by zhuhao on 17-7-31.
 */

class C {
    static {
        System.out.println ("Static C");
    }
    C(){
        System.out.println ("C");
    }
}

class AA{
    static {
        System.out.println ("Static A");
    }
    C c = new C();

    AA(){
        this("A");
        System.out.println ("A");
    }

    AA(String s){
        System.out.println (s);
    }
}
public class TestParentOrder extends AA{
    static {
        System.out.println ("Static Test");
    }

    TestParentOrder(){
        super();
//        super("B");
        System.out.println ("B");
    }

    public static void main(String[] args) {
        new TestParentOrder ();
    }
}


