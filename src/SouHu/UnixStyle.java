package SouHu;

/**
 * Created by zhuhao on 17-9-17.
 */
import java.util.*;
public class UnixStyle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine ();
            System.out.println (simplifyPath ( str ));
        }
    }
    public static String simplifyPath(String path) {
        Stack<String> s = new Stack<>();
        String[] p = path.split("/");
        for (String t : p) {
            if (!s.isEmpty() && t.equals("..")) {
                s.pop();
            } else if (!t.equals(".") && !t.equals("") && !t.equals("..")) {
                s.push(t);
            }
        }
        List<String> list = new ArrayList(s);
//        System.out.println (list);
        if (!list.isEmpty ()){
            String result = "/"+list.get ( 0 );
            for (int i=1;i<list.size ();i++)
                result = result+"/" + list.get ( i );
            return result;
        } else {
            return "/";
        }
    }
}



