package leetcode;

import java.util.Arrays;
import java.util.PrimitiveIterator;

/**
 * 部分排序
 */
public class N16_16 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(subSort(new int[]{1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19})));
        System.out.println(Arrays.toString(subSort1(new int[]{1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19})));
    }

    /**
     * 排序超时
     */
    public static int[] subSort(int[] array) {
        int[] sortedArray = array.clone();
        getSorted(sortedArray);
        int head = 0;
        int tail = array.length - 1;
        while (head < array.length) {
            if (sortedArray[head] == array[head]) {
                head++;
            } else {
                break;
            }
        }
        while (tail > 0 && head < tail) {
            if (sortedArray[tail] == array[tail]) {
                tail--;
            } else {
                break;
            }
        }
        if (head >= tail) {
            head = -1;
            tail = -1;
        }
        return new int[]{head, tail};
    }

    public static void getSorted(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = i; j > 0; j--) {
                if (array[j - 1] > array[j]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
    }

    /**
     * 滑动窗口法
     */
    public static int[] subSort1(int[] array) {
        int n = array.length, left = 0, right = n - 1;
        while (left < right) {
            if (array[left] <= array[left + 1]) {
                ++left;
            }
            if (array[right] >= array[right - 1]) {
                --right;
            }
            if (array[left] > array[left + 1] && array[right] < array[right - 1]) {
                break;
            }
        }
        if (left >= right) {
            return new int[]{-1, -1};
        }
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i = left; i <= right; ++i) {
            max = Math.max(max, array[i]);
            min = Math.min(min, array[i]);
        }
        while (left > 0 && array[left - 1] > min) {
            --left;
        }
        while (right < n - 1 && array[right + 1] < max) {
            ++right;
        }
        return new int[]{left, right};
    }
}
