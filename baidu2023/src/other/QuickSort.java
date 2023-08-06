package other;

/**
 * 数组快排
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 1, 3, 2, 5};
        new QuickSort().sort(nums, 0, 4);
        for (int n : nums) {
            System.out.print(n);
        }
    }

    public void sort(int[] nums, int left, int right) {
        if (left == right) {
            return;
        }
        if (left == right - 1) {
            if (nums[left] > nums[right]) {
                swap(nums, left, right);
            }
            return;
        }
        int pivot = getPivot(nums, left, right);
        sort(nums, left, pivot - 1);
        sort(nums, pivot + 1, right);
    }

    public int getPivot(int[] nums, int left, int right) {
        int p = nums[left];
        int i = left; // 取第一个为pivot
        left++;
        while (left < right) {
            while (left < right && nums[right] >= p) { // 就要先从后往前走
                right--;
            }
            while (left < right && nums[left] <= p) {
                left++;
            }
            swap(nums, left, right);
        }
        swap(nums, i, left);
        return left;
    }

    public void swap(int[] nums, int a, int b) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }

    void quickSort(int[] nums, int l, int r) {
        // 子数组长度为 1 时终止递归
        if (l >= r) return;
        // 哨兵划分操作
        int i = partition(nums, l, r);
        // 递归左（右）子数组执行哨兵划分
        quickSort(nums, l, i - 1);
        quickSort(nums, i + 1, r);
    }

    int partition(int[] nums, int l, int r) {
        // 以 nums[l] 作为基准数
        int i = l, j = r;
        while (i < j) {
            while (i < j && nums[j] >= nums[l]) j--;
            while (i < j && nums[i] <= nums[l]) i++;
            swap(nums, i, j);
        }
        swap(nums, i, l);
        return i;
    }
}
