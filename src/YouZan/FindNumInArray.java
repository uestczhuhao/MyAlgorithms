package YouZan;

import java.util.Scanner;

/*
47 4 4
1 2 3 5
12 13 13 23
25 36 47 55
131 2432 43443 31323
 */
public class FindNumInArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int row = sc.nextInt();
            int col = sc.nextInt();
            int[][] arr = new int[row][col];
            for (int i=0;i<row;i++){
                for (int j=0;j<col;j++){
                    arr[i][j] = sc.nextInt();
                }
            }
            int[] res =find1(n,arr);
            System.out.println(res[0] + " "+res[1]);
        }

    }




    public static int[] find(int target, int[][] array) {
        int rows= array.length;
        int columns=array[0].length;
        int[] found= new int[2];
        found[0] = found[1] = -1;
        if (array == null || rows == 0 ||columns ==0)
            return found;
        if(rows>0 && columns>0){
            int row=0;
            int column=columns-1;
            while(row<rows&&column>=0){
                if(array[row][column]==target){
                    found[0] = row;
                    found[1] = column;
                    break;
                }else if(array[row][column]>target)
                    --column;
                else
                    ++row;

            }
        }
        return found;
    }

    public static int[] find1(int target, int[][] array) {
        int rows= array.length;
        int columns=array[0].length;
        int[] found= new int[2];
        found[0] = found[1] = -1;
        if (array == null || rows == 0 ||columns ==0)
            return found;
        boolean flsg = true;
        for (int i=0;i<rows && flsg;i++){
            flsg = true;
            for (int j=0;j<columns;j++){
                if (array[i][j] == target){
                    found[0] = i;
                    found[1] = j;
                    flsg = false;
                    break;
                }
            }
        }
        return found;
    }
}
