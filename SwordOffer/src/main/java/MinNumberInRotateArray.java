/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个 非递减 排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组 {3, 4, 5, 1, 2} 为 {1, 2, 3, 4, 5} 的一个旋转，该数组的最小值为 1。
 * 思路：利用二分查找，p1,p2分别指向数组两端，中间值大于等于p1，则中间值在前一个递增序列，然后将p1指向中间值。
 * 若中间值小于等于p2，则中间值在后一个递增序列，将p2指向中间值。最后p1与p2相邻，p2指向的值就是第二个序列的开头，也就是最小值
 * 假设：中间值等于p1,但是中间值在后一个递增序列，那么p1一定等于p2,；中间值等于p2，但中间值位于前一个递增序列，那么p1等于p2；
 * 对于p1=p2=中间值，这样无法划分子序列，所以只能用遍历的方式查找最小值
 *
 * @author hasee
 */
public class MinNumberInRotateArray {
    Integer findMin(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        if (array.length == 1) {
            return array[0];
        }
        if (array.length == 2) {
            if (array[0] <= array[1]) {
                return array[0];
            } else {
                return array[1];
            }
        }
        int p1 = 0, p2 = array.length - 1, mid = (p1 + p2) / 2;
        //前中后指针的值相等，无法划分子序列，采用遍历
        if (array[p1] == array[mid] && array[mid] == array[p2]) {
            int min = array[0];
            for (int i = 1; i < array.length; i++) {
                if (array[i] < min) {
                    min = array[i];
                }
            }
            return min;
        }
        //处理本来就是有序的情况:p1<=mid<p2或p1<mid<=p2
        if (((array[p1] <= array[mid]) && (array[mid] < array[p2])) || ((array[p1] <= array[mid]) && (array[mid] < array[p2]))) {
            return array[0];
        }
        //当p1与p2相邻时结束循环
        while (p2 - p1 != 1) {
            if (array[mid] >= array[p1]) {
                p1 = mid;
            } else {
                p2 = mid;
            }
            mid=(p1 + p2) / 2;
        }
        return array[p2];
    }
}
