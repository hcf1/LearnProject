public class findInTowDimensionalTest {
    public static void main(String[] args) {
        boolean result = FindInTowDimensional.findInTowDimensional
                (new int[][]{{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}}, 7);
        System.out.println(result);
    }
}
