public class BinaryTreeMaximumPath124 {
    int maxPathGlobal = Integer.MIN_VALUE;

    public static void main(String[] args) {
        BinaryTreeMaximumPath124 binaryTreeMaximumPath124 = new BinaryTreeMaximumPath124();
        TreeNode treeNode = binaryTreeMaximumPath124.createTree(new int[]{1,2,3});
        System.out.println(binaryTreeMaximumPath124.findMax(treeNode));
    }

    int findMax(TreeNode treeNode) {
        findMaxPathCore(treeNode);
        return maxPathGlobal;
    }

    private int findMaxPathCore(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        int leftPath = Math.max(findMaxPathCore(treeNode.left), 0);
        int rightPath = Math.max(findMaxPathCore(treeNode.right), 0);
        int maxPath = treeNode.val + leftPath + rightPath;
        maxPathGlobal = Math.max(maxPath, maxPathGlobal);
        return treeNode.val + Math.max(Math.max(leftPath, rightPath), 0);//注意，如果树还要向上延伸，则不能同时算两个子树
    }

    TreeNode createTree(int[] list) {
        if (list != null && list.length > 0) {
            return createCore(list, 0);
        } else return null;
    }

    private TreeNode createCore(int[] list, int pos) {
        if (pos < list.length) {
            TreeNode newNode = new TreeNode(list[pos]);
            newNode.left = createCore(list, pos * 2 + 1);
            newNode.right = createCore(list, pos * 2 + 2);
            return newNode;
        }
        return null;
    }
}

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}
