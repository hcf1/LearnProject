package search;

public class BinarySearch1 {
    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{1,2,3,4,5,6},0,5,4));
    }

    static Integer binarySearch(int[] list, int left, int right, int target) {
        if (list == null || list.length == 0) {
            return null;
        }
        int mid = (left + right) >> 1;
        for (; mid < right; ) {
            if (list[mid] == target) {
                return mid;
            }
            if (list[mid] > target) {
                mid = (mid + left) >> 1;
            } else {
                mid = (mid + right) >> 1;
            }
        }
        return null;
    }
}
