package other;

import java.util.Arrays;

public class Quuen8 {

    // 八皇后问题，在一个8×8的国际象棋棋盘上摆放8个皇后，摆放需遵守皇后不能处于同一行、同一列、同一斜线上，问有多少种摆法
    int max = 8;//皇后个数
    static int count = 0;//记录有多少种摆法
    // 初始化一个数组用于存放结果
    /*
     * 这里用一维数组存放数据就可以了，这里一维数组中的值存放的是皇后的列坐标，
     * 因为规定皇后是不能摆放在同一行，所以每一行只有一个皇后 ； 一维数组 arr
     * 的第一个值就是 棋盘第一行皇后的列坐标值，第二个值就是皇后在棋盘第二行的列坐标值
     */
    int[] arr = new int[max];

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Quuen8 quuen = new Quuen8();
        quuen.putQuuen(0);
        System.out.println("共有" + count + "种摆法");
    }

    //写一个摆皇后的方法
    private void putQuuen(int n) {
        if (n == max) {//因为n是从0开始增加，即n=0表示放第一个皇后，当n==max时表示皇后已经摆完了
            print();
            return;
        }
        for (int i = 0; i < max; i++) {
            arr[n] = i;//放置第一个皇后
            if (judge(n)) {//判断皇后的位置是否冲突，不冲突继续放下一个皇后
                putQuuen(n + 1);
            }
        }
    }


    // 写一个方法，判断皇后在该位置是否会引起冲突，即在同一行或同一列或同一斜线
    private boolean judge(int n) {
        for (int i = 0; i < n; i++) {

            /*
             * 1. 判断 皇后是否在同一列，只需判断皇后的列坐标是否相等即可，即arr[i] == arr[n]
             * 2.判断皇后是否在同一斜线上，只需判断两个皇后的列坐标之差的绝对值与其横坐标之差的绝对值是否相等即可，
             *   即Math.abs(n - i) == Math.abs(arr[i] - arr[n])
             *  */
            if (arr[i] == arr[n] || Math.abs(n - i) == Math.abs(arr[i] - arr[n])) {
                return false;//违反了规则，返回false
            }
        }
        return true;
    }

    //输出
    private void print() {
        // TODO Auto-generated method stub
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        count++;
        System.out.println();
    }
}

/**
 * 自己练习写一个八皇后
 */
class Quuen81 {
    public static int max = 8;
    public static int[] result = new int[max];
    public static int num = 0;

    public static void main(String[] args) {
        findQueen(0);
        System.out.println(num);
    }

    public static void findQueen(int n) {
        if (n == max) {
            // 成功找到一种方式
            System.out.println(Arrays.toString(result));
            num++;
        } else {
            // 由于行、列需要不同，所以每一行必定有且只能放一个
            for (int i = 0; i < max; i++) {
                // 先放下，再判断是否冲突
                result[n] = i;
                // 判断当前行是否能放一个
                if (valid(n)) {
                    findQueen(n + 1);
                }
            }
        }
    }

    public static boolean valid(int n) {
        // 遍历前n行，判断每一个的列、对角线是否符合要求
        for (int i = 0; i < n; i++) {
            if (result[i] == result[n] || Math.abs(i - n) == Math.abs(result[i] - result[n])) {
                return false;
            }
        }
        return true;
    }
}