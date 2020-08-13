package traceBack;

import java.util.LinkedList;

/**
 * n皇后问题，输入n*n正方形棋盘，输出n个皇后在棋盘中的摆放方式
 */
public class NQueen {

    public static void main(String[] args) {
        NQueen nQueen = new NQueen();
        nQueen.findBoard(new char[][]{{'.','.','.','.'},{'.','.','.','.'},{'.','.','.','.'},{'.','.','.','.'}},0);
    }

    void findBoard(char[][] board, int row) {
        if (row == board[0].length) {//结束条件
            for (char[] i : board) {
                for (char j : i) {
                    System.out.print(j);
                }
                System.out.println("");
            }
            System.out.println("---------------");
            return;
        }
        for (int i = 0; i < board[0].length; i++) {
            if (!isValid(board, row, i)) {
                continue;
            }
            board[row][i] = 'Q';
            findBoard(board, row + 1);
            board[row][i] = '.';
        }
    }

    private boolean isValid(char[][] board, int row, int column) {
        //检查竖行
        for (int i = 0; i < row; i++) {
            if (board[i][column] == 'Q') {
                return false;
            }
        }
        //检查横行
        for (int i = 0; i < column; i++) {
            if (board[row][i] == 'Q') {
                return false;
            }
        }
        //检查左斜上方和右斜上方
        int i = row, j = column;
        while (i >= 0 && j >= 0) {
            if (board[i][j] == 'Q') {
                return false;
            }
            i--;
            j--;
        }
        i = row;
        j = column;
        while (i >= 0 && j <= board[0].length-1) {
            if (board[i][j] == 'Q') {
                return false;
            }
            i--;
            j++;
        }
        return true;
    }
}
