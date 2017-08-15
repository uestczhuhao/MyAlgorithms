package HuaWei;

import java.util.Scanner;

/**
 * Created by zhuhao on 17-8-15.
 * 数独是一个我们都非常熟悉的经典游戏，运用计算机我们可以很快地解开数独难题，现在有一些简单的数独题目，请编写一个程序求解。

 输入描述:
 输入9行，每行为空格隔开的9个数字，为0的地方就是需要填充的。


 输出描述:
 输出九行，每行九个空格隔开的数字，为解出的答案。
 */

import java.util.Scanner;

public class Soduku {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data3.txt"));
        while (scanner.hasNext()) {
            int[][] sudoku = new int[9][9];

            for (int i = 0; i < 9; i++) {
                sudoku[i] = new int[9];
            }

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sudoku[i][j] = scanner.nextInt();
                }
            }

            System.out.println(solve(sudoku));
        }

        scanner.close();
    }

    /**
     * 解决数独问题
     *
     * @param sudoku 数独棋盘
     * @return 结果
     */
    private static String solve(int[][] sudoku) {
        boolean[] f = {false};
        // 未处理前
//        System.out.println(sudokuToString(sudoku));
        solve(sudoku, 0, f);

        return sudokuToString(sudoku);
    }

    private static String sudokuToString(int[][] sudoku) {
        StringBuilder b = new StringBuilder(256);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                b.append(sudoku[i][j]).append(' ');
            }

            b.setCharAt(b.length() - 1, '\n');
        }

        return b.substring(0, b.length() - 1);
    }

    /**
     * 从第row行开始解决数独问题
     *
     * @param sudoku 数独划棋盘
     * @param finish 是否已经完成
     * @param r      开始处理的行
     */
    private static void solve(int[][] sudoku, int r, boolean[] finish) {

        // 如果已经完成就
        if (finish[0] || r > 8) {
            return;
        }

        int row = r;
        int col = 0;
        boolean find = false;

        // 从r行开始找第一个未处理的格子
        for (int i = r; i < 9 && !find; i++) {
            for (int j = 0; j < 9; j++) {
                if (sudoku[i][j] == 0) {
                    row = i;
                    col = j;
                    find = true;
                    break;
                }
            }
        }

        // 找到末处理的
        if (find) {

            boolean[] used = new boolean[10];

            // 标记第row行，第col列已经使用过的数字
            for (int i = 0; i < 9; i++) {
                used[sudoku[row][i]] = true;
                used[sudoku[i][col]] = true;
            }

            // 数独划棋盘的方格
            // (0, 0),(0, 1),(0, 2)
            // (1, 0),(1, 1),(1, 2)
            // (2, 0),(2, 1),(2, 2)

            // 标记[row, col]在第几个方格中
            int x = row / 3;
            int y = col / 3;

            for (int i = x * 3; i < (x + 1) * 3; i++) {
                for (int j = y * 3; j < (y + 1) * 3; j++) {
                    used[sudoku[i][j]] = true;
                }
            }

            // used中末被标记的说明可以使用，下标为0的不使用
            for (int i = 1; i < used.length; i++) {
                // 未被标记，说明sudoku[row][col]可以为i
                if (!used[i]) {
                    sudoku[row][col] = i;
                    used[i] = true;

                    // 处理下一个未填写的位置
                    solve(sudoku, row, finish);

                    // 如果找到方案就返回
                    if (finish[0]) {
                        return;
                    }

                    // 现场还原
                    sudoku[row][col] = 0;
                    used[i] = false;
                }
            }


        }
        // 没有找到未处理的，说明已经完成了解决方案
        else {
            finish[0] = true;
            return;
        }
    }
}


