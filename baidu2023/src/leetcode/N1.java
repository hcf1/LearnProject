package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 */
public class N1 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new N1().twoSum2(new int[]{3, 2, 4}, 6)));
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int[] array = map.get(nums[i]);
                array[1] = i;
                map.put(nums[i], array);
            } else {
                map.put(nums[i], new int[]{i, -1});
            }
        }
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] > target) {
                right--;
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else {
                if (nums[left] == nums[right]) {
                    return new int[]{map.get(nums[left])[0], map.get(nums[left])[1]};
                }
                return new int[]{map.get(nums[left])[0], map.get(nums[right])[0]};
            }
        }
        return new int[0];
    }

    /**
     * hash表
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
