/**
 * 设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，
 * 每一步可以在矩阵中向左，向右，向上，向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 * 例如下面的矩阵包含了一条 bfce 路径。但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 * 思路：利用回溯法暴力遍历。先找到路径的起点，然后由此起点分别向右、下、左、上进行移动，如果移动至下一格后的值是路径的下一步，
 * 那么继续向前，否则回退至上一个节点。
 * 注：每个格子只能进入一次
 *
 * @author hasee
 */
public class FindPathInMatrix {
    /**
     * path 是返回的路径数组
     */
    private char[][] array;
    private char[] target;
    //    记录是否遍历过
    private boolean[][] flags;
    //记录路径
    private int[][] path;

    FindPathInMatrix(char[][] array, char[] target) {
        if (array != null && target != null || array.length == 0 || target.length == 0) {
            this.array = array;
            this.target = target;
            this.flags = new boolean[array.length][array[0].length];
            this.path = new int[target.length][2];
        } else {
            return;
        }
    }

    public int[][] getPath() {
        if (path[path.length - 1][0] == 0 && path[path.length - 1][1] == 0) {
            return null;
        }
        return path;
    }

    /**
     * 找到路径的起点
     */
    int[][] findFirstPos() {
        int[][] pos = new int[array.length*array[0].length][2];
        int k = 0;
        for (int i = 0; i < array.length; ++i) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == target[0]) {
                    pos[k][0] = i;
                    pos[k][1] = j;
                    k++;
                }
            }
        }
        if (pos.length == 0) {
            return null;
        } else {
            return pos;
        }
    }

    void findPath() {
        for (int[] pos : findFirstPos()) {
            if (pos != null) {
                path[0][0] = pos[0];
                path[0][1] = pos[1];
                find(path[0], 1);
            }
        }
    }

    /**
     * 开始寻找路径
     *
     * @param targetNum 路径中当前坐标的下一个节点，此处从1开始
     * @param pos       pos[0]表示行坐标，pos[1]表示纵坐标
     */
    void find(int pos[], int targetNum) {
        flags[pos[0]][pos[1]] = true;
//        已经找出了完整的路径
        if (array[pos[0]][pos[1]] == target[target.length - 1]) {
            path[target.length - 1][0] = pos[0];
            path[target.length - 1][1] = pos[1];
            return;
        }
//        首先向右,如果右边节点是路径的下一个节点，且没有访问过，那么直接访问此节点
        if ((pos[1] + 1 < array[0].length) && (array[pos[0]][pos[1] + 1] == target[targetNum]) && (flags[pos[0]][pos[1] + 1] == false)) {
            if (returnPath(pos, targetNum)) {

                return;
            }
            find(new int[]{pos[0], pos[1] + 1}, targetNum + 1);
        }
//        下
        if ((pos[0] + 1 < array.length) && (array[pos[0] + 1][pos[1]] == target[targetNum]) && (flags[pos[0] + 1][pos[1]] == false)) {
            if (returnPath(pos, targetNum)) {

                return;
            }
            find(new int[]{pos[0] + 1, pos[1]}, targetNum + 1);
        }
//        左
        if ((pos[1] - 1 >= 0) && (array[pos[0]][pos[1] - 1] == target[targetNum]) && (flags[pos[0]][pos[1] - 1] == false)) {
            if (returnPath(pos, targetNum)) {

                return;
            }
            find(new int[]{pos[0], pos[1] - 1}, targetNum + 1);
        }
//        上
        if ((pos[0] - 1 >= 0) && (array[pos[0] - 1][pos[1]] == target[targetNum]) && (flags[pos[0] - 1][pos[1]] == false)) {
            if (returnPath(pos, targetNum)) {

                return;
            }
            find(new int[]{pos[0] - 1, pos[1]}, targetNum + 1);
        }
        if (returnPath(pos, targetNum)) {

            return;
        }
    }

    /**
     * 查询是否已经找到了整条路径，如果找到了则给path数组设置路径
     */
    private boolean returnPath(int[] pos, int targetNum) {
        if ((path[target.length - 1][0] != 0) && (path[target.length - 1][1] != 0)) {
            path[targetNum - 1][0] = pos[0];
            path[targetNum - 1][1] = pos[1];
            return true;
        }
        return false;
    }
}
