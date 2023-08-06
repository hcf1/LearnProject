package leetcode;

import other.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class N06 {
    int[] inorder;
    int[] postorder;
    Map<Integer, Integer> value2Index = new HashMap();

    public static void main(String[] args) {
        TreeNode root = new N06().buildTree(new int[]{1, 2, 3, 4}, new int[]{2, 1, 4, 3});
        System.out.println(root);
    }

    /**
     * 通过中序/后序遍历表构建树
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        if (inorder == null || postorder == null) {
            return null;
        }
        if (inorder.length != postorder.length || inorder.length == 0) {
            return null;
        }
        for (int i = 0; i < inorder.length; i++) {
            value2Index.put(inorder[i], i);
        }
        TreeNode root = buildSubTree(0, inorder.length - 1, 0, postorder.length - 1);
        return root;
    }

    public TreeNode buildSubTree(int inl, int inr, int pl, int pr) {
        if (inl > inr) {
            return null;
        } else if (inl == inr) {
            return new TreeNode(inorder[inl], null, null);
        } else {
            // 当需要重新获取中点时，才使用poster
            int rootIndex = value2Index.get(postorder[pr]);
            int leftLength = rootIndex - 1 - inl;
            return new TreeNode(
                    postorder[pr],
                    buildSubTree(inl, rootIndex - 1, pl, pl + leftLength),
                    buildSubTree(rootIndex + 1, inr, pl + leftLength + 1, pr - 1)
            );
        }
    }
}
