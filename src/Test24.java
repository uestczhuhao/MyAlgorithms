/**
 * Created by zhuhao on 17-8-10.
 */
public class Test24 {
    public static void main(String[] args) {
        System.out.println (new B().getValue ());
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