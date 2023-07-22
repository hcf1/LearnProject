package leetcode;

/**
 * 寻找两个正序数组的中位数
 */
public class N4 {
    public static void main(String[] args) {
        System.out.println(new N4().findMedianSortedArrays(new int[]{3}, new int[]{-2, -1}));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] newArray = new int[nums1.length + nums2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]) {
                newArray[k] = nums1[i];
                i++;
                k++;
            } else if (nums1[i] > nums2[j]) {
                newArray[k] = nums2[j];
                j++;
                k++;
            }
        }
        while (i < nums1.length) {
            newArray[k] = nums1[i];
            i++;
            k++;
        }
        while (j < nums2.length) {
            newArray[k] = nums2[j];
            j++;
            k++;
        }
        if (newArray.length % 2 == 0) {
            return (newArray[newArray.length / 2 - 1] + newArray[newArray.length / 2]) / 2f;
        } else {
            return newArray[newArray.length / 2];
        }
    }
}
