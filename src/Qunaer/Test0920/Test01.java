package Qunaer.Test0920;


import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Test01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s =sc.nextLine();
        String str= s.replaceAll(" ", "");
        int n =sc.nextInt();
        char[] a=str.toCharArray();
        int [] num=new int [a.length];
        for(int i=0;i<num.length;i++){
            num[i]=(int)a[i];
        }
        Arrays.sort(num);
//        fastsort(data,0,data.length-1);
        for(int j=0;j<n-1;j++){
            System.out.print((char)num[j] + " ");

        }
        System.out.println((char)num[n-1]);

        for(int k=num.length-1;k>num.length-1-n;k--){
            System.out.print((char)num[k]);
            if(k!=num.length-2-n){
                System.out.print(" ");
            }
        }
    }
//    public static void fastsort(int[] a,int low,int high){
//        int start=low;
//        int end=high;
//        int key=a[low];
//        while(start<end){
//            while(start<end&&key<=a[end]){
//                end--;
//            }
//            if(key>=a[end]){
//                int temp=a[end];
//                a[end]=a[start];
//                a[start]=temp;
//            }
//            while(start<end&&key>=a[start]){
//                start++;
//            }
//            if(key<=a[start]){
//                int temp=a[end];
//                a[end]=a[start];
//                a[start]=temp;
//            }
//
//        }
//        if(start>low)fastsort(a,low,start-1);
//        if(end<high)fastsort(a,end+1,high);
//
//    }

}
