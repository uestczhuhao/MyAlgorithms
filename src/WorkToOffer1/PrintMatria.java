package WorkToOffer1;

public class PrintMatria {
    public static void main(String[] args) {
        int[][] input = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        print(input);
    }

    private static void print(int[][] arr){

        if (arr.length ==0 || arr[0].length ==0)
            throw new Error("Invalid Input!!!");

        int row = arr.length;
        int columm = arr[0].length;
        int start = 0;
        while (row > start * 2 && columm>start * 2){
            int endX = row - 1 - start;
            int endY = columm - 1 - start;
            //从左向右打印
            for (int i=start;i<= endX;i++){
                System.out.print (" "+arr[start][i]);
            }

            //从上往下打印
            if (start < endX){
                for (int i=start+1;i<=endX;i++){
                    System.out.print(" "+arr[i][endY]);
                }
            }

            //从右往左打印
            if (start<endX && start<endY){
                for (int i=endY-1;i>=start;i--){
                    System.out.print (" "+arr[endX][i]);
                }
            }

            //从下往上打印
            if (start<endX-1 && start<endY){
                for (int i=endY-1;i>start;i--){
                    System.out.print(" "+arr[i][start]);
                }
            }

            start++;
        }
    }
}
