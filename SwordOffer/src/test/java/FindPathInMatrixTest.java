
class FindPathInMatrixTest {
    public static void main(String[] args) {
        FindPathInMatrix findPathInMatrix = new FindPathInMatrix(new char[][]{{'a', 'b', 't', 'g'}, {'c', 'f', 'c', 's'},
                {'j', 'd', 'e', 'h'}}, new char[]{'b', 'f', 'c', 'e'});
        findPathInMatrix.findPath();
        int[][] paths = findPathInMatrix.getPath();
        if (paths == null) {
            System.out.println("未找到路径！");
            return;
        }
        for (int[] path : paths) {
            System.out.print("->(" + path[0] + ',' + path[1] + ")");
        }
        /**
         * 正式批
         * */
        System.out.println("");
        FindPathInMatrix1 findPathInMatrix1 = new FindPathInMatrix1();
        findPathInMatrix1.findPath(new char[][]{{'a', 'b', 't', 'g'}, {'c', 'f', 'c', 's'},
                {'j', 'd', 'e', 'h'}}, new char[]{'b', 'f', 'c', 'e'});
    }
}