package Alibaba.Test0825;

import java.util.*;
/**
 * Created by zhuhao on 17-8-25.
 */

/*
1;A;A;B;B;17.5
2;B;A;A;B;17.5
3;A;A;B;B;17.5
4;B;A;A;B;9.6
        */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<UnilateralLine> lineList = new ArrayList<UnilateralLine>();
        while (scanner.hasNextLine()) {
            String[] options = scanner.nextLine().split(";");
            if (options.length < 5) {
                break;
            }
            lineList.add(new UnilateralLine(options[0], options[1], options[2], options[3], options[4], options[5]));
        }


        // wirte your code here
        List<String> result = calculateUnilateral(lineList);

        System.out.println (result.size ());
        for (String str : result) {
            System.out.println(str);
        }

        scanner.close();
    }
    public static List<String> calculateUnilateral(List<UnilateralLine> lineList) {
        List<String> result = new ArrayList<String>();
        for (int i=0;i<lineList.size ();i++){
            for (int j=0;j!=i && j<lineList.size ();j++){
                if (lineList.get ( i ).getSCen().equals ( lineList.get ( j ).getECen() ) &&
                        lineList.get ( i ).getTType ().equals ( lineList.get ( j ).getTType () )){
                    String tmp = "rule1: ";
                    tmp+= lineList.get ( j ).getId ()+"+"+lineList.get ( i ).getId ();
                    result.add ( tmp );
                }

            }
        }
        return result;
    }
    public static class UnilateralLine {
        private String id;
        private String sCen;//出发分拨
        private String sPro;//出发省
        private String eCen;//到达分拨
        private String ePro;//到达省
        //9.6m/17.5m
        private String tType;//车型
        public UnilateralLine(String id, String sCen, String sPro, String eCen, String ePro,String tType) {
            this.id = id;this.sCen = sCen;this.sPro = sPro;this.eCen = eCen;this.ePro = ePro;this.tType = tType;}
        public String getId() {return id;}
        public void setId(String id) {this.id = id;}
        public String getSCen() {return sCen;}
        public void setSCen(String ePro) {this.ePro = ePro;}
        public String getSPro() {return sPro;}
        public void setSPro(String sPro) {this.sPro = sPro;}
        public String getECen() {return eCen;}
        public void setECen(String eCen) {this.eCen = eCen;}
        public String getEPro() {return ePro;}
        public void setEPro(String ePro) {this.ePro = ePro;}
        public String getTType() {return tType;}
        public void setTType(String tType) {this.tType = tType;}
    }
}
