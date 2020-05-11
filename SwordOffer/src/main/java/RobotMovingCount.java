import java.util.Arrays;

/**
 * 地上有一个 m 行和 n 列的方格。一个机器人从坐标 (0, 0) 的格子开始移动，它每次可以向左、右、上、下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的 数位之和 大于 k 的格子。例如，当 k 为 18 时，机器人能够进入方格（35, 37），因为 3+5+3+7=18。
 * 但是，它不能进入方格（35, 38），因为 3+5+3+8=19。请问该机器人能够达到多少个格子？
 * 思路：利用回溯法进行计算，机器人从(0,0)开始运行，扫描上下左右，如果可达则进入下一个节点，都不可达则返回上一个节点，每一次递归都计算
 * 从当前点出发可以向四周前进的格子数，计算完毕后返回格子数
 *
 * @author hasee
 */
public class RobotMovingCount {
    /**
     * 初始化地图和k值
     */
    private boolean[][] flags;
    private int k;
    private int row;
    private int column;

    RobotMovingCount(int row, int column,int k) {
        this.flags = new boolean[row][column];
        this.k = k;
        this.row = row;
        this.column = column;
    }

    /**
     * 返回机器人能到达的格子数
     *
     * @param r    当前行
     * @param c 当前列
     */
    int movingCount(int r, int c) {
        if (r >= 0 && r <= row-1 && c >= 0 && c <= column-1 && flags[r][c] == false && checkNumber(r, c)) {
            int steps = 1;
            flags[r][c]=true;
            steps += movingCount(r, c + 1) + movingCount(r + 1, c) +
                    movingCount(r, c - 1) + movingCount(r - 1, c);
            return steps;
        }
        return 0;
    }

    boolean checkNumber(int row, int column) {
        int num = 0;
        while (row != 0) {
            num += row % 10;
            row = row / 10;
        }
        while (column != 0) {
            num += column % 10;
            column = column / 10;
        }
        return num <= k?true : false;
    }
}
