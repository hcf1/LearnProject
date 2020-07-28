import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

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
     * 那么就出现了重复数字，时间复杂度O(n)，空间复杂度为O(1)
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

    static class findRepeatNumber {
        void find(int[] list) {
            int pos = 0;
            while (pos < list.length) {
                if (list[pos] != pos) {
                    if (list[pos] == list[list[pos]]) {
                        System.out.printf("重复:"+list[pos]);
                        break;
                    }
                    swap(list, pos, list[pos]);
                } else {
                    pos++;
                }
            }
        }

        void swap(int[] list, int left, int right) {
            int temp = list[left];
            list[left] = list[right];
            list[right] = temp;
        }
    }

    /**
     * 题目二
     * 不修改数组找出重复的数字。
     * 在一个长度为 n+1 的数组里的所有数字都在 1 到 n 的范围内。 所以数组中至少有一个数字是重复的。请找出数组中任意一个重复的数字。
     * 但不能修改输入的数组。例如，如果输入长度为 7 的数组 {2, 3, 5, 4, 3, 2, 6, 7}，那么对应的输出是第一个重复的数字 2 或 3 。
     * <p>
     * 思路一（时间复杂度为O(n),空间复杂度为O(n)）
     * hashSet
     * 思路二（时间复杂度为O(nlogn),空间复杂度为O(1)）
     * 我们把从 1 到 n 的数字从中间的数字 m 分为两步，前面一半为 1 到 m ，后面一半为 m+1 到 n 。如果 1 到 n 的数字的数目超过 m ，
     * 那么这一半里面一定包含重复的数字；否则另一半 m+1 到 n 的区间里一定包含重复的数字。
     */
    static class FindRepeatNumberByLocation2 {
        void findRepeatNumber(int[] array, int left, int right) {
            if (left < right) {
                int mid = (right + left) >> 1;
                int count = getCount(array, left, mid);
                //值在left~mid的元素个数大于left...mid的个数，则说明有重复的
                if (count > mid - left + 1) {
                    if (mid - left == 0) {
                        System.out.println(left);
                        return;
                    }
                    findRepeatNumber(array, left, mid);
                } else {
                    findRepeatNumber(array, mid + 1, right);
                }
            } else {
                System.out.println(left);
                ArrayList<Integer> arrayList = new ArrayList();
                arrayList.sort((a, b) -> {
                    return a > b ? 0 : 1;
                });
            }
        }
        //判断元素是否符合要求

        /**
         * 求数组中的元素值在left~mid区间内的数量
         */
        int getCount(int[] array, int left, int mid) {
            int count = 0;
            for (int i = 0; i < array.length; ++i) {
                if (array[i] >= left && array[i] <= mid) {
                    count++;
                }
            }
            return count;
        }
    }

}
