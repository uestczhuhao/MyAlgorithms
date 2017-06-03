package WorkToOffer;

/**
 * Created by zhuhao on 17-6-3.
 */
abstract class Person {
    public abstract void eat();
}

public class Demo {
    public static void main(String[] args) {
        Person p = new Person() {
            public void eat() {
                System.out.println("eat something");
            }
        };
        p.eat();
    }
}