package search;

public class BinarySearch1 {
    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{1, 2, 3, 4, 5, 6}, 4));
    }

    static Integer binarySearch(int[] list, int target) {
        if (list == null || list.length == 0) {
            return null;
        }
        int left = 0, right = list.length - 1, mid = 0;
        for (; left <= right; ) {
            mid = (left + right) >> 1;
            if (list[mid] == target) {
                return mid;
            }
            if (list[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return null;
    }
}
