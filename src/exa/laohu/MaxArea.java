package exa.laohu;

/**
 * 老虎笔试题
 * 在全是0、1的矩阵中找一个由1组成的矩形，求矩形的最大面积
 * 未通过
 */
//todo laohu
public class MaxArea {
    public static void main(String[] args) {
        findMax(new int[][]{{1, 0, 1, 1}, {0, 1, 0, 1}, {1, 1, 1, 1}, {0, 1, 1, 0}});
    }

    static int findMax(int[][] list) {
        int left = 0, right = 0, top = 0, bottom = 0;
        int area[][] = new int[list.length][list[0].length];
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list[0].length; j++) {
                left = j;
                right = j;
                top = i;
                bottom = i;
                while (bottom < list.length && list[bottom][j] != 0) {
                    bottom++;
                }
                while (right < list[0].length && list[i][right] != 0) {
                    right++;
                }
                area[i][j] = (bottom - top) * (right - left);
            }
        }
        return 0;
    }
}
