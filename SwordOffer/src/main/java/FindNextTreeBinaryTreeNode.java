/**
 * 找到二叉树中序遍历节点的下一个节点
 * 思路：
 * 1.有右节点:右子树的最左节点
 * 2.只有左节点:父节点
 * 3.左叶子节点:父节点
 * 4.右叶子节点:向上回溯到父节点，此父节点是爷节点的左节点，返回爷爷节点。
 * 时间复杂度O(logn),对于情况4，最多向上回溯树的高度。空间复杂度O(1)
 * @author hasee
 */
public class FindNextTreeBinaryTreeNode {
    static BinaryTreeNode findNextTreeBinaryTreeNode(BinaryTreeNode node) {
        if (node == null) {
            return null;
        }
//        情况1
        if (node.right != null) {
            BinaryTreeNode p = node.right;
            while (p.left != null) {
                p = p.left;
            }
            return p;
        }
//        情况2、3(当前节点是左子节点)
        else if ((node.father != null) && (node.father.left == node)) {
            return node.father;
        }
//        情况4
        else if ((node.father != null) && (node.father.right == node)) {
            BinaryTreeNode p = node.father;
            while (p == p.father.left) {
                return p.father;
            }
        }
        return null;
    }

    static class BinaryTreeNode {
        int value;
        BinaryTreeNode father;
        BinaryTreeNode left;
        BinaryTreeNode right;

        BinaryTreeNode(int value) {
            this.value = value;
        }
    }
}
