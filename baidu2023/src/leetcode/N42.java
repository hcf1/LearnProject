package leetcode;

/**
 * 接雨水
 */
public class N42 {
    public static void main(String[] args) {
        System.out.println(new N42().trap4(new int[]{4, 2, 0, 3, 2, 5}));
    }

    int[] height;

    /**
     * 暴力按行计算
     */
    public int trap(int[] height) {
        this.height = height;
        if (height.length <= 1) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int currentLevel = 0;
        int result = 0;
        while (left < right) {
            if (height[right] > currentLevel && height[left] > currentLevel) {
                currentLevel++;
                result += findWaterByLevel(currentLevel, left + 1, right - 1);
            } else if (height[left] <= currentLevel) {
                left++;
            } else if (height[right] <= currentLevel) {
                right--;
            }
        }
        return result;
    }

    // 找到当前层可装的雨水量
    public int findWaterByLevel(int level, int left, int right) {
        int count = right - left + 1;
        while (left <= right) {
            if (height[left] >= level) {
                count--;
            }
            left++;
        }
        return count;
    }

    /**
     * 按列计算
     */
    public int trap1(int[] height) {
        this.height = height;
        if (height.length <= 1) {
            return 0;
        }
        int result = 0;
        for (int i = 1; i < height.length - 1; i++) {
            // 查找左边最高列
            int leftMax = 0;
            for (int left = 0; left < i; left++) {
                leftMax = Math.max(height[left], leftMax);
            }
            // 查找右边最高列
            int rightMax = 0;
            for (int right = i + 1; right < height.length; right++) {
                rightMax = Math.max(height[right], rightMax);
            }
            if (leftMax > height[i] && rightMax > height[i]) {
                result += Math.min(leftMax, rightMax) - height[i];
            }
        }
        return result;
    }

    /**
     * 按列计算、动态规划，存储每一列的左侧最高列、右侧最高列
     * leftMax(i)=max(leftMax(i-1),height[i-1])
     * rightMax(i)=max(rightMax(i+1),height[i+1])
     */
    public int trap2(int[] height) {
        this.height = height;
        if (height.length <= 1) {
            return 0;
        }
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];
        for (int i = 1; i < height.length; i++) {
            maxLeft[i] = Math.max(height[i - 1], maxLeft[i - 1]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
            maxRight[i] = Math.max(height[i + 1], maxRight[i + 1]);
        }
        int result = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int min = Math.min(maxLeft[i], maxRight[i]);
            if (height[i] < min) {
                result += (min - height[i]);
            }
        }
        return result;
    }

    /**
     * 优化空间
     * 按列计算、动态规划，存储每一列的左侧最高列、右侧最高列
     * leftMax(i)=max(leftMax(i-1),height[i-1])
     * rightMax(i)=max(rightMax(i+1),height[i+1])
     */
    public int trap3(int[] height) {
        this.height = height;
        if (height.length <= 1) {
            return 0;
        }
        int maxLeft = 0;
        int[] maxRight = new int[height.length];
        for (int i = height.length - 2; i >= 0; i--) {
            maxRight[i] = Math.max(height[i + 1], maxRight[i + 1]);
        }
        int result = 0;
        for (int i = 1; i < height.length - 1; i++) {
            maxLeft = Math.max(maxLeft, height[i - 1]);
            int min = Math.min(maxLeft, maxRight[i]);
            if (height[i] < min) {
                result += (min - height[i]);
            }
        }
        return result;
    }

    /**
     * 优化空间2，双指针遍历
     * 按列计算、动态规划，存储每一列的左侧最高列、右侧最高列
     * leftMax(i)=max(leftMax(i-1),height[i-1])
     * rightMax(i)=max(rightMax(i+1),height[i+1])
     */
    public int trap4(int[] height) {
        if (height.length <= 1) {
            return 0;
        }
        int maxLeft = 0;
        int maxRight = 0;
        int left = 0;
        int right = height.length - 1;
        int result = 0;
        while (left < right) {
            maxLeft = Math.max(maxLeft, height[left]);
            maxRight = Math.max(maxRight, height[right]);
            if (maxLeft < maxRight) {
                // 处理left
                if (height[left] < maxLeft) {
                    result += (maxLeft - height[left]);
                }
                // 已经被处理过了，所以要++
                left++;
            } else {
                // 处理right
                if (height[right] < maxRight) {
                    result += (maxRight - height[right]);
                }
                right--;
            }
        }
        return result;
    }
}
