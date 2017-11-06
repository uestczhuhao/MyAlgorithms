import java.io.Serializable;
//
/**
 * Created by zhuhao on 17-9-15.
 */
//
//interface I extends Serializable{
//    //应该初始化
////    String id;
//    String id = "1";
//    String getId();
//}
//
//abstract class P implements I{
//    String id = "3";
//    void getId(String pa){}
//}
//
//class C1 extends P{
//    private static String id = "4";
//    C2 c2 = null;
//    C1(){}
//    //应该为public
////    String getId(){
//    public String getId(){
//        return id;
//    }
//}
//
//class C2 extends P{
//    private static String id = "5";
//    private C2(){}
//
//    public String getId(){
//        return id;
//    }
//}
//public class ShumaVersion {
//    //没有main函数，但是不会有编译错误
//    public void main(String args){
//        I c = new C1();
//        System.out.println ();
//    }
//}

interface IX {
    String isx = "isx";
    boolean excute(String sql);
}

abstract class AbsIX implements IX{
    static String isx = "absix";
    public AbsIX(){
        System.out.println (isx);
    }

    public boolean excute(String sql){
        return this.isx == "absix";
    }
}

class CX1 extends AbsIX {
    static {isx = "CX1";}
    public boolean excute(String sql){
        System.out.println (isx);
        return this.isx == "CX1";
    }
}

class CX2 extends AbsIX {
    CX2() {isx = "CX2";}
    public boolean excute(String sql){
        System.out.println (isx);
        return this.isx.equals ( "CX2" ) ;
    }
}
public class ShumaVersion {
    public static void main(String[] args) {
        IX cx1 = new CX1 ();
        IX cx2 = new CX2 ();
        if (cx1.excute ( null )){
            System.out.println (cx2.isx);
        } else if (cx2.excute ( null )){
            System.out.println (cx1.isx);
        }
    }
}

