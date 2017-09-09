package Sougou0908;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.spec.ECField;
import java.text.DecimalFormat;
import java.util.Arrays;

public class CircleLength {
    static double calDist(double n1, double n2){
        double diff = Math.abs(n1 - n2);
        return Double.compare(diff,180.0) > 0 ? 360.0 - diff : diff;
    }

    public static void main(String[] args) {
        BufferedReader localReader = new BufferedReader(new InputStreamReader(System.in));
        String nStr = "";
        int n =0;
        try {
            nStr = localReader.readLine();
            n = Integer.valueOf(nStr);
        } catch (Exception e){
            e.printStackTrace();
        }
        double[] point = new double[n];
        for (int i=0;i<n;i++){
            try {
                nStr = localReader.readLine();
                point[i] = Double.valueOf(nStr);
            } catch (Exception e){
                e.printStackTrace();
            }

        }
        Arrays.sort(point);


        double max = 0.0;
        int n1 = 0;
        int n2 = 1;

        while(n2 < n){
            double diff = point[n2] - point[n1];
            if(Double.compare(diff , 180.0) > 0){
                double dist = calDist(point[n1],point[n2]);
                if(dist > max)
                    max = dist;
                n1++;
            }else{
                if(diff > max)
                    max = diff;
                n2++;
            }
        }


        DecimalFormat format = new DecimalFormat("0.00000000");
        System.out.println(format.format(max));


    }

}
