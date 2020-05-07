public class FindNextTreeBinaryTreeNodeTest {
    public static void main(String[] args) {
        FindNextTreeBinaryTreeNode.BinaryTreeNode root=createBinaryTree();
        //中序3，4，2，5，9，1，6，3，7，root代表输入1，将返回root的下一个节点6
        System.out.println(FindNextTreeBinaryTreeNode.findNextTreeBinaryTreeNode(root).value);
    }

    private static FindNextTreeBinaryTreeNode.BinaryTreeNode createBinaryTree() {
        FindNextTreeBinaryTreeNode.BinaryTreeNode root = new FindNextTreeBinaryTreeNode.BinaryTreeNode(1);
        FindNextTreeBinaryTreeNode.BinaryTreeNode p = root;
//        初始化第二层
        root.left = new FindNextTreeBinaryTreeNode.BinaryTreeNode(2);
        root.right = new FindNextTreeBinaryTreeNode.BinaryTreeNode(3);
        root.left.father = root;
        root.right.father = root;
//        初始化第三层
        root = root.left;
        root.left = new FindNextTreeBinaryTreeNode.BinaryTreeNode(4);
        root.right = new FindNextTreeBinaryTreeNode.BinaryTreeNode(5);
        root.left.father = root;
        root.right.father = root;
        root = p.right;
        root.left = new FindNextTreeBinaryTreeNode.BinaryTreeNode(6);
        root.right = new FindNextTreeBinaryTreeNode.BinaryTreeNode(7);
        root.left.father = root;
        root.right.father = root;
//        初始化第四层
        root = p.left.right;
        root.left = new FindNextTreeBinaryTreeNode.BinaryTreeNode(8);
        root.right = new FindNextTreeBinaryTreeNode.BinaryTreeNode(9);
        root.left.father = root;
        root.right.father = root;
        root = p;
        return root;
//        333
    }
}