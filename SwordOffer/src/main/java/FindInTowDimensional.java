/**
 * 在二维数组中查找
 * 思路一：依次遍历查找，时间复杂度O(mn)，空间复杂度O(1)
 * 思路二：从上到下遍历，对每一行执行二分查找。时间复杂度O(mlogn)，空间复杂度O(1)
 * 思路三：沿对角线遍历，找到对角线上比目标数小的前一个数，以此为基准分别向下和向右遍历。时间复杂度O(m+n)，空间复杂度O(1)
 * 如果在纵向和横向遍历时采用二分查找，时间复杂度可以缩短至O(max(m.n))
 *
 * @author hasee
 */
public class FindInTowDimensional {
    static Boolean findInTowDimensional(int[][] array, int target) {
        int rows = array.length;
        int columns = array[0].length;
        for (int i = 0; i < Math.min(rows, target) - 1; ++i) {
            int p = array[i + 1][i + 1];
            if (p > target) {
                //向右遍历
                for (int right = i; right < columns; right++) {
                    if (array[i][right] == target) {
                        return true;
                    }
                } //向下遍历
                for (int down = i + 1; down < rows; down++) {
                    if (array[down][i] == target) {
                        return true;
                    }
                }
            }
        }
        if (array[Math.min(rows, target) - 1][Math.min(rows, target) - 1] == target) {
            return true;
        }
        return false;
    }

    /**
     * 正式批
     */
    static class FindInTowDimensional1 {
        static boolean find(int[][] list, int target) {
            int diagonal = 0;
            for (; diagonal < Math.min(list.length, list[0].length); diagonal++) {
                int diagonalNum = list[diagonal][diagonal];
                if (diagonalNum < target) {
                    diagonal++;
                } else if (diagonalNum == target) {
                    return true;
                } else {
                    break;
                }
            }//回退到对角线上一个数，开始向下遍历
            int row = diagonal - 1;
            int column = row;
            for (; row < list.length; row++) {
                if (list[row][column] == target) {
                    return true;
                } else if (list[row][column] > target) {
                    return false;
                }
            }
            return false;
        }
    }
}
