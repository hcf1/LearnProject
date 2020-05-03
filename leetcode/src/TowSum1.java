import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

public class TowSum1 {
    public static void main(String[] args) {
        class Solution {
            public int[] twoSum(int[] nums, int target) {
                int[] a = new int[2];
                for (int i = 0; i < nums.length; i++) {
                    for (int j = i + 1; j < nums.length; j++) {
                        if (nums[i] + nums[j] == target) {
                            a[0] = i;
                            a[1] = j;
                            break;
                        }
                    }
                }
                return a;
            }
        }
        class SolutionTwoHashMap {
            public int[] twoSum(int[] nums, int target) {
                HashMap<Integer, Integer> map = new HashMap<>();
                for (int i = 0; i < nums.length; i++) {
                    map.put(nums[i], i);
                }
                for (int i = 0; i < nums.length; i++) {
                    int complement = target - nums[i];
                    if (map.containsKey(complement) && i != map.get(complement)) {
                        return new int[]{map.get(complement), i};
                    }
                }
                return null;
            }
        }
        class SolutionOneHashMap {
            public int[] twoSum(int[] nums, int target) {
                HashMap<Integer, Integer> map = new HashMap<>();
                for (int i = 0; i < nums.length; i++) {
                    int complement = target - nums[i];
                    if (map.containsKey(complement) && i != map.get(complement)) {
                        return new int[]{map.get(complement), i};
                    }
                    map.put(nums[i],i);
                }
                return null;
            }
        }
        SolutionOneHashMap solution = new SolutionOneHashMap();
        System.out.println(Arrays.toString(solution.twoSum(new int[]{2, 7, 11, 15}, 9)));
    }
}
