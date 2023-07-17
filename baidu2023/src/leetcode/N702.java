package leetcode;

/**
 * 二分查找
 */
public class N702 {
    int[] nums;
    int target;
    boolean find = false;

    public int search(int[] nums, int target) {
        this.target = target;
        this.nums = nums;
        return findTarget1(0, nums.length - 1);
    }

    public static void main(String[] args) {
        System.out.println(new N702().search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
    }

    /**
     * 递归解法
     *
     * @param left
     * @param right
     * @return
     */
    public int findTarget(int left, int right) {
        if (left == right) {
            return nums[left] == target ? left : -1;
        }
        int leftV = findTarget(left, (left + right) >> 1);
        int rightV = findTarget(((left + right) >> 1) + 1, right);
        return Math.max(leftV, rightV);
    }

    /**
     * 非递归解法
     *
     * @param left
     * @param right
     * @return
     */
    public int findTarget1(int left, int right) {
        while (left <= right) {
            int middle = (left + right) >> 1;
            if (target < nums[middle]) {
                right = middle - 1;
            } else if (target > nums[middle]) {
                left = middle + 1;
            } else if (target == nums[middle]) {
                return middle;
            }
        }
        return -1;
    }
}
