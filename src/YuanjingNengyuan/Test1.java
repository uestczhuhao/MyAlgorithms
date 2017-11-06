package YuanjingNengyuan;

/**
 * Created by zhuhao on 17-9-17.
 */

import java.util.*;

public class Test1 {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            char[][] mapInput = new char[8][8];
            for (int i = 0; i < 8; i ++ ) {
                String s = sc.next();
                for (int j = 0; j < 8; j ++ )
                    mapInput[i][j] = s.charAt(j);
            }
            int row = sc.nextInt() - 1;
            int col = sc.nextInt() - 1;
            char c = sc.next().charAt(0);
            mapInput[row][col] = c;
            doRevese(mapInput, row, col, c);
            for (int i = 0; i < mapInput.length; i ++ ) {
                for (int j = 0; j < mapInput[0].length; j ++ ) {
                    if(j == mapInput[0].length - 1) System.out.println(mapInput[i][j]);
                    else System.out.print(mapInput[i][j]);
                }
            }
            System.out.println();
        }
    }

    public static void doRevese(char[][] mapInput, int row, int col, char c) {
        int[][] direction = {{0, 1}, {0, - 1}, {1, 0}, { - 1, 0}, {1, 1}, {1, - 1}, { - 1, 1}, { - 1, - 1}};
        for (int i = 0; i < direction.length; i ++ ) {
            int x = row + direction[i][0];
            int y = col + direction[i][1];
            while (x >= 0 && x < mapInput.length && y >= 0 && y < mapInput[0].length && mapInput[x][y] != c && mapInput[x][y] != '.') {
                x += direction[i][0];
                y += direction[i][1];
            }
            if(x >= 0 && x < mapInput.length && y >= 0 && y < mapInput[0].length && mapInput[x][y] == c) {
                while (mapInput[x -= direction[i][0]][y -= direction[i][1]] != c)
                    mapInput[x][y] = c;
            }
        }
    }
}