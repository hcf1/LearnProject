package main;

/**
 * 给一个非空数组，将之分为两个子集，判断是否可以让两个子集相等
 */
public class SonOfPack01 {
    public static void main(String[] args) {
        isEqual(new int[]{1, 5, 11, 5});
    }

    static boolean isEqual(int[] list) {
        int sum = 0;
        for (int n : list) {
            sum += n;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int half = sum / 2;
        boolean[][] f = new boolean[list.length + 1][half + 1];
        for (int i = 0; i <= list.length; i++) {
            f[i][0] = true;
        }
        for (int i = 1; i <= list.length; i++) {
            for (int j = 0; j <= half; j++) {
                if (j < list[i - 1]) {
                    f[i][j] = f[i - 1][j];
                } else {
                    f[i][j] = f[i - 1][j] || f[i - 1][j - list[i - 1]];//加上或者不加上，只要有一个f[i][0]，都表示刚好可以达到此值
                }
            }
        }
        return f[list.length][half];
    }
}
