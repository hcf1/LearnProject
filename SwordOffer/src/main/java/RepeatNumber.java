import java.util.HashSet;

/**
 * @author hasee
 */
public class RepeatNumber {
    /**
     * 使用先排序再找重复数字的方法，时间复杂度O(nlogn)，空间复杂度为O(1)
     **/
    static class FindRepeatNumberBySort {
        /**
         * @param array 待处理的数组
         * @date 2020.4.26
         */
        void findRepeatNumber(int[] array) {
            QuickSort(array, 0, array.length - 1);
            for (int i = 0; i < array.length - 1; ++i) {
                if (array[i] == array[i + 1]) {
                    System.out.println(array[i]);
                    return;
                }
            }
        }

        void QuickSort(int[] array, int left, int right) {
            if (right - left > 2) {
                int mid = partition(array, left, right);
                QuickSort(array, left, mid - 1);
                QuickSort(array, mid + 1, right);
            } else {
                if (right - left == 2) {
                    if (array[left] > array[right]) {
                        swap(array, left, right);
                    }
                }
            }
        }

        void swap(int[] array, int a, int b) {
            int tmp = array[a];
            array[a] = array[b];
            array[b] = tmp;
        }

        int partition(int[] array, int left, int right) {
            int pivot = array[right];
            right -= 1;
            while (left < right) {
                while (array[left] < pivot) {
                    left++;
                }
                while (array[right] > pivot && right > 0) {
                    right--;
                }
                if (left < right) {
                    swap(array, left, right);
                    left++;
                    right--;
                } else {
                    int mid = left;
                    swap(array, left, array.length - 1);
                    return mid;
                }
            }
            swap(array, left, array.length - 1);
            return left;
        }
    }

    /**
     * 使用hashSet查找重复数字，时间复杂度O(n)，空间复杂度为O(n)
     */
    static class FindRepeatNumberBySet {
        void findRepeatNumber(int[] array) {
            HashSet set = new HashSet();
            for (int i : array) {
                if (set.add(i)) {

                } else {
                    System.out.println(i);
                }
            }
        }
    }

    /**
     * 因为n个数字的取值范围为0~n-1，所以可以先将值为k的数组元素放到位置k。如果在放入元素时遇到目标位置的元素和待放入的元素值相等，
     * 那么就出现了重复数字
     */
    static class FindRepeatNumberByLocation {
        void findRepeatNumber(int[] array) {
            //防止不符合要求的数组元素传入
            for (int i = 0; i < array.length; ++i) {
                if (array[i] < 0 || array[i] > array.length - 1) {
                    return;
                }
            }
            int i = 0;
            while (i < array.length) {
                if (array[i] == i) {
                    i++;
                } else {
                    if (array[i] == array[array[i]]) {
                        System.out.println(array[i]);
                        return;
                    } else {
                        int temp;
                        temp = array[i];
                        array[i] = array[array[i]];
                        array[temp] = temp;
                    }
                }
            }
        }
    }

}
