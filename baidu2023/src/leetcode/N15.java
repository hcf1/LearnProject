package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 三数之和
 */
public class N15 {
    public static void main(String[] args) {
        System.out.println(new N15().threeSum(new int[]{-2,0,1,1,2}));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList();
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right && right < nums.length) {
                int num = nums[i] + nums[left] + nums[right];
                if (num == 0) {
                    List<Integer> target = new ArrayList();
                    target.add(nums[i]);
                    target.add(nums[left]);
                    target.add(nums[right]);
                    result.add(target);
                    while (left+1<right&&nums[left+1]==nums[left])left++;
                    while (right-1<left&&nums[right-1]==nums[right])right--;
                    left++;
                    right--;
                } else if (num < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
}
