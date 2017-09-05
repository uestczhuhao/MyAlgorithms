/**
 * Created by zhuhao on 17-8-10.
 */
public class Test24 {
    private String str = "aaaa";
    private int a = 11;

    public String getStr(){
        return str;
    }
    public void setStr(String ss){
        str = ss;

    }

    public int getA() {
        return a;
    }

    public void change(int b) {
        b = 0;
    }

    public static void main(String[] args) {
        Test24 t = new Test24 ();
        System.out.println (t.getA ());

        System.out.println (t.getStr ());

        t.change ( t.getA () );
        t.setStr ( "asasas" );
        System.out.println (t.getA ());
        System.out.println (t.getStr ());
//        System.out.println (new B().getValue ());
    }

    static class A{
        protected int value;
        public A(int v){
            setValue(v);
        }

        public void setValue(int value){
            this.value = value;
        }

        public int getValue(){
            try {
                value++;
                return value;
            } finally {
                this.setValue ( value );
                System.out.println (value);
            }
        }

    }

    static class B extends A{
        public B() {
            super(5);
            setValue ( getValue ()-3 );
        }

        public void setValue(int value){
            super.setValue ( 2*value );
        }
    }
}

class testA {
    protected void testA(){
        System.out.println ("AAA");
    }
}

class testB extends testA{
    public void testA(){
        System.out.println ("BBB");
    }
}