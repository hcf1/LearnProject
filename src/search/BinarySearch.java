package search;

public class BinarySearch {
    static int search(int[] list, int target) {
        if (list == null || list.length == 0) {
            return -1;
        }
        int left = 0, right = list.length - 1;
        while (left <= right) {
            int mid =(right + left) >> 1;
            if (list[mid] == target) {
                return mid;
            }
            if (target < list[mid]) {
                right = mid - 1;
            }
            if (target > list[mid]) {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(String.valueOf(BinarySearch.search(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 5)));
    }
}
